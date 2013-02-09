package srcparser;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import semantics.Grammar;
import treeparsers.AdaptablePEGTree;
import treeparsers.SemanticAnalysis1;
import treeparsers.SemanticAnalysis2;

public class Test {

	public static void testeinput(String fileName) throws Exception {
		
		ANTLRFileStream input = new ANTLRFileStream(fileName);
		AdaptablePEGLexer lexer = new AdaptablePEGLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AdaptablePEGParser parser = new AdaptablePEGParser(tokens);
		AdaptablePEGParser.grammarDef_return result = parser.grammarDef();
		Tree t = (Tree) result.getTree();
		System.out.println(t.toStringTree());

		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		nodes.setTokenStream(tokens);
		AdaptablePEGTree walker = new AdaptablePEGTree(nodes);
		walker.grammarDef();
		
		Grammar grammar = new Grammar();

		CommonTreeNodeStream nodes1 = new CommonTreeNodeStream(t);
		nodes1.setTokenStream(tokens);
		SemanticAnalysis1 walker1 = new SemanticAnalysis1(nodes1);
		walker1.enableErrorMessageCollection(true);
		walker1.grammarDef(grammar);
		if (walker1.hasErrors()) {
			walker1.printErrorMessages();
		}

		CommonTreeNodeStream nodes2 = new CommonTreeNodeStream(t);
		nodes2.setTokenStream(tokens);
		SemanticAnalysis2 walker2 = new SemanticAnalysis2(nodes2);
		walker2.enableErrorMessageCollection(true);
		walker2.grammarDef(grammar);
		if (walker2.hasErrors()) {
			walker2.printErrorMessages();
		}
		
		CommonTree tree = grammar.getNonTerminal("digit").getPegExpr();
		System.out.println(tree.toStringTree());
		grammar.setInputFile("input/teste01_01.txt");
		Object x = grammar.process(tree, -1);
		System.out.println(x);
		int k = (Integer) grammar.currEnvironment().getValue("x1");
		System.out.println(k);

	}

	
	public static void main(String args[]) throws Exception {
		testeinput("input/teste01.txt");
	}
	
}
