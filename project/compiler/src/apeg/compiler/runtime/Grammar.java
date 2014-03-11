package apeg.compiler.runtime;

public abstract class Grammar {

	protected final Result fail_result = new Result(-1,null);
	
	protected Object[] adapt;
	
	protected int match(String string, int pos) {
		return -1;
	}
	
	protected Result failResult() {
		return fail_result;
	}

	protected Result interpreteChoice(int pos) {
		return null;
	}
	
	public Grammar copy() {
		return null;
	}
	
	public Grammar addRule(String rule) {
		return null;
	}
}
