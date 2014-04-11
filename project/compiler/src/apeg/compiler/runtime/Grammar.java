package apeg.compiler.runtime;

public abstract class Grammar {

	protected APEGInputStream input;
	protected int currentPos = 0; // Current position on the input
	
	protected final Result fail_result = new Result(-1,null);
	
	protected Object[] adapt;
	
	
	protected Grammar(APEGInputStream input) {
		this.input = input;
	}
	
	protected int match(String string, int pos) throws Exception {
		return input.match(string, pos);
	}
	
	protected char read(int pos) throws Exception {
		return input.read(pos);
	}
	
	protected Result failResult() {
		return fail_result;
	}

	//TODO
	protected Result interpreteChoice(int pos) {
		//return null;
		return fail_result;
	}
	
	//TODO
	public Grammar copy() {
		return null;
	}
	
	//TODO
	public Grammar addRule(String rule) {
		return null;
	}
}
