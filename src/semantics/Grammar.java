package semantics;

import java.lang.reflect.Method;
import java.util.Hashtable;

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

	
}
