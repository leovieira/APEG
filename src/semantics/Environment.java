package semantics;

public class Environment {

	private Object[] values;
	
	public Environment(int size) {
		values = new Object[size];
	}
	
	/**
	 * To be used when the value of a specific attribute is needed (currently, I have found no use).
	 * @param attr
	 * @return
	 */
	public Object getValue(Attribute attr) {
		return values[attr.getIndex()];
	}
	
	/**
	 * To be used when the position of the attribute is know (e. g. returning value of a NonTerminal)
	 * @param i
	 * @return
	 */
	public Object getValue(int i) {
		return values[i];
	}
	
	/**
	 * To be used when the value of a specific attribute must be set (e.g. assignment).
	 * @param attr
	 * @param x
	 */
	public void setValue(Attribute attr, Object x) {
		values[attr.getIndex()] = x;
	}
	
	/**
	 * To be used when the position of the attribute is know (e.g. parameter passing).
	 * @param i
	 * @param x
	 */
	public void setValue(int i, Object x) {
		values[i] = x;
	}
	
}
