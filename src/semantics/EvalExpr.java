package semantics;

import org.antlr.runtime.tree.CommonTree;
import srcparser.AdaptablePEGLexer;

public class EvalExpr {

	private Environment env;
	
	public Object eval(CommonTree tree, Environment env) throws Exception {
		this.env = env;
		return eval(tree);
	}
	
	private Object eval(CommonTree tree) throws Exception {
		switch (tree.token.getType()) {
		
		case AdaptablePEGLexer.INT_NUMBER: {
			return new Integer(Integer.parseInt(tree.getText()));
		}

		case AdaptablePEGLexer.OP_ADD: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Integer(i0 + i1);
		}
			
		case AdaptablePEGLexer.OP_MUL: {
			//I suppose there are 2 children
			int i0 = (Integer) eval((CommonTree) tree.getChild(0));
			int i1 = (Integer) eval((CommonTree) tree.getChild(1));
			return new Integer(i0 * i1);
		}
			
		case AdaptablePEGLexer.ID: {
			return env.getValue((Attribute) ((SemanticNode) tree).getSymbol());
		}

		default:
			throw new Exception("Not implemented: " + tree.token.getType());
		}
	}
	
}
