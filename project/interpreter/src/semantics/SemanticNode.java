package semantics;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;

public class SemanticNode extends CommonTree {
	
	private Symbol symbol;
	
	public SemanticNode(Token t) {
		super(t);
	}

	public Symbol getSymbol() {
		return symbol;
	}

	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
}
