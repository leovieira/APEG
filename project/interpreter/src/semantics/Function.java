package semantics;

import java.lang.reflect.Method;

public class Function extends Symbol {
	
	private Method method;
	private int nParams;

	public Function(String name, Method method) {
		super(name);
		this.method = method;
		nParams = method.getParameterTypes().length;
	}
	
	public Method getMethod() {
		return method;
	}
	
	public int getNumParams() {
		return nParams;
	}

}
