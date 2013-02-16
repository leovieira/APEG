package util;

import java.io.StringWriter;
import java.text.Normalizer;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import runtime.interpreter.Interpreter;
import semantics.Grammar;
import semantics.NonTerminal;
import semantics.SemanticNode;
import semantics.SemanticTreeAdaptor;
import srcparser.AdaptablePEGLexer;
import srcparser.AdaptablePEGParser;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}

	public static int testeGrammar(
			String grammarFileName,
			String inputFileName,
			String initSymbol
			)
			throws Exception {
		return testeGrammar(grammarFileName, inputFileName, initSymbol, null);
	}

	
	public static int testeGrammar(
		String grammarFileName,
		String inputFileName,
		String initSymbol,
		Object args[]
		)
	throws Exception {
		
		System.out.println("-----------------------------------------");
		System.out.println("Testing grammar " + grammarFileName);
		System.out.println("Input file: " + inputFileName);
		System.out.println("Initial Symbol: " + initSymbol);
		
		Grammar grammar = new Grammar();
		
		ANTLRFileStream input = new ANTLRFileStream(grammarFileName);
		AdaptablePEGLexer lexer = new AdaptablePEGLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AdaptablePEGParser parser = new AdaptablePEGParser(tokens);
		SemanticTreeAdaptor adaptor = new SemanticTreeAdaptor();
		parser.setTreeAdaptor(adaptor);
		parser.enableErrorMessageCollection(true);
		AdaptablePEGParser.grammarDef_return result = parser.grammarDef(grammar);
		Tree t = (Tree) result.getTree();
		System.out.println(t.toStringTree());
		if (parser.hasErrors()) {
			parser.printErrorMessages();
			return -2;
		}
		
/*		NonTerminal nt = grammar.getNonTerminal("CHAR");
		Grammar g1 = grammar.copy();
		NonTerminal nt1 = g1.getNonTerminal("CHAR");*/
				
		if (inputFileName != null && initSymbol != null) {
			Interpreter interpreter = new Interpreter(grammar);
			interpreter.setInputFile(inputFileName);
			int resp = interpreter.execute(initSymbol, args);
			if (resp < 0) {
				System.out.println(">>>>>>>>>> FAILED!");
			} else {
				System.out.println(">>>>> SUCCESS - number of characters read: " + resp);
			}
			return resp;
		}
		
		return 0;

	}

	public static String formatString(String s) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (ch != '\\') {
				sb.append(ch);
				++i;
			} else {				
				++i;
				if (i == s.length()) {
					break;
				}
				ch = s.charAt(i);
				++i;
				switch (ch) {
				case '\\':
					sb.append('\\');
					break;
				case 'n':
					sb.append('\n');
					break;
				case 'r':
					sb.append('\r');
					break;
				case 'f':
					sb.append('\f');
					break;
				case 't':
					sb.append('\t');
					break;
				case '\"':
					sb.append('\"');
					break;
				case '\'':
					sb.append('\'');
					break;
				default :
					--i;
				}
			}
		}
		return sb.toString();
	}
	
	
	public static void main(String args[]) {
		String s = "a\'\t\"b\n\\c";
		System.out.println(s);
		String s1 = "a\\\'\\t\\\"b\\n\\\\c";
		System.out.println(s1);
		s1 = formatString(s1);
		System.out.println(s1);		
	}
	
}
