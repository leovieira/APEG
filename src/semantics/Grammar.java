package semantics;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Grammar {
	
	private Hashtable<String, NonTerminal> nonTerms = new Hashtable<String, NonTerminal>();
	private Hashtable<String, Function> functions = new Hashtable<String, Function>();
		
	public Grammar() {
	}
		
	public NonTerminal getNonTerminal(String name) {
		return nonTerms.get(name);
	}

	public NonTerminal addNonTerminal(String name) {
		if (getNonTerminal(name) != null) {
			return null;
		}
		NonTerminal n = new NonTerminal(name);
		nonTerms.put(name, n);
		return n;
	}
	
	public Function getFunction(String name) {
		return functions.get(name);
	}
	
	public Function addFunction(Method method) {
		if (getFunction(method.getName()) != null) {
			return null;
		}
		Function f = new Function(method.getName(), method);
		functions.put(method.getName(), f);
		return f;
	}

	public Grammar copy() {
		//Hashtable<String, Function> functions = new Hashtable<String, Function>();
		//create a new grammar
		Grammar resp = new Grammar();
		// copy all values of the Map nonTerms
		Set<String> keys = nonTerms.keySet();
		Iterator<String> it = keys.iterator();
		String s;		
		while(it.hasNext()) {
			s = it.next();
			resp.nonTerms.put(s, getNonTerminal(s).copy());
		}
		
		//copy all values of the map functions
		// Se esses valores nao seram alterados na adaptabildiade nao preciso
		// fazer uma copia mesmo, basta aponta para o mesmo map
		// para uma implementacao mais rapida, nao fiz uma copia
		resp.functions = functions;		
		
		return resp;
	}
	
}
