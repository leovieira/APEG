package apeg.compiler.runtime;

/**
 * This class represents a result of parsing expression computation on a substring
 * @author leo
 *
 */


public class Result {
	private int next_pos;
	private Object[] returns_attr;
	
	public Result(int pos, Object[] attr) {
		this.next_pos = pos;
		if(attr == null)
			this.returns_attr = new Object[0]; // To avoid checking if returns_attr is the null value
		                                       // when accessing the vector (see function getAttribute).
		else
			this.returns_attr = attr;
	}

	public int getNext_pos() {
		return next_pos;
	}

	public void setNext_pos(int next_pos) {
		this.next_pos = next_pos;
	}

	public Object[] getReturns_attr() {
		return returns_attr;
	}

	public void setReturns_attr(Object[] returns_attr) {
		if(returns_attr != null)
			this.returns_attr = returns_attr;
	}
	
	public Object getAttribute(int pos) {
		if(pos >= 0 && pos < returns_attr.length)
			return returns_attr[pos];
		else
			return -1; //TODO msg de erro para posicao invalida
	}
}
