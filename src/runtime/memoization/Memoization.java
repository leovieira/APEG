package runtime.memoization;

import java.util.HashMap;
import java.util.List;

/**
 * This class stores the intermediates computations in executions of a APEG
 * @author leo
 *
 */
public class Memoization {

	/**
	 * To map an entry, we have a three levels on indirection
	 * First, we look if there is a memoization result for a nonterminal;
	 * Second, if there is a memoization for a position; and
	 * Next, we look if the values of attribute match; 
	 */
	//HashMap<String, HashMap<Integer, HashMap<List<Attribute>, Result> > > map;
	HashMap<Entry, Result> map;
	
	public Memoization() {
		map = new HashMap<Entry, Result>();
	}
	
	/**
	 * 
	 * @param nonterminal The nonterminal name
	 * @param attr List of the attributes value
	 * @param pos File position
	 * @return An object that represent the next position and the values of the 
	 *         synthesized attributes or null if there is not a memoization
	 */
	public Result getMemoization(String nonterminal, Object[] attr, int pos) {
		//disable memoization
		return null;
		
		/*Entry entry = new Entry(nonterminal, pos, attr);
		return map.get(entry);*/
		
	}
	
	public Result addMemoization(String nonterminal, Object[] attr, int pos,
			                    int next_pos, Object[] result_attr) {
		
		Entry entry = new Entry(nonterminal, pos, attr);
		Result resp = new Result(next_pos, result_attr);
		return map.put(entry, resp);
	}
	
	
	/**
	* This class stores a position on the memoization table
	* @author leo
	*
	*/

	protected class Entry {
		private String non_term;
		private int pos;
		private Object[] inh_attr;

		public Entry(String non_ter, int pos, Object[] attr) {
			this.non_term = non_ter;
			this.pos = pos;
			this.inh_attr = attr;
		}

		public int getPos() {
			return pos;
		}

		public void setPos(int pos) {
			this.pos = pos;
		}

		public String getNon_term() {
			return non_term;
		}

		public void setNon_term(String non_term) {
			this.non_term = non_term;
		}

		public Object[] getInh_attr() {
			return inh_attr;
		}

		public void setInh_attr(Object[] inh_attr) {
			this.inh_attr = inh_attr;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((inh_attr == null) ? 0 : inh_attr.hashCode());
			result = prime * result
					+ ((non_term == null) ? 0 : non_term.hashCode());
			result = prime * result + pos;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (inh_attr == null) {
				if (other.inh_attr != null)
					return false;
			} else if (!inh_attr.equals(other.inh_attr))
				return false;
			if (non_term == null) {
				if (other.non_term != null)
					return false;
			} else if (!non_term.equals(other.non_term))
				return false;
			if (pos != other.pos)
				return false;
			return true;
		}

		private Memoization getOuterType() {
			return Memoization.this;
		}

	}
}
