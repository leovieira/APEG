package apeg.compiler.syntax.tree;

import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTreeAdaptor;

public class APEGTreeAdaptor extends CommonTreeAdaptor {
	
	public Object create(Token payload) {
		return new APEGNode(payload);
	}

}
