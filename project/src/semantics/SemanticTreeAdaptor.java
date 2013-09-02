package semantics;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTreeAdaptor;

public class SemanticTreeAdaptor extends CommonTreeAdaptor {
	
	public Object create(Token payload) {
		return new SemanticNode(payload);
	}

}
