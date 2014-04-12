package apeg.compiler.runtime.interpreter;

import java.util.Stack;

import org.antlr.runtime.tree.CommonTree;

import apeg.compiler.runtime.Grammar;
import apeg.compiler.runtime.Result;
import apeg.compiler.runtime.semantics.NonTerminal;

public class Interpreter {
	
	private Grammar grammar; // the grammar from the interpreter is called

	Stack<Environment> environments; // the of environments
	//private static final char EOF = (char) -1;

	
	public Interpreter(Grammar grammar) {
		this.grammar = grammar;
		environments = new Stack<Environment>();
	}

	public Environment buildEnvironment(NonTerminal nt) {
		Environment env = new Environment(nt.numAttrs());
		return env;
	}
	
	public Environment currEnvironment() {
		return environments.peek();
	}
	
	/**
	 * Execute the current PEG expression
	 * @param nonTerminal the number representing the nonterminal whose has the alternative being evaluated
	 * @param expr the PEG expression that will be executed
	 * @param env the initial environment. It has the all attributes positions of the nonterminal,
	 *                                     but only the first one (language attribute is defined)
	 * @return Object representing the return value of the nonterminal interpretation. 
	 * @throws Exception 
	 */
	public Result execute(int nonTerminal, CommonTree expr, Environment env) throws Exception {
		environments.push(env);
		int ret = process(expr, grammar.getCurrentPos());
		
		if (ret >= 0) {
			// Only if the option discardchanges is not set to false
			env = environments.pop(); // we need a new version if is not to discard changes
			
			NonTerminal nt = grammar.getNonterminal(nonTerminal);
			Object[] return_obj = new Object[nt.getNumRet()];
			
			int first = nt.getNumParam();
			int last = first + nt.getNumRet();
			for (int i = first; i < last; ++i) {
				return_obj[i - first] = env.getValue(i);
			}
			return new Result(ret, return_obj);
		}		
		return grammar.failResult();
	}
	
	/**
	 * *****************************************
	 * *****************************************
	 * *****************************************
	 */
	
	


	
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
