package apeg.compiler.runtime;

import generated.DataDependent;

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
		if(pos == 2) {
			DataDependent g = (DataDependent) this;
			try {
				g.CHAR(g);
				g.CHAR(g);
				g.CHAR(g);
				return new Result(g.currentPos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return fail_result;
	}
	
	//TODO
	public Grammar copy() {
		return this;
	}
	
	//TODO
	public Grammar addRule(String rule) {
		return this;
	}
}
