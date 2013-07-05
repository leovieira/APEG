package sugarj;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrammar {
	private String grammar = "input/languages/SugarJ/sugarj.apeg";
	private String path = "input/languages/SugarJ/tests/";
	
	public int executeGrammar(String grammar, String file, String start) {
		try {
			int resp = Util.testeGrammar(grammar, file, start);
			if(resp < 0)
				resp = -1;
			else
				resp = 1;
			return resp;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	
	public int executeGrammar(String grammar, String file, String start, Object[] args) {
		try {
			int resp = Util.testeGrammar(grammar, file, start, args);
			if(resp < 0)
				resp = -1;
			else
				resp = 1;
			return resp;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	
	@Test
	public void TestPeg_factor() {
		Object args[] = new Object[1];
		String s;
		int resp;
		// Testing a literal as peg_factor and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_factor_literal.txt", "peg_factor", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "\'escrevendo alguma coisa aqui\'");
		
		// Testing an Id as a peg_factor
		resp = executeGrammar(grammar, path + "peg_factor_id.txt", "peg_factor", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "identifier_01");
		
		// Testing a Range as a peg_factor
		resp = executeGrammar(grammar, path + "peg_factor_range.txt", "peg_factor", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "[A-Z0-9a-z]");
		
		// Testing an any (.) as a peg_factor
		resp = executeGrammar(grammar, path + "peg_factor_any.txt", "peg_factor", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, ".");
		
		// Testing a parenthesis expression as a peg_factor
		resp = executeGrammar(grammar, path + "peg_factor_parenthesis.txt", "peg_factor", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "()");
	}
}
