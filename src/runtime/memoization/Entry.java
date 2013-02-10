package runtime.memoization;

/**
 * This class stores a position on the memoization table
 * @author leo
 *
 */

import java.util.List;

import semantics.Attribute;

public class Entry {
	private String non_term;
	private List<Attribute> inh_attr;
	
	public Entry(String non_ter, List<Attribute> attr) {
		this.non_term = non_ter;
		this.inh_attr = attr;
	}

	public String getNon_term() {
		return non_term;
	}

	public void setNon_term(String non_term) {
		this.non_term = non_term;
	}

	public List<Attribute> getInh_attr() {
		return inh_attr;
	}

	public void setInh_attr(List<Attribute> inh_attr) {
		this.inh_attr = inh_attr;
	}
}
