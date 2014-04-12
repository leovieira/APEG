package apeg.compiler.runtime.semantics;

import org.antlr.runtime.tree.CommonTree;

import apeg.compiler.runtime.semantics.Attribute.Category;

/**
 * A class to represent a Nonterminal symbol.
 * 
 * @author vladimir
 *
 */
public class NonTerminal extends Symbol {
	
	private int numParam;
	private int numRet;
	private int numLocal;
	private Attribute[] attrs;
	
	private CommonTree pegExpr;
	
	public NonTerminal(String name, int numParam, int numRet, int numLocal) {
		super(name);
		this.numParam = numParam;
		this.numRet = numRet;
		this.numLocal = numLocal;
		attrs = new Attribute[numParam + numRet + numLocal];
	}

	public int numAttrs() {
		return attrs.length;
	}
	
	public Attribute getParam(int i) {
		if (i >= getNumParam()) {
			throw new Error("Wrong index at getParam");
		}
		return attrs[i];
	}
	
	public Attribute getReturn(int i) {
		if (i >= getNumRet()) {
			throw new Error("Wrong index at getReturn");
		}
		return attrs[i + getNumParam()];
	}
	
	public Attribute getLocal(int i) {
		if (i >= getNumLocal()) {
			throw new Error("Wrong index at getLocal");
		}
		return attrs[i + getNumParam() + getNumRet()];
	}
	
	public Attribute getAttribute(String  name) {
		for (Attribute a : attrs) {
			if (a.getName().compareTo(name) == 0) {
				return a;
			}
		}
		return null;
	}
	
	public Attribute addAttribute(String name, Type type, Category category, int num) {
		if (getAttribute(name) != null) {
			return null;
		}
		
		if (category == Attribute.Category.PARAM) {
			if (num < 0 || num >= numParam) {
				throw new Error("Invalid number of inherited attribute");
			}
			attrs[num] = new Attribute(name, type, category, num);
			return attrs[num];
		} else if (category == Attribute.Category.RETURN) {
			if (num < 0 || num >= numRet) {
				throw new Error("Invalid number of return attribute");
			}
			attrs[numParam + num] = new Attribute(name, type, category, numParam + num);
			return attrs[numParam + num];
		} else if (category == Attribute.Category.LOCAL) {
			if(num < 0 || num >= numLocal) {
				throw new Error("Invalid number of local attribute");
			}
			attrs[numParam + numRet + num] = new Attribute(name, type, category, numParam + numRet + num);
			return attrs[numParam + numRet + num];
		}
		return null; // only to compile. The code never will reach this
	}
	
	public int getNumParam() {
		return numParam;
	}

	public int getNumRet() {
		return numRet;
	}

	public int getNumLocal() {
		return numRet;
	}
	
	public NonTerminal copy() {
		NonTerminal nt = new NonTerminal(getName(), numParam, numRet, numLocal);
		
		for(int i = 0; i < attrs.length; i++) {
			// Note there is a new vector of attributes. However, the two list set for the same attribute values
			// This allow us to change the nonterminal attributes without changes the old one, and save space
			nt.attrs[i] = attrs[i];
		}
		
		// Point to the same parsing expression
		// When creating a new choice, we build a new choice node with this tree on the left
		//  and a new one on the right. It saves space.
		
		nt.pegExpr = this.pegExpr;
		
		return nt;
		
	}
	
	public CommonTree getPegExpr() {
		return pegExpr;
	}

	public void setPegExpr(CommonTree pegExpr) {
		this.pegExpr = pegExpr;
	}
	
}
