package semantics;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Stack;
import org.antlr.runtime.tree.CommonTree;
import srcparser.AdaptablePEGLexer;

public class Grammar {
	
	private Hashtable<String, NonTerminal> nonTerms = new Hashtable<String, NonTerminal>();
	
	private FileReader input;
	private ArrayList<Character> buf;
//	private int currPos;
	private EvalExpr evalExpr;
	Stack<Environment> environments;
	
	public Grammar() {
		buf = new ArrayList<Character>();
		evalExpr = new EvalExpr();
		environments = new Stack<Environment>();
		environments.push(new Environment());
	}
	
	public Environment currEnvironment() {
		return environments.peek();
	}
	
	public NonTerminal getNonTerminal(String name) {
		return nonTerms.get(name);
	}

	public NonTerminal addNonTerminal(String name) {
		if (getNonTerminal(name) != null) {
			return null;
		}
		NonTerminal n = new NonTerminal(name);
		nonTerms.put(name, n);
		return n;
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
		for (int i = buf.size(); i <= pos; ++i) {
			ch = (char) input.read();
			buf.add(ch);
		}
		return ch;
	}
	
	private int match(String s, int pos) throws Exception {
		for (int i = 0; i < s.length(); ++i) {
			char ch = read(pos + i + 1);
			char ch2 = s.charAt(i);
			if (ch != ch2) {
				return -1;
			}
		}
		return pos + s.length();
	}

	public Environment buildEnvironment(NonTerminal nt) {
		Environment env = new Environment();
		for (int i = 0; i < nt.numAttrs(); ++i) {
			Attribute at = nt.getAttribute(i);
			env.setValue(at.getName(), null);
		}
		return env;
	}
	
	
	public int process(CommonTree tree, int pos) throws Exception {
		char ch;
		switch (tree.token.getType()) {
		
		case AdaptablePEGLexer.NONTERM: {
			// I suppose there are 2 children
			CommonTree t = (CommonTree) tree.getChild(0); // name of nonterminal
			String nameNT = t.token.getText();
			t = (CommonTree) tree.getChild(1); // list of arguments
			NonTerminal nt = getNonTerminal(nameNT);
			Environment env = buildEnvironment(nt);
			for (int i = 0; i < nt.getNumParam(); ++i) {
				Object x = evalExpr.eval((CommonTree)t.getChild(i), env);
				env.setValue(nt.getAttribute(i).getName(), x);
			}
			environments.push(env);
			int ret = process(nt.getPegExpr(), pos);
			environments.pop();
			if (ret >= 0) {
				for (int i = 0; i < nt.getNumRet(); ++i) {
					Object x = env.getValue(nt.getAttribute(i + nt.getNumParam()).getName());
					String name = ((CommonTree) t.getChild(i + nt.getNumParam())).token.getText();
					currEnvironment().setValue(name, x);
				}
			}
			return ret;
		}
		
		case AdaptablePEGLexer.ANY: {
			ch = read(pos);
			return pos + 1;
		}
			
		case AdaptablePEGLexer.STRING_LITERAL: {
			String s = tree.token.getText();
			return match(s.substring(1, s.length()-1), pos);
		}

		case AdaptablePEGLexer.SEQ: {
			int ret = pos;
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				ret = process(t, ret);
				if (ret < 0) {
					return -1;
				}
			}
			return ret;
		}
			
		case AdaptablePEGLexer.CHOICE: {
			// I suppose there are 2 children
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				int ret = process(t, pos);
				if (ret >= 0) {
					return ret;
				}
			}
			return -1;
		}
			
		case AdaptablePEGLexer.ASSIGNLIST: {
			// I suppose all childrem are ASSIGN
			for (int i = 0; i < tree.getChildCount(); ++i) {
				CommonTree t = (CommonTree) tree.getChild(i);
				process(t, pos);
			}
			return pos;
		}
			
		case AdaptablePEGLexer.ASSIGN: {
			// I suppose (until now) first child is only ID
			CommonTree t = (CommonTree) tree.getChild(0);
			String varName = t.token.getText();
			t = (CommonTree) tree.getChild(1);
			Object r = evalExpr.eval(t, currEnvironment());
			currEnvironment().setValue(varName, r);
			return pos;
		}
			
		default:
			throw new Exception("Not implemented: " + tree.token.getType());
		}
	}
	
	public static void main(String args[]) throws Exception {
		FileReader f = new FileReader("input/teste01.txt");
		int ich;
		while ((ich = f.read()) != -1) {
			char ch = (char) ich;
			System.out.print(ch);
		}
	}
	
}
