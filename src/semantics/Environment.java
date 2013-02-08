package semantics;

import java.util.Hashtable;

public class Environment {

	private Hashtable<String, Object> map = new Hashtable<String, Object>();
	
	public Object getValue(String name) {
		return map.get(name);
	}
	
	public void setValue(String name, Object x) {
		map.put(name, x);
	}
}
