package runtime.memoization;

/**
 * This class represents a result of parsing expression computation on a substring
 * @author leo
 *
 */

import java.util.List;

public class Result {
	private int next_pos;
	private Object[] returns_attr;
	
	public Result(int pos, Object[] attr) {
		this.next_pos = pos;
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
		this.returns_attr = returns_attr;
	}
}
