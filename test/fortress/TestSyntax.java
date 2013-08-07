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
	
	/*
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
	public void Test_item() throws Exception {
		Object args[] = new Object[1];
		int ch;
		
		// Testing a item text
		ch = Util.testeGrammar(grammar, path + "item_01.txt", "item", args);
		assertEquals(3, ch);
		assertEquals("for", (String) args[0]);
		
		// Testing a character class
		ch = Util.testeGrammar(grammar, path + "class.txt", "item", args);
		assertEquals(11, ch);
		assertEquals("[a-zA-Z0-9]", (String) args[0]);
		
		// Testing an any character
		ch = Util.testeGrammar(grammar, path + "any.txt", "item", args);
		assertEquals(1, ch);
		assertEquals(".", (String) args[0]);
		
	}*/
	
	@Test
	public void Test_grammar() throws Exception {
		Object args[] = new Object[3];
		args[0] = grammars();
		int ch;
		
		ch = Util.testeGrammar(grammar, path + "grammar_for.txt", "grammar_def", args);
		
		System.out.println(args[1]);
		System.out.println(args[2]);
		
		
		
		/*args = new Object[1];
		ch = Util.testeGrammar(grammar, path + "test.txt", "syntax_symbols_x", args);
		System.out.println(args[0]);*/
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
