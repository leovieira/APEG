package apeg.compiler.runtime.semantics;

public class Attribute extends Symbol {

	private Type type;
	private int index;
	
	public static enum Category {
		PARAM, RETURN, LOCAL
	}
	Category category;

	public Attribute(String name, Type type, Category c, int index) {
		super(name);
		this.type = type;
		this.index = index;
		category = c;
	}

	public Type getType() {
		return type;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
	
}
