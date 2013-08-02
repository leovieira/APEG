package fortess;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestFortress {
	private final String grammar = "input/languages/Fortress/fortress.apeg";
	private final String path = "input/languages/Fortress/tests/fortress_examples/";
	
	
	@Test
	public void TestFortressExamples() throws Exception {
		//boolean resp;
		int ch;
		
		ch = Util.testeGrammar(grammar, path + "DeclTest.fss", "file");
		assertEquals(570, ch);
	}
	

	

}
