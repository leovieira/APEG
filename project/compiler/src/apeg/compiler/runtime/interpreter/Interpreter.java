package apeg.compiler.runtime.interpreter;

import java.lang.reflect.Method;
import java.util.Stack;

import org.antlr.runtime.tree.CommonTree;

import apeg.compiler.runtime.APEGInputStream;
import apeg.compiler.runtime.Grammar;
import apeg.compiler.runtime.Result;

import apeg.compiler.syntax.tree.NonTerminal;
import apeg.compiler.syntax.tree.APEGNode;
import apeg.compiler.syntax.tree.Attribute;
import apeg.compiler.syntax.tree.Function;

import apeg.syntax.APEG_OldLexer;


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
	public Result execute(int nonTerminal, CommonTree expr, Environment env, int currentPos) throws Exception {
		environments.push(env);
		int ret = process(expr, currentPos);
		
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
		
		case APEG_OldLexer.NONTERM: { // change to APEGLexer.NONTERM
			// I suppose there are 2 children
			NonTerminal nt = 
					(NonTerminal) ((APEGNode) tree.getChild(0)).getSymbol(); // name of nonterminal
			CommonTree t = (CommonTree) tree.getChild(1); // list of arguments
			
			
			// creating a list with the values of the attributes			 
			// List of inherited attributes
			Object[] attr = new Object[nt.getNumParam()];
			
			// code for eval inherited attributes
			for(int i = 0; i < nt.getNumParam(); ++i) {
				Object x = eval((CommonTree)t.getChild(i));
				attr[i] = x;
			}
			
			//TODO code for memoization here
			
			// Check if there is the code for this nonterminal in the grammar
			Object language_attribute = attr[0]; // suppose that always there is the language attribute
			                                     // as the first inherited attribute
			
			for(Method  mt : language_attribute.getClass().getMethods()) {
				if(mt.getName().equals(nt.getName())) {
					// call from language attribute.
					// We do not check the number of attributes because I suppose it was done before in the syntax analysis
					Object result = mt.invoke(language_attribute, attr);
					//TODO code for memoization here
					return ((Result) result).getNext_pos(); // return the next position
					                                        // every nonterminal method has the Result return type
				}	                                         
			}
			// else
			// it is a new nonterminal			
			
			// Creating a environment and populate it
			Environment env = buildEnvironment(nt);		
			for (int i = 0; i < nt.getNumParam(); ++i)
				env.setValue(i, attr[i]);

			environments.push(env);
	
			CommonTree pegExpr = // take the peg expression of the new nonterminal, whose does not have a function code
					((Grammar) environments.peek().getValue(0)).getNewNonterminal(nt.getName()).getPegExpr();	

			int ret = process(pegExpr, pos);
			env = environments.pop();

			//TODO code for memoization here
			
			return ret;
		}
		
		case APEG_OldLexer.LAMBDA: {
			return pos;
		}
		
		case APEG_OldLexer.ANY: {
			char ch = grammar.read(pos);
			if (!APEGInputStream.isEOF(ch)) {
				return pos + 1;
			}
			return -1;
		}
		
		case APEG_OldLexer.STRING_LITERAL: {
			return grammar.match(tree.token.getText(), pos);
		}
		
		case APEG_OldLexer.RANGE: {
			//TODO
			char ch = grammar.read(pos);
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
		
		case APEG_OldLexer.SEQ: {
			int ret = pos;
			Environment env = null;
			//if (grammar.discardChanges()) { TODO
				env = environments.peek().copy();
			//}
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				ret = process(t, ret);
				if (ret < 0) {
					//if (grammar.discardChanges()) { TODO
						environments.pop();
						environments.push(env);
					//}
					return -1;
				}
			}
			return ret;
		}
		
		//TODO
		// insert code for discarding changes in environments, in several operations
		case APEG_OldLexer.REPEAT: {
			// I suppose there is exactly one child
			CommonTree t = (CommonTree) tree.getChild(0);
			int ret = pos;
			int ret1;
			Environment env = null;
			while (true) {
				//if (grammar.discardChanges()) { TODO
					env = environments.peek().copy();
				//}
				ret1 = process(t, ret);
				if (ret1 < 0) {
					//if (grammar.discardChanges()) { TODO
						environments.pop();
						environments.push(env);
					//}
					return ret;
				}
				ret = ret1;
			}
		}
		
		case APEG_OldLexer.ONE_REPEAT: {
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
		
		case APEG_OldLexer.OPTIONAL: {
			// I suppose there is exactly one child
			CommonTree t = (CommonTree) tree.getChild(0);
			int ret = process(t, pos);
			if (ret < 0) {
				ret = pos;
			}
			return ret;
		}
		
		case APEG_OldLexer.COND: {
			// I suppose there is exactly one child
			CommonTree t = (CommonTree) tree.getChild(0);
			Boolean b = (Boolean) eval(t);
			if (b) {
				return pos;
			} else {
				return -1;
			}
		}

		case APEG_OldLexer.CHOICE: {
			// I suppose there are 2 children
			CommonTree t = (CommonTree) tree.getChild(0);
			Environment env = null;
			//if (grammar.discardChanges()) { TODO
				env = environments.peek().copy();
			//}
			int ret = process(t, pos);
			if (ret >= 0) {
				return ret;
			}
			//if (grammar.discardChanges()) { TODO
				environments.pop();
				environments.push(env);
			//}
			t = (CommonTree) tree.getChild(1);
			return process(t, pos);

		}
			
		case APEG_OldLexer.ASSIGNLIST: {
			// I suppose all children are ASSIGN
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				process(t, pos);
			}
			return pos;
		}
			
		case APEG_OldLexer.ASSIGN: {
			// I suppose (until now) first child is only ID
			APEGNode left = (APEGNode) tree.getChild(0);
			CommonTree right = (CommonTree) tree.getChild(1);
			Object r = eval(right);
			currEnvironment().setValue((Attribute) left.getSymbol(), r);
			return pos;
		}
		
		case APEG_OldLexer.CAPTURE_TEXT: {
			// I suppose there are 2 children: the iD and a PEG expression
			APEGNode left = (APEGNode) tree.getChild(0);
			CommonTree right = (CommonTree) tree.getChild(1);
			int ret = process(right, pos);
			if (ret >= 0) {
				char aux[] = new char[ret - pos];
				for (int i = pos; i < ret; ++i) {
					aux[i - pos] = grammar.read(i);
				}
				String s = new String(aux);
				currEnvironment().setValue((Attribute) left.getSymbol(), s);
			}
			return ret;
		}
		
		case APEG_OldLexer.AND_LOOKAHEAD: {
			// I suppose there is exactly 1 child
			CommonTree t = (CommonTree) tree.getChild(0);
			int ret = process(t, pos);
			if (ret < 0) {
				return -1;
			}
			return pos;
		}
		
		case APEG_OldLexer.NOT_LOOKAHEAD: {
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
		
		case APEG_OldLexer.TRUE: {
			return new Boolean(true);
		}
		
		case APEG_OldLexer.FALSE: {
			return new Boolean(false);
		}
		
		case APEG_OldLexer.INT_NUMBER: {
			return new Integer(Integer.parseInt(tree.getText()));
		}
		
		case APEG_OldLexer.STRING_LITERAL: {
			return tree.getText();
		}

		case APEG_OldLexer.CALL: {
			//I suppose there are 2 children, the name of the function and the list of arguments
			APEGNode nameNode = (APEGNode) tree.getChild(0);
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

		case APEG_OldLexer.OP_ADD: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Integer(i0 + i1);
		}

		case APEG_OldLexer.OP_SUB: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Integer(i0 - i1);
		}

		case APEG_OldLexer.OP_MUL: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Integer(i0 * i1);
		}
		
		case APEG_OldLexer.OP_GT: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Boolean(i0 > i1);
		}
		
		case APEG_OldLexer.OP_EQ: {
			//I suppose there are 2 children
			Object i0 = eval((CommonTree) tree.getChild(0));
			Object i1 = eval((CommonTree) tree.getChild(1));
			return i0.equals(i1);

		}
			
		case APEG_OldLexer.ID: {
			return currEnvironment().getValue(((Attribute) ((APEGNode) tree).getSymbol()).getIndex());
		}

		default:
			throw new Exception("Not implemented: " + tree.token.getType());
		}
	}

	
	
}
