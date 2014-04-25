package apeg.compiler.syntax.tree;

import org.antlr.runtime.tree.CommonTree;

import apeg.compiler.syntax.tree.Attribute.Category;

/**
 * A class to represent a Nonterminal symbol.
 * 
 * @author vladimir
 *
 */
public class NonTerminal extends Symbol {
	
	private int numParam; // number of inherited attributes
	private int numRet; // number of synthesized attributes
	private int numLocal; // number of local attributes
	private Attribute[] attrs; // Vector which contains all attributes in the follow order:
	                          //          first all the inherited, followed by the synthesized and at the end the local ones. 
	
	private CommonTree pegExpr; // it is null if the nonterminal has the code generated. 
	                            // Otherwise, it has the parsing expression of the nonterminal (used only during runtime).
	
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
			if (a != null && a.getName().compareTo(name) == 0) {
				return a;
			}
		}
		return null;
	}
	
	public Attribute addAttribute(String name, Type type, Category category, int num) {
		return addAttribute(new Attribute(name, type, category, num));
	}
	
	public Attribute addAttribute(Attribute attr) {
		if (getAttribute(attr.getName()) != null) {
			return null;
		}
		Category category = attr.getCategory();
		int index = attr.getIndex();
		
		if (category == Attribute.Category.PARAM) {
			if (index < 0 || index >= numParam) {
				throw new Error("Invalid number of inherited attribute");
			}
			attrs[index] = attr;
			return attrs[index];
		} else if (category == Attribute.Category.RETURN) {
			if (index < numParam || index >= numRet + numParam) {
				throw new Error("Invalid number of return attribute");
			}
			attrs[index] = attr;
			return attrs[index];
		} else if (category == Attribute.Category.LOCAL) {
			if(index < numParam + numRet || index >= numParam + numRet + numLocal) {
				throw new Error("Invalid number of local attribute");
			}
			attrs[index] = attr;
			return attrs[index];
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
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) // if point to the same objects
			return true;		
		if(obj instanceof NonTerminal) {
			NonTerminal nt = (NonTerminal) obj;
			if(!this.getName().equals(nt) || nt.numParam != this.numParam || nt.numRet != this.numRet || nt.numLocal != this.numLocal)
				return false;
			for(int i = 0; i < attrs.length; ++i) {
				if(!this.attrs[i].equals(nt.attrs[i]))
					return false;
			}
		}
		return false;
	}
}
