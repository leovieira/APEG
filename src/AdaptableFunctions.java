


import java.util.ArrayList;
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
	
	private static List<String> availableNonterminals(Map<String, List<String>> map) {
		List<String> resp = new ArrayList<String> ();
		for( List<String> s : map.values()) {
			resp.addAll(s);
		}
		return resp;
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
	
	public static String formatTerminal(Map<String, List<String>> map, List<String> list, String rule) {
		List<String> nonterminals = availableNonterminals(map);
		nonterminals.addAll(list);
		String args[] = rule.split("$END$"); // split in a list of APEG rules
		String resp = "";
		for(String s : args) {
			String aux[] = s.split(":"); // split the nonterminal name of its rule
			resp += aux[0] + " :";
			for(String item : aux[1].split(" ")) {
				if(nonterminals.contains(item) || specialSymbols(item))
					resp += " " + item; // it is a nonterminal name
				else
					resp += " \'" + item + "\'"; // it is a terminal name
			}
			resp += ";\n";
		}	
		return resp;
	}
	
	public static String concatW(String s1, String s2) {
		if(s2.equals("wr") || s2.equals("br") || s2.equals("s") || s2.equals("sr"))
			return s1 + " " + s2; // do not include optional space
		else
			return s1 + " w " + s2;
	}
	
	public static boolean checkGrammarName(Map<String, List<String>> map, String name) {
		return map.containsKey(name);
	}
	
	public static List<String> addList(List<String> l, String n) {
		if(l == null)
			l = new ArrayList<String> ();
		l.add(n);
		return l;
	}
}
