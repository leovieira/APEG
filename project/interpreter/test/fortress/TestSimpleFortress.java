package fortress;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TestSimpleFortress {
	private final String grammar = "input/languages/Fortress/simple_fortress.apeg";
	private final String path = "input/languages/Fortress/tests/syntax/";
	
	
	@Test
	public void Test_grammar() throws Exception {
		Object args[] = new Object[2];
		args[0] = grammars();
		int ch;
		
		// New test
		
		//args = new Object[1];
		ch = Util.testeGrammar(grammar, path + "test.txt", "grammar_def", args);
		GrammarDef g = (GrammarDef) args[1];
		for(String nt : g.getNonterminals()) {
			System.out.println(nt + " : " + g.getRule(nt) + ";");
		}
	}
	
	public Map<String, GrammarDef> grammars() {
		Map<String, GrammarDef> map = new HashMap<String, GrammarDef>();
		
		// Creating the default available nonterminals: they are the spaces nonterminals
		GrammarDef gram_default = new GrammarDef("default");
		gram_default.addNonterminal("w"); // no rule yet
		gram_default.addNonterminal("wr"); // no rule yet
		gram_default.addNonterminal("br"); // no rule yet
		gram_default.addNonterminal("s"); // no rule yet
		gram_default.addNonterminal("sr"); // no rule yet
		
		map.put("default", gram_default);	
		
		// Creating the name of the nonterminals of expression. This is not the all names
		GrammarDef gram_expr = new GrammarDef("Expression");
		gram_expr.addNonterminal("Expr"); // no rule yet
		
		map.put("Expression", gram_expr);
		
		// Creating the name of the nonterminals of identifiers. This is not the all names
		GrammarDef gram_id = new GrammarDef("Identifier");
		gram_id.addNonterminal("Id"); // no rule yet
		
		map.put("Identifier", gram_id);
		
		return map;
	}
}
