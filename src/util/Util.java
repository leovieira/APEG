package util;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import runtime.interpreter.Interpreter;
import semantics.Grammar;
import semantics.SemanticTreeAdaptor;
import srcparser.AdaptablePEGLexer;
import srcparser.AdaptablePEGParser;
import treeparsers.AdaptablePEGTree;
import treeparsers.SemanticAnalysis1;
import treeparsers.SemanticAnalysis2;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}
	
	public static void testeGrammar(String grammarFileName, String inputFileName, String initSymbol)
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
		AdaptablePEGParser.grammarDef_return result = parser.grammarDef(grammar);
		Tree t = (Tree) result.getTree();
		System.out.println(t.toStringTree());
		if (parser.hasErrors()) {
			parser.printErrorMessages();
			return;
		}
/*				
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		nodes.setTokenStream(tokens);
		AdaptablePEGTree walker = new AdaptablePEGTree(nodes);
		walker.enableErrorMessageCollection(true);
		walker.grammarDef();
		if (walker.hasErrors()) {
			walker.printErrorMessages();
			return;
		}

		CommonTreeNodeStream nodes1 = new CommonTreeNodeStream(t);
		nodes1.setTokenStream(tokens);
		SemanticAnalysis1 walker1 = new SemanticAnalysis1(nodes1);
		walker1.enableErrorMessageCollection(true);
		walker1.grammarDef(grammar);
		if (walker1.hasErrors()) {
			walker1.printErrorMessages();
			return;
		}

		nodes1.reset();
		SemanticAnalysis2 walker2 = new SemanticAnalysis2(nodes1);
		walker2.enableErrorMessageCollection(true);
		walker2.grammarDef(grammar);
		if (walker2.hasErrors()) {
			walker2.printErrorMessages();
			return;
		}
*/
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		nodes.setTokenStream(tokens);
		SemanticAnalysis2 walker = new SemanticAnalysis2(nodes);
		walker.enableErrorMessageCollection(true);
		walker.grammarDef(grammar);
		if (walker.hasErrors()) {
			walker.printErrorMessages();
			return;
		}
		
		if (inputFileName != null && initSymbol != null) {
			Interpreter interpreter = new Interpreter(grammar);
			interpreter.setInputFile(inputFileName);
			int resp = interpreter.execute(initSymbol);
			if (resp < 0) {
				System.out.println(">>>>>>>>>> FAILED!");
			} else {
				System.out.println(">>>>> SUCCESS - number of character read: " + resp);
			}
		}

	}

	
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


	
	
}
