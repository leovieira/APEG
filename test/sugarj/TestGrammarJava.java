package sugarj;

import java.util.Map;
import java.util.HashMap;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrammarJava {
	private String grammar = "input/languages/Java/java.apeg";
	private String path = "input/languages/Java/tests/";
	
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
	public void TestWhite_space() {
		int resp;
		// Testing a white space
		resp = executeGrammar(grammar, path + "white_space.txt", "ws");
		assertEquals(1, resp);
	}
	
	@Test
	public void TestOperators() {
		int resp;
		// Testing operator @
		resp = executeGrammar(grammar, path + "operator_at.txt", "AT");
		assertEquals(1, resp);
		
		// Testing operator &
		resp = executeGrammar(grammar, path + "operator_and.txt", "AND");
		assertEquals(1, resp);
		
		resp = executeGrammar(grammar, path + "operator_and_fail_01.txt", "AND");
		assertEquals(-1, resp);
		
		resp = executeGrammar(grammar, path + "operator_and_fail_02.txt", "AND");
		assertEquals(-1, resp);
		
		// Testing operator &&
		resp = executeGrammar(grammar, path + "operator_and_and.txt", "ANDAND");
		assertEquals(1, resp);
		
		// Testing operator &=
		resp = executeGrammar(grammar, path + "operator_and_equ.txt", "ANDEQU");
		assertEquals(1, resp);
		
		// Testing operator !
		resp = executeGrammar(grammar, path + "operator_bang.txt", "BANG");
		assertEquals(1, resp);
		
		resp = executeGrammar(grammar, path + "operator_bang_fail.txt", "BANG");
		assertEquals(-1, resp);
	}
	
	@Test
	public void TestCompilation_unit() {
		int resp;
		// Testing a Compilation unit
		resp = executeGrammar(grammar, path + "TestGrammar.java", "compilation_unit");
		assertEquals(1, resp);
	}
}
