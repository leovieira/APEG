package semantics;

import java.util.ArrayList;
import java.util.Iterator;

import org.antlr.runtime.tree.CommonTree;
import semantics.Attribute.Category;

public class NonTerminal extends Symbol {
	
	private int numParam;
	private int numRet;
	private int numLocal;
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
		
		ArrayList<Attribute> atr = new ArrayList<Attribute>();
		Iterator<Attribute> it = attrs.iterator();
		// Note que criei uma nova lista de atributos
		// Porém, inserir os mesmos ponteiros dos valores dos outros
		// Isso permitir inserir novos atributos locais sem alterar o anterior
		while(it.hasNext())
			atr.add(it.next());
<<<<<<< HEAD
=======
		
		// --- VLADIMIR
		// faltou colocar os atributos no objeto
		nt.attrs = atr;
		
>>>>>>> c2efe4b461cba9d7e6a8b7e70910149c1537758b
		// Vou apontar para a mesma expressão
		// Quando eu inserir uma nova regra irei criar um novo nó choice
		// que terá essa árvore do lado esquerdo e uma nova do lado direito
		// Assim economizo memoria
		nt.pegExpr = this.pegExpr;
		
		return nt;
		
	}
	
}
