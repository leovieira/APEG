
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import semantics.Grammar;
import semantics.SemanticTreeAdaptor;
import srcparser.AdaptablePEGLexer;
import srcparser.AdaptablePEGParser;


public class AdaptableFunctions {

	
	public static Grammar copyGrammar(Grammar g) {
		Grammar resp = g.copy();		
		return resp;
	}
	
	public static String concat(String s1, String s2) {
		return s1 + s2;
	}
	
	public static String concatN(String s, int n) {
		String resp = "";
		for(int i = 0; i < n; ++i)
			resp += s;
		return resp;
	}
	
	public static Grammar addRule(Grammar g, String rule) throws Exception {
		ANTLRStringStream input = new ANTLRStringStream(rule);
		AdaptablePEGLexer lexer = new AdaptablePEGLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AdaptablePEGParser parser = new AdaptablePEGParser(tokens);
		SemanticTreeAdaptor adaptor = new SemanticTreeAdaptor();
		parser.setTreeAdaptor(adaptor);
		parser.enableErrorMessageCollection(true);
		System.out.println("Trying to add rules: " + rule);
		AdaptablePEGParser.addrules_return result = parser.addrules(g);
		Tree t = (Tree) result.getTree();
//		System.out.println(t.toStringTree());
		if (parser.hasErrors()) {
			System.out.println("Errors when extending the grammar:");
			parser.printErrorMessages();
			throw new Exception("Extension failed");
		}
		return g;
	}
}
