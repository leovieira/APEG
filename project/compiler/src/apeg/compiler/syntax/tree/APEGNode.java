package apeg.compiler.syntax.tree;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

public class APEGNode extends CommonTree {
	
	private Symbol symbol;
	
	public APEGNode(Token t) {
		super(t);
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
}
