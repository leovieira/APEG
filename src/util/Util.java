package util;

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

	public static void testeGrammar(
			String grammarFileName,
			String inputFileName,
			String initSymbol
			)
			throws Exception {
		testeGrammar(grammarFileName, inputFileName, initSymbol, false, null);
	}

	public static void testeGrammar(
			String grammarFileName,
			String inputFileName,
			String initSymbol,
			boolean isAdaptable
			)
			throws Exception {
		testeGrammar(grammarFileName, inputFileName, initSymbol, isAdaptable, null);
	}

	
	public static void testeGrammar(
		String grammarFileName,
		String inputFileName,
		String initSymbol,
		boolean isAdaptable,
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
			return;
		}
		
		NonTerminal nt = grammar.getNonTerminal("CHAR");
		Grammar g1 = grammar.copy();
		NonTerminal nt1 = g1.getNonTerminal("CHAR");
				
		if (inputFileName != null && initSymbol != null) {
			Interpreter interpreter = new Interpreter(grammar, isAdaptable);
			interpreter.setInputFile(inputFileName);
			int resp = interpreter.execute(initSymbol, args);
			if (resp < 0) {
				System.out.println(">>>>>>>>>> FAILED!");
			} else {
				System.out.println(">>>>> SUCCESS - number of character read: " + resp);
			}
		}

	}

/*	
	public static void addRules(Grammar grammar, String rule)
	throws Exception {
		
		ANTLRStringStream input = new ANTLRStringStream(rule);
		AdaptablePEGLexer lexer = new AdaptablePEGLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AdaptablePEGParser parser = new AdaptablePEGParser(tokens);
		SemanticTreeAdaptor adaptor = new SemanticTreeAdaptor();
		parser.setTreeAdaptor(adaptor);
		AdaptablePEGParser.rules_return result = parser.rules();
		Tree t = (Tree) result.getTree();
		System.out.println(t.toStringTree());
		if (parser.hasErrors()) {
			parser.printErrorMessages();
			return;
		}
				

	}
*/

	public static void main(String args[]) {

	}
	
}
