import semantics.Grammar;


public class AdaptableFunctions {

	
	public static Grammar copyGrammar(Grammar g) {
		Grammar resp = g.copy();		
		return resp;
	}
}
