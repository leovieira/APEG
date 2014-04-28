package apeg.compiler.syntax.tree;

import java.util.ArrayList;
import java.util.List;

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
	
	private Attribute[] attrs; // Vector which contains all inherited attributes followed by the synthesized ones
	private List<Attribute> locals; // list with all locals attributes: it can change during adaptability
	
	private CommonTree pegExpr; // it is null if the nonterminal has the code generated. 
	                            // Otherwise, it has the parsing expression of the nonterminal (used only during runtime).
	
	/**
	 * 
	 * @param name The number of inherited and synthesized attributes
	 * @param size
	 */
	public NonTerminal(String name, int size) {
		super(name);
		this.numParam = 0;
		this.numRet = 0;
		this.numLocal = 0;
		attrs = new Attribute[size];
		locals = new ArrayList<Attribute>();
	}

	public int numAttrs() {
		return getNumParam() + getNumRet() + getNumLocal();
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
		return locals.get(i);
	}
	
	public Attribute getAttribute(String  name) {
		for (Attribute a : attrs) { // search in the list of inherited and synthesized attributes
			if (a != null && a.getName().compareTo(name) == 0) {
				return a;
			}
		}
		for(Attribute a : locals) { // search in the list of locals attributes
			if(a != null && a.getName().compareTo(name) == 0)
				return a;
		}
		return null;
	}
	
	public Attribute addAttribute(String name, Type type, Category category) {
		if (getAttribute(name) != null) {
			return null;
		}		
		if (category == Attribute.Category.PARAM) {
			if (numRet > 0 || numLocal > 0) {
				throw new Error("Inherited attributes must come before synthesized and local attributes");
			}
			if(numParam >= attrs.length) {
				throw new Error("It is impossible to add more inherited attributes");
			}
			Attribute attr = new Attribute(name, type, category, numParam);
			return attrs[numParam++] = attr;
		} else if (category == Attribute.Category.RETURN) {
			if (numLocal > 0) {
				throw new Error("Synthesized attributes must come before local attributes");
			}
			if(numParam + numRet >= attrs.length) {
				throw new Error("It is impossible to add more synthesized attributes");
			}
			Attribute attr = new Attribute(name, type, category, numParam + numRet);
			return attrs[numParam + numRet++] = attr;
		} else if (category == Attribute.Category.LOCAL) {
			Attribute attr = new Attribute(name, type, category, numParam + numRet + numLocal++);
			locals.add(attr);
			return attr;
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
		return numLocal;
	}
	
	public NonTerminal copy() {
		NonTerminal nt = new NonTerminal(getName(), numParam + numRet);
		nt.numParam = this.numParam;
		nt.numRet = this.numRet;
		nt.numLocal = this.numLocal;
		
		for(int i = 0; i < attrs.length; i++) {
			// Note there is a new vector of attributes. However, the two list set for the same attribute values
			// This allow us to change the nonterminal attributes without changes the old one, and save space
			nt.attrs[i] = attrs[i];
		}
		nt.locals = new ArrayList<Attribute>(this.locals);
		
		// Point to the same parsing expression
		// When creating a new choice, we build a new choice node with this tree on the left
		//  * and a new one on the right. It saves space.
		
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
			for(int i = 0; i < numParam + numRet; ++i) {
				if(!this.attrs[i].equals(nt.attrs[i]))
					return false;
			}
			for(int i = 0; i < numLocal; ++i) {
				if(!this.locals.get(i).equals(nt.locals.get(i)))
					return false;
			}
		}
		return false;
	}
}
