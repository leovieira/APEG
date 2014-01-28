package semantics;

import java.util.ArrayList;
import java.util.Iterator;

import org.antlr.runtime.tree.CommonTree;
import semantics.Attribute.Category;

/**
 * A class to represent a Nonterminal symbol.
 * 
 * It offers a method to add a Grammar as its first inherited attribute.
 * This method is necessary because all nonterminals in an APEG must have this attribute.
 * Although the parser allows a programmer to omit this attribute in some cases,
 * it must be inserted not only because of attribute evaluation, but also because
 * the use of an additional attribute may affect the memoization mechanism.
 * 
 * @author vladimir
 *
 */
public class NonTerminal extends Symbol {
	
	private int numParam;
	private int numRet;
	private int numLocal;
	private ArrayList<Attribute> attrs = new ArrayList<Attribute>();
	private CommonTree pegExpr;
	private boolean addedGrammarAttribute;
	
	public NonTerminal(String name) {
		super(name);
		addedGrammarAttribute = false;
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
	
	public Attribute getParam(int i) {
		if (i >= getNumParam()) {
			throw new Error("Wrong index at getParam");
		}
		return attrs.get(i);
	}
	
	public Attribute getReturn(int i) {
		if (i >= getNumRet()) {
			throw new Error("Wrong index at getReturn");
		}
		return attrs.get(i + getNumParam());
	}
	
	public Attribute getLocal(int i) {
		if (i >= getNumLocal()) {
			throw new Error("Wrong index at getLocal");
		}
		return attrs.get(i + getNumParam() + getNumRet());
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
		if (category == Attribute.Category.PARAM) {
			if (numRet > 0 || numLocal > 0) {
				throw new Error("Inhereted attributes must come before synthesized and local attributes");
			}
			++numParam;
		} else if (category == Attribute.Category.RETURN) {
			if (numLocal > 0) {
				throw new Error("Synthesized attributes must come before local attributes");
			}
			++numRet;
		} else if (category == Attribute.Category.LOCAL) {
			++numLocal;
		}
		Attribute a = new Attribute(name, type, category, attrs.size());
		attrs.add(a);
		return a;
	}

	public void addGrammarAttribute() {
//		System.out.println("Adding grammar attribute to " + getName());
		Attribute a = new Attribute("grammar", new Type("Grammar"), Category.PARAM, 0);
		attrs. add(0, a);
		for (int i = 1; i < attrs.size(); ++i) {
			attrs.get(i).setIndex(attrs.get(i).getIndex() + 1);
		}
		++numParam;
		addedGrammarAttribute = true;
	}
	
	public boolean addedGrammarAttribute() {
		return addedGrammarAttribute;
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
		NonTerminal nt = new NonTerminal(getName());
		nt.numParam = this.numParam;
		nt.numLocal = this.numLocal;
		nt.numRet = this.numRet;
		nt.addedGrammarAttribute = this.addedGrammarAttribute;
		
		ArrayList<Attribute> atr = new ArrayList<Attribute>();
		Iterator<Attribute> it = attrs.iterator();
		// Note que criei uma nova lista de atributos
		// Porém, inserir os mesmos ponteiros dos valores dos outros
		// Isso permitir inserir novos atributos locais sem alterar o anterior
		while(it.hasNext())
			atr.add(it.next());
		// --- VLADIMIR
		// faltou colocar os atributos no objeto
		nt.attrs = atr;
		
		// Vou apontar para a mesma expressão
		// Quando eu inserir uma nova regra irei criar um novo nó choice
		// que terá essa árvore do lado esquerdo e uma nova do lado direito
		// Assim economizo memoria
		nt.pegExpr = this.pegExpr;
		
		return nt;
		
	}
	
}
