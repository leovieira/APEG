package sugarj;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrammarSugarJ {
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
		assertEquals(s, "(a / ab)");
	}
	
	@Test
	public void TestPeg_unary_op() {
		Object args[] = new Object[1];
		String s;
		int resp;
		// Testing a repeat as peg_unary_op and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_unary_op_repeat.txt", "peg_unary_op", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "nonterminal*");
		
		// Testing an one-or-more as peg_unary_op and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_unary_op_one_or_more.txt", "peg_unary_op", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "[a-z0-9A-Z]+");
		
		// Testing an optional as peg_unary_op and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_unary_op_optional.txt", "peg_unary_op", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "\'abc testando\'?");
		
	}
	
	@Test
	public void TestPeg_predicate() {
		Object args[] = new Object[1];
		String s;
		int resp;
		// Testing a not-predicate as peg_predicate and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_predicate_not.txt", "peg_predicate", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "![a-z0-9A-Z]");
		
		// Testing a and-predicate as peg_predicate and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_predicate_and.txt", "peg_predicate", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "&[a-z0-9A-Z]");		
	}
	
	@Test
	public void TestPeg_seq() {
		Object args[] = new Object[1];
		String s;
		int resp;
		// Testing peg_seq and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_seq.txt", "peg_seq", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "&[a-z0-9A-Z]+ !. identifier_01* \'abc testando\'?");
	}
	
	@Test
	public void TestPeg_expr() {
		Object args[] = new Object[1];
		String s;
		int resp;
		// Testing peg_seq and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_expr.txt", "peg_expr", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "&[a-z0-9A-Z]+ / !. identifier_01* / \'abc testando\'?");
	}
	
	@Test
	public void TestPeg_rule() {
		Object args[] = new Object[1];
		String s;
		int resp;
		// Testing peg_rule and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "peg_rule.txt", "peg_rule", args);
		s = (String) args[0];
		assertEquals(1, resp);
		assertEquals(s, "JavaType: \'(\' JavaTyype \',\' JavaType \')\';JavaExpr: \'(\' JavaExpr \',\' JavaExpr \')\';");
	}
	
	@Test
	public void TestSugar_declaration() {
		Object args[] = new Object[2];
		String name, s;
		int resp;
		// Testing peg_rule and check if the returns string has the correct value
		resp = executeGrammar(grammar, path + "sugar_declaration.txt", "sugar_declaration", args);
		name = (String) args[0];
		s = (String) args[1];
		assertEquals(1, resp);
		assertEquals(name, "Test");
		assertEquals(s, "JavaType: \'(\' JavaTyype \',\' JavaType \')\';JavaExpr: \'(\' JavaExpr \',\' JavaExpr \')\';");
	}
}
