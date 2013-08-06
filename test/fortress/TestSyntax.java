package fortress;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

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
		
	}
	

}
