package runtime.interpreter;

import java.util.List;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Stack;

import org.antlr.runtime.tree.CommonTree;
import org.hamcrest.core.IsAnything;

import runtime.memoization.Memoization;
import runtime.memoization.Result;
import semantics.Attribute;
import semantics.Function;
import semantics.Grammar;
import semantics.NonTerminal;
import semantics.SemanticNode;
import srcparser.AdaptablePEGLexer;

public class Interpreter {
	
	private Grammar grammar;

	private FileReader input;
	private ArrayList<Character> buf;
	Stack<Environment> environments;	
	private static final char EOF = (char) -1;

	private Memoization memoization;
	
	public Interpreter(Grammar grammar) {
		this.grammar = grammar;
		buf = new ArrayList<Character>();
		environments = new Stack<Environment>();
		
		memoization = new Memoization();
	}
	

	public void setInputFile(String fileName) throws Exception {
		input = new FileReader(fileName);
	}

	private char read(int pos) throws Exception {
		if (pos < 0) throw new Exception("Index invalid for buffer");
		if (pos < buf.size()) {
			return buf.get(pos);
		}
		char ch = '?';
		// I know it will execute at least one iteration of the next loop,
		// but the compiler does not know it
		/*for (int i = buf.size(); i <= pos; ++i) {
			ch = (char) input.read();
			buf.add(ch);
		}*/
		// So, I have changed for this code :)
		int i = buf.size();
		do {
			ch = (char) input.read();
			buf.add(ch);
			++i;
		} while(i <= pos);
		
		return ch;
	}
	
	private int match(String s, int pos) throws Exception {
		for (int i = 0; i < s.length(); ++i) {
			char ch = read(pos + i);
			char ch2 = s.charAt(i);
			if (ch != ch2) {
				return -1;
			}
		}
		return pos + s.length();
	}

	/**
	 * Execute the current PEG, starting at the nonterminal given.
	 * If the nonterminal has attributes, their values must be all defined in the array args.
	 * If the PEG is adaptable, the first attribute of the initial symbol must be a Grammar.
	 * But the grammar is not passed as an argument in args, it is automatically appended to args as the first argument.
	 * The number of elements in args must be exactly the of sum of the numbers of inhereted and synthesized attributes of the initial symbol, except for the Grammar of an adaptable PEG.
	 * For the synthesized attributes, the values in args may be null.
	 * @param nontermName Name of the initial symbol.
	 * @param args Array of values for the attributes. Empty cells (with null) must be provided for the synthesized attributes. All inhereted attributes come before the synthesized ones.
	 * @return The number of characters processed.
	 * @throws Exception
	 */
	public int execute(String nontermName, Object args[]) throws Exception {
		NonTerminal nt = grammar.getNonTerminal(nontermName);
		if (nt == null) {
			throw new Exception("Nonterminal not found: " + nontermName);
		}
		int nArgs;
		if (args == null) {
			nArgs = 0;
		} else {
			nArgs = args.length;
		}
		Object argsAdaptable[] = null;
		if (grammar.isAdaptable()) {
			if (nt.getNumParam() == 0) {
				throw new Exception("For adaptable PEG, the initial symbol must have a Grammar as first attribute");
			}
			Attribute at1 = nt.getParam(0);
			if (at1.getType().getName().compareTo("Grammar") != 0) {
				throw new Exception("For adaptable PEG, the initial symbol must have a Grammar as first attribute");
			}
			argsAdaptable = args;
			args = new Object[nArgs + 1];
			args[0] = grammar;
			for (int i = 0; i < nArgs; ++i) {
				args[i + 1] = argsAdaptable[i];
			}
			++nArgs;
		}
		if (nArgs != nt.getNumParam() + nt.getNumRet()) {
			throw new Exception("Wrong number of parameters: " + nontermName);
		}		
		Environment env = buildEnvironment(nt);
		for (int i = 0; i < nt.getNumParam(); ++i) {
			env.setValue(i, args[i]);
		}
		environments.push(env);
		int ret = process(nt.getPegExpr(), 0);
		if (ret >= 0) {
			if (grammar.discardChanges()) {
				env = environments.pop();
			}
			int first = nt.getNumParam();
			int last = first + nt.getNumRet();
			for (int i = first; i < last; ++i) {
				if (argsAdaptable != null) {
					argsAdaptable[i - 1] = env.getValue(i);
				} else {
					args[i] = env.getValue(i);		
				}
			}
		}
		return ret;
	}
	
	public Environment buildEnvironment(NonTerminal nt) {
		Environment env = new Environment(nt.numAttrs());
		return env;
	}
	
	public Environment currEnvironment() {
		return environments.peek();
	}


	
	/**
	 * Process an expression, reading the first character at position pos of the input file.
	 * The first call must be with pos=0.
	 * @param tree
	 * @param pos
	 * @return
	 * @throws Exception
	 */
	private int process(CommonTree tree, int pos) throws Exception {
		switch (tree.token.getType()) {
		
		case AdaptablePEGLexer.NONTERM: {
			// I suppose there are 2 children
			NonTerminal nt = (NonTerminal) ((SemanticNode) tree.getChild(0)).getSymbol(); // name of nonterminal
			CommonTree t = (CommonTree) tree.getChild(1); // list of arguments
			
//			System.out.print(nt.getName() + " - " + "pos_ent: " + pos + " Param:");
//			System.out.println(nt.getName() + "<" + t.toStringTree() + ">");
			
			/**
			 * Code for memoization
			 * creating a list with the values of the attributes
			 */
			// List of inherited attributes
			Object[] attr = new Object[nt.getNumParam()];
			
			// code for eval inherited attributes
			for(int i = 0; i < nt.getNumParam(); ++i) {
				Object x = eval((CommonTree)t.getChild(i));
				attr[i] = x;
//				System.out.print(" " + x);
			}
//			System.out.println();
			
			Result result = memoization.getMemoization(nt.getName(), attr, pos);
			if(result != null) {
//				System.out.print("Memoization - next_pos: " + result.getNext_pos() + " Return: ");
				
				// Atualiza os valores do ambiente
				int first = nt.getNumParam();
				int last = first + nt.getNumRet();
				Object[] list = result.getReturns_attr();				
				for(int i = first; i < last; i++) {
					Object x = list[i-first];
//					System.out.print(x + " ");
					SemanticNode y = (SemanticNode) t.getChild(i);
					currEnvironment().setValue(((Attribute) y.getSymbol()).getIndex(), x);
				}
//				System.out.println("----------------");
				return result.getNext_pos();
			}
			// else
			
//			System.out.println("No Memoization\n");
			
			// Creating a environment and populate it
			Environment env = buildEnvironment(nt);		
			for (int i = 0; i < nt.getNumParam(); ++i)
				env.setValue(i, attr[i]);

			environments.push(env);
	
			CommonTree pegExpr;
			if (grammar.isAdaptable()) {
				pegExpr = ((Grammar) environments.peek().getValue(0)).getNonTerminal(nt.getName()).getPegExpr();
			} else {
				pegExpr = nt.getPegExpr();
			}
			
//			System.out.println(pegExpr.toStringTree());

			int ret = process(pegExpr, pos);
			
			env = environments.pop();
			// env may be a different enviroment, because a copy may be pushed
			// when the semantics of CHOICE is pushEnv
			
//			System.out.println("Memoization: " + nt.getName() + " pos: " + pos + " - next_pos: " + ret + " Return: ");
			
			/**
			 * create a List of returns values
			 */
			Object[] result_attr = new Object[nt.getNumRet()];
			if (ret >= 0) {
				int first = nt.getNumParam();
				int last = first + nt.getNumRet();
				for (int i = first; i < last; ++i) {
					Object x = env.getValue(i);		
//					System.out.print(x + " ");
					SemanticNode y = (SemanticNode) t.getChild(i);
					currEnvironment().setValue(((Attribute) y.getSymbol()).getIndex(), x);
					/**
					 * adding Object x on the List
					 */
					result_attr[i-first] = x;
				}
			}
//			System.out.println("----------------");
			/**
			 * memoizationing the value
			 */
			memoization.addMemoization(nt.getName(), attr, pos, ret, result_attr);
			return ret;
		}
		
		case AdaptablePEGLexer.LAMBDA: {
			return pos;
		}
		
		case AdaptablePEGLexer.ANY: {
			char ch = read(pos);
			if (ch != EOF) {
				return pos + 1;
			}
			return -1;
		}
		
		case AdaptablePEGLexer.STRING_LITERAL: {
			return match(tree.token.getText(), pos);
		}
		
		case AdaptablePEGLexer.RANGE: {
			char ch = read(pos);
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				char ch1 = t.token.getText().charAt(0);
				char ch2 = t.token.getText().charAt(2);
				if (ch >= ch1 && ch <= ch2) {
					return pos + 1;
				}
			}
			return -1;
		}
		
		case AdaptablePEGLexer.SEQ: {
			int ret = pos;
			Environment env = null;
			if (grammar.discardChanges()) {
				env = environments.peek().copy();
			}
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				ret = process(t, ret);
				if (ret < 0) {
					if (grammar.discardChanges()) {
						environments.pop();
						environments.push(env);
					}
					return -1;
				}
			}
			return ret;
		}
		
		//TODO
		// insert code for discarding changes in environments, in several operations
		case AdaptablePEGLexer.REPEAT: {
			// I suppose there is exactly one child
			CommonTree t = (CommonTree) tree.getChild(0);
			int ret = pos;
			int ret1;
			Environment env = null;
			while (true) {
				if (grammar.discardChanges()) {
					env = environments.peek().copy();
				}
				ret1 = process(t, ret);
				if (ret1 < 0) {
					if (grammar.discardChanges()) {
						environments.pop();
						environments.push(env);
					}
					return ret;
				}
				ret = ret1;
			}
		}
		
		case AdaptablePEGLexer.ONE_REPEAT: {
			// I suppose there is exactly one child
			CommonTree t = (CommonTree) tree.getChild(0);
			int ret = process(t, pos);
			if (ret < 0) {
				return ret;
			}
			int ret1;
			while (true) {
				ret1 = process(t, ret);
				if (ret1 < 0) {
					return ret;
				}
				ret = ret1;
			}
		}
		
		case AdaptablePEGLexer.OPTIONAL: {
			// I suppose there is exactly one child
			CommonTree t = (CommonTree) tree.getChild(0);
			int ret = process(t, pos);
			if (ret < 0) {
				ret = pos;
			}
			return ret;
		}
		
		case AdaptablePEGLexer.COND: {
			// I suppose there is exactly one child
			CommonTree t = (CommonTree) tree.getChild(0);
			Boolean b = (Boolean) eval(t);
			if (b) {
				return pos;
			} else {
				return -1;
			}
		}

		case AdaptablePEGLexer.CHOICE: {
			// I suppose there are 2 children
			CommonTree t = (CommonTree) tree.getChild(0);
			Environment env = null;
			if (grammar.discardChanges()) {
				env = environments.peek().copy();
			}
			int ret = process(t, pos);
			if (ret >= 0) {
				return ret;
			}
			if (grammar.discardChanges()) {
				environments.pop();
				environments.push(env);
			}
			t = (CommonTree) tree.getChild(1);
			return process(t, pos);
/*
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				int ret = process(t, pos);
				if (ret >= 0) {
					return ret;
				}
			}
			return -1;*/
		}
			
		case AdaptablePEGLexer.ASSIGNLIST: {
			// I suppose all children are ASSIGN
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				process(t, pos);
			}
			return pos;
		}
			
		case AdaptablePEGLexer.ASSIGN: {
			// I suppose (until now) first child is only ID
			SemanticNode left = (SemanticNode) tree.getChild(0);
			CommonTree right = (CommonTree) tree.getChild(1);
			Object r = eval(right);
			currEnvironment().setValue((Attribute) left.getSymbol(), r);
			return pos;
		}
		
		case AdaptablePEGLexer.CAPTURE_TEXT: {
			// I suppose there are 2 children: the iD and a PEG expression
			SemanticNode left = (SemanticNode) tree.getChild(0);
			CommonTree right = (CommonTree) tree.getChild(1);
			int ret = process(right, pos);
			if (ret >= 0) {
				char aux[] = new char[ret - pos];
				for (int i = pos; i < ret; ++i) {
					aux[i - pos] = buf.get(i);
				}
				String s = new String(aux);
				currEnvironment().setValue((Attribute) left.getSymbol(), s);
			}
			return ret;
		}
		
		case AdaptablePEGLexer.AND_LOOKAHEAD: {
			// I suppose there is exactly 1 child
			CommonTree t = (CommonTree) tree.getChild(0);
			int ret = process(t, pos);
			if (ret < 0) {
				return -1;
			}
			return pos;
		}
		
		case AdaptablePEGLexer.NOT_LOOKAHEAD: {
			// I suppose there is exactly 1 child
			CommonTree t = (CommonTree) tree.getChild(0);
			int ret = process(t, pos);
			if (ret < 0) {
				return pos;
			}
			return -1;
		}
			
		default:
			throw new Exception("Not implemented: " + tree.token.getType());
		}
	}
	
	
	private Object eval(CommonTree tree) throws Exception {
		switch (tree.token.getType()) {
		
		case AdaptablePEGLexer.TRUE: {
			return new Boolean(true);
		}
		
		case AdaptablePEGLexer.FALSE: {
			return new Boolean(false);
		}
		
		case AdaptablePEGLexer.INT_NUMBER: {
			return new Integer(Integer.parseInt(tree.getText()));
		}
		
		case AdaptablePEGLexer.STRING_LITERAL: {
			return tree.getText();
		}

		case AdaptablePEGLexer.CALL: {
			//I suppose there are 2 children, the name of the function and the list of arguments
			SemanticNode nameNode = (SemanticNode) tree.getChild(0);
			Function f = (Function) nameNode.getSymbol(); 
			Method m = f.getMethod();
			CommonTree t1 = (CommonTree) tree.getChild(1);
			int nArgs = t1.getChildCount();
			// I already checked the number of parameters during semantic analysis
			Object args[] = new Object[nArgs];
			for (int i = 0; i < nArgs; ++i) {
				CommonTree t2 = (CommonTree) t1.getChild(i);
				args[i] = eval(t2);
			}
			return m.invoke(null, args);
		}

		case AdaptablePEGLexer.OP_ADD: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Integer(i0 + i1);
		}

		case AdaptablePEGLexer.OP_SUB: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Integer(i0 - i1);
		}

		case AdaptablePEGLexer.OP_MUL: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Integer(i0 * i1);
		}
		
		case AdaptablePEGLexer.OP_GT: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Boolean(i0 > i1);
		}
		
		case AdaptablePEGLexer.OP_EQ: {
			//I suppose there are 2 children
			Object i0 = eval((CommonTree) tree.getChild(0));
			Object i1 = eval((CommonTree) tree.getChild(1));
			return i0.equals(i1);
			/*int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Boolean(i0 == i1);*/
		}
			
		case AdaptablePEGLexer.ID: {
			return currEnvironment().getValue((Attribute) ((SemanticNode) tree).getSymbol());
		}

		default:
			throw new Exception("Not implemented: " + tree.token.getType());
		}
	}

	
	
}
