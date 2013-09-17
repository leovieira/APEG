import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;
import org.sugarj.common.path.Path;

import semantics.Grammar;
import semantics.SemanticTreeAdaptor;
import srcparser.AdaptablePEGLexer;
import srcparser.AdaptablePEGParser;
import apeg.data.DataManager;
import apeg.sugarj.driver.Driver;


public class SugarJAdaptabilityFunctions {
	
	public static String concat(String s1, String s2) {
		return s1 + s2;
	}
	
	/**
	 * Function to make a copy of a grammar
	 * @param g
	 * @return
	 */
	public static Grammar copyGrammar(Grammar g) {
		Grammar resp = g.copy();		
		return resp;
	}
	
	/**
	 * Function to extend a grammar with new rules
	 * @param g
	 * @param rule
	 * @return
	 * @throws Exception
	 */
	public static Grammar addRule(Grammar g, String rule) throws Exception {
		ANTLRStringStream input = new ANTLRStringStream(rule);
		AdaptablePEGLexer lexer = new AdaptablePEGLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		AdaptablePEGParser parser = new AdaptablePEGParser(tokens);
		SemanticTreeAdaptor adaptor = new SemanticTreeAdaptor();
		parser.setTreeAdaptor(adaptor);
		parser.enableErrorMessageCollection(true);
		//System.out.println("Trying to add rules: " + rule);
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
	
	/**
	 * Function to adapt a grammar, adding new rules of a sugar library
	 * @param g
	 * @param map
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public static Grammar adapt(Grammar g, String name, List<Path> sourcePath) throws Exception {
		// First, we must to process the import
		Driver.processImport(name, sourcePath);
		
		// After, adpat the grammar if there is the import is a sugar library
		if(Driver.containsSugarlibrary(name)) {
			String sugar = Driver.getSugarLibrary(name);
			long beginTime = System.currentTimeMillis();
			Grammar g1 = addRule(copyGrammar(g), sugar);
			long endTime = System.currentTimeMillis();
			DataManager.addAdaptabilityTime(endTime-beginTime); // Compute the time to change a grammar
			return g1;
		} else
			return g;
	}
	
	/**
	 * This function adds a new sugar entry in the map of sugars libraries
	 * @param map
	 * @param pack
	 * @param name
	 * @param rule
	 * @return
	 */
	public static boolean resgisterSugarLibrary(String pack, String name, String rule) {
		String entry = pack + "." + name;
		if(Driver.containsSugarlibrary(entry)) {
			// ERROR
			return false;
		} else
			Driver.addSugarLibrary(entry, rule);
		return true;		
	}

}
