import org.antlr.runtime.tree.CommonTree;

import semantics.Grammar;


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
	
	public static Grammar addRule(Grammar g, String rule) {
		CommonTree resp, peg_expr = new CommonTree();
		//peg_expr = 
		
		return null;
	}
}
