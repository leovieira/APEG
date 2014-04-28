package generated;

import org.antlr.runtime.tree.CommonTree;

import apeg.compiler.runtime.APEGInputStream;
import apeg.compiler.runtime.Grammar;
import apeg.compiler.runtime.Result;
import apeg.compiler.runtime.interpreter.Environment;
import apeg.compiler.syntax.tree.Attribute;
import apeg.compiler.syntax.tree.NonTerminal;
import apeg.compiler.syntax.tree.Type;

public class Test extends Grammar {

	protected Test(APEGInputStream input) {
		super(input);
		
		nonterminals = new NonTerminal[2];
		adapt = new CommonTree[2];

		NonTerminal nt;
		// informations of the nonterminal nt01
		nt = new NonTerminal("nt01", 1); // size of inherited plus synthesized attributes is 1
		nt.addAttribute("$g", new Type("Grammar"), Attribute.Category.PARAM);
		nonterminals[0] = nt;
		ntIndex.put("nt01", 0);
		
		// informations of the nonterminal nt02
		nt = new NonTerminal("nt02", 4); // size of inherited plus synthesized attributes is 4
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("i", new Type("int"), Attribute.Category.PARAM);
		nt.addAttribute("c", new Type("char"), Attribute.Category.PARAM);
		nt.addAttribute("s", new Type("String"), Attribute.Category.RETURN);
		nonterminals[1] = nt;
		ntIndex.put("nt02", 1);
	}

	public Result nt01(Test g) throws Exception {
		
		// Add rules
		Test g1 = (Test) g.copy();
		g1.addRule("nt02: nt<g>; nt locals[int i, Grammar g1]: !.;"
				+ "nt locals[int x]: {i = 0;} 'nothing' {x = i; g1 = g;} {? x == 0};");
		
		// Call nonterminal nt02
		Result result = g.nt02(g1, 0, 'c');
		if(!result.isFail()) {
			return result;
		} // else

		Environment env = new Environment(nonterminals[0].getNumParam()
				                        + nonterminals[0].getNumRet()
				                        + nonterminals[0].getNumLocal());
		env.setValue(0, g);
		
		return g.interpreteChoice(0, env);
	}
	
	public Result nt02(Test g, int i, char c) throws Exception {		
		// it has nothing
		
		Environment env = new Environment(nonterminals[1].getNumParam()
                                        + nonterminals[1].getNumRet()
                                        + nonterminals[1].getNumLocal());
		env.setValue(0, g);
		
		return g.interpreteChoice(1, env);
	}
	
	public static void main(String[] args) throws Exception {
		APEGInputStream input = new APEGInputStream("nothing");
		Test parser = new Test(input);
		
		Result result = parser.nt01(parser);
		System.out.println("Portion consumed of the input: " + result.getNext_pos());
	}
}
