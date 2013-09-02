import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import semantics.Grammar;
import semantics.NonTerminal;

import fortress.GrammarDef;


public class FortressFunctions {
	
	public static boolean checkGrammarName(Map<String, GrammarDef> map, String name) {
		return map.containsKey(name);
	}
	
	public static List<String> concatList(List<String> l1, List<String> l2) {
		List<String> resp = new ArrayList<String> ();
		if(l1 != null)
			resp.addAll(l1);
		if(l2 != null)
			resp.addAll(l2);
		return resp;
	}
	
	public static List<String> getNonterminals(Map<String, GrammarDef> m, String g) {
		return m.get(g).getNonterminals();
	}
	
	public static GrammarDef insertRule(GrammarDef g, String n, String r) {
		g.addRule(n, r);
		return g;
	}
	
	public static GrammarDef newGrammarDef(String name, List<String> nt) {
		GrammarDef g = new GrammarDef(name);
		for(String n : nt)
			g.addNonterminal(n);
		return g;
	}
	
	public static Grammar adapt(Grammar g, GrammarDef gr) throws Exception {
		Grammar resp = AdaptableFunctions.copyGrammar(g);
		String rule = gr.getAllRules(); /*String rule = "";
		for(String nt : gr.getNonterminals()) {
			rule += nt + " : " + gr.getRule(nt) + ";\n";
		}*/
		AdaptableFunctions.addRule(resp, rule);
		return resp;
	}
}
