package fortress;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class TestSyntax {
	private final String grammar = "input/languages/Fortress/fortress.apeg";
	private final String path = "input/languages/Fortress/tests/syntax/";
	
	
	@Test
	public void TestFortressExamples() throws Exception {
		//boolean resp;
		int ch;
		
		ch = Util.testeGrammar(grammar, path + "For.fsi", "file");
		assertEquals(1479, ch);
		
		//ch = Util.testeGrammar(grammar, path + "GrammarComposition.fsi", "file");
		//assertEquals(1676, ch);
	}
	
	@Test
	public void Test_grammar() throws Exception {
		Object args[] = new Object[3];
		args[0] = grammars();
		int ch;
		
		/*ch = Util.testeGrammar(grammar, path + "grammar_for.txt", "grammar_def", args);
		assertEquals(ch, 530);
		assertEquals("ForLoop", args[1]);*/
		
		// New test
		
		//args = new Object[1];
		ch = Util.testeGrammar(grammar, path + "test.txt", "grammar_def", args);
		String s = (String)args[2];
		System.out.println(s);
	}
	
	public Map<String, List<String>> grammars() {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		// Creating the default available nonterminals: they are the spaces nonterminals
		String name = "default";
		List<String> nonterminals = new ArrayList<String>();
		nonterminals.add("w");
		nonterminals.add("wr");
		nonterminals.add("br");
		nonterminals.add("sr");
		nonterminals.add("s");
		map.put(name, nonterminals);
		
		// Creating the name of the nonterminals of expression. This is not the all names
		name = "Expression";
		nonterminals = new ArrayList<String>();
		nonterminals.add("Expr");
		map.put(name, nonterminals);
		
		// Creating the name of the nonterminals of identifiers. This is not the all names
		name = "Identifier";
		nonterminals = new ArrayList<String>();
		nonterminals.add("Id");
		map.put(name, nonterminals);
		
		return map;
	}
}
