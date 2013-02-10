package runtime.memoization;

/**
 * This class represents a result of parsing expression computation on a substring
 * @author leo
 *
 */

import java.util.List;

import semantics.Attribute;

public class Result {
	private int next_pos;
	private List<Attribute> returns_attr;
	
	public Result(int pos, List<Attribute> attr) {
		this.next_pos = pos;
		this.returns_attr = attr;
	}

	public int getNext_pos() {
		return next_pos;
	}

	public void setNext_pos(int next_pos) {
		this.next_pos = next_pos;
	}

	public List<Attribute> getReturns_attr() {
		return returns_attr;
	}

	public void setReturns_attr(List<Attribute> returns_attr) {
		this.returns_attr = returns_attr;
	}
}
