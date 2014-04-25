package apeg.compiler.syntax.tree;


public class Attribute extends Symbol {

	private Type type; // the attribute type
	private int index; // it position on the vector of attributes
	
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
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) // if point to the same object
			return true;
		if(obj instanceof Attribute) {
			Attribute attr = (Attribute) obj;
			return attr.type.equals(this.type) && attr.index == this.index;
		}
		return false;
	}
	
}
