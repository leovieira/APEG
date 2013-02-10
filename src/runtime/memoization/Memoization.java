package runtime.memoization;

import java.util.HashMap;
import java.util.List;

import semantics.Attribute;


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
	public Result getMemoization(String nonterminal, List<Attribute> attr, int pos) {
		Entry entry = new Entry(nonterminal, pos, attr);
		return map.get(entry);
		
		/*HashMap<Integer, HashMap<List<Attribute>, Result> > map_non;
		map_non = map.get(nonterminal);
		if(map_non == null)
			return null;
		// else
		HashMap<List<Attribute>, Result> map_pos = map_non.get(pos);
		if(map_pos == null)
			return null;
		// I hope that the equals function compares the values of the list and not
		// the pointers values
		// Probability, I have to define the hascode / equals function for Attribute.
		return map_pos.get(attr);*/
	}
	
	public Result addMemoization(String nonterminal, List<Attribute> attr, int pos,
			                    int next_pos, List<Attribute> result_attr) {
		
		Entry entry = new Entry(nonterminal, pos, attr);
		Result resp = new Result(next_pos, result_attr);
		return map.put(entry, resp);
		/*
		HashMap<Integer, HashMap<List<Attribute>, Result> > map_non;
		map_non = map.get(nonterminal);
		if(map_non == null) {
			map_non = new HashMap<Integer, HashMap<List<Attribute>, Result> >();
			HashMap<List<Attribute>, Result> map_pos = 
					                        new HashMap<List<Attribute>, Result> ();
			
			map_pos.put(attr, resp);
			map_non.put(pos, map_pos);
			map.put(nonterminal, map_non);
		}
		// else ---- TODO*/
	}
	
	
	/**
	* This class stores a position on the memoization table
	* @author leo
	*
	*/

	protected class Entry {
		private String non_term;
		private int pos;
		private List<Attribute> inh_attr;

		public Entry(String non_ter, int pos, List<Attribute> attr) {
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

		public List<Attribute> getInh_attr() {
			return inh_attr;
		}

		public void setInh_attr(List<Attribute> inh_attr) {
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
