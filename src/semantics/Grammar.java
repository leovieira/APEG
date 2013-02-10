package semantics;

import java.lang.reflect.Method;
import java.util.Hashtable;

public class Grammar {
	
	private Hashtable<String, NonTerminal> nonTerms = new Hashtable<String, NonTerminal>();
	private Hashtable<String, Method> functions = new Hashtable<String, Method>();
		
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
	
	public Method getFunction(String name) {
		return functions.get(name);
	}
	
	public Method addFunction(Method m) {
		if (getFunction(m.getName()) != null) {
			return null;
		}
		functions.put(m.getName(), m);
		return m;
	}

	
}
