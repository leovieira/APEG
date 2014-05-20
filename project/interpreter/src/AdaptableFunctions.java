


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	public static int strToInt(String s) {
		return Integer.parseInt(s);
	}
	
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
	
	public static Grammar adaptable(Grammar g, Map<String, String> map, String name) throws Exception {
		if(map.containsKey(name)) {
			return addRule(copyGrammar(g), map.get(name));
		} else
			return g;
	}
	
	public static Map<String,String> add(Map<String,String> map, String pack, String name, String rule) {
		String entry = pack + "." + name;
		if(map.containsKey(entry)) {
			// ERROR
			return map;
		} else
			map.put(entry, rule);
		return map;		
	}
	
	public static Map<String, List<String>> addGrammar(Map<String, List<String>> map, String grammar, String rule) {
		return map;
	}
	
	private static boolean specialSymbols(String s) {
		String specials[] = new String[] {
				             "(", ")", "!", "+", "*", "?",
				             "&", "[", "]", "/"
		                    };
		for(String ch : specials)
			if(s.equals(ch))
				return true;
		return false;
	}
	
	public static String formatTerminal(List<String> l, String s) {
		if(l.contains(s) || specialSymbols(s))
			return s; // it is a nonterminal name
		else
			return "\'" + s + "\'"; // it is a terminal name
	}
	
	public static String concatW(String s1, String s2) {
		if(s2.equals("wr") || s2.equals("br") || s2.equals("s") || s2.equals("sr"))
			return s1 + " " + s2; // do not include optional space
		else
			return s1 + " w " + s2;
	}
	
	public static List<String> addList(List<String> l, String n) {
		if(l == null)
			l = new ArrayList<String> ();
		l.add(n);
		return l;
	}
	
	public static List<String> newList() {
		return new ArrayList<String>();
	}
	
	public static Map<String, List<String>> grammars() {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		// Creating the default available nonterminals: they are the spaces nonterminals
		String name = "default";
		List<String> nonterminals = new ArrayList<String>();
		nonterminals.add("w");
		nonterminals.add("wr");
		nonterminals.add("br");
		nonterminals.add("sr");
		nonterminals.add("s");
		map.put(name, nonterminals);
		
		// Creating the name of the nonterminals of expression. This is not the all names
		name = "Expression";
		nonterminals = new ArrayList<String>();
		nonterminals.add("Expr");
		map.put(name, nonterminals);
		
		// Creating the name of the nonterminals of identifiers. This is not the all names
		name = "Identifier";
		nonterminals = new ArrayList<String>();
		nonterminals.add("Id");
		map.put(name, nonterminals);
		
		return map;
	}
}
