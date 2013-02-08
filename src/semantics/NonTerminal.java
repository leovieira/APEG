package semantics;

import java.util.ArrayList;
import org.antlr.runtime.tree.CommonTree;
import semantics.Attribute.Category;

public class NonTerminal extends Symbol {
	
	private int numParam;
	private int numRet;
	private ArrayList<Attribute> attrs = new ArrayList<Attribute>();
	private CommonTree pegExpr;
	
	public NonTerminal(String name) {
		super(name);
	}

	public CommonTree getPegExpr() {
		return pegExpr;
	}

	public void setPegExpr(CommonTree pegExpr) {
		this.pegExpr = pegExpr;
	}

	public int numAttrs() {
		return attrs.size();
	}
	
	public Attribute getAttribute(int i) {
		return attrs.get(i);
	}
	
	public Attribute getAttribute(String  name) {
		for (Attribute a : attrs) {
			if (a.getName().compareTo(name) == 0) {
				return a;
			}
		}
		return null;
	}
	
	public Attribute addAttribute(String name, Type type, Category category) {
		if (getAttribute(name) != null) {
			return null;
		}
		Attribute a = new Attribute(name, type, category);
		attrs.add(a);
		if (category == Attribute.Category.PARAM) {
			++numParam;
		} else if (category == Attribute.Category.RETURN) {
			++numRet;
		}
		return a;
	}

	public int getNumParam() {
		return numParam;
	}

	public int getNumRet() {
		return numRet;
	}

}
