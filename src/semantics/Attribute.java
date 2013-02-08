package semantics;

public class Attribute extends Symbol {

	private Type type;
	
	public static enum Category {
		PARAM, RETURN, LOCAL
	}
	Category category;

	public Attribute(String name, Type type, Category c) {
		super(name);
		this.type = type;
		category = c;
	}

	public Type getType() {
		return type;
	}
	
	public Category getCategory() {
		return category;
	}
	
}
