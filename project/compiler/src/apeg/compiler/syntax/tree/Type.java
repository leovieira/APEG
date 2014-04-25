package apeg.compiler.syntax.tree;


public class Type extends Symbol {

	public Type(String name) {
		super(name);
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) // if point to the same object
			return true;
		if(obj instanceof Type) {
			Type t = (Type) obj;
			return t.getName().equals(this.getName());
		}
		return false;
	}
}
