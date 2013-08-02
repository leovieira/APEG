package fortess;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrammar {
	private final String grammar = "input/languages/Fortress/fortress.apeg";
	private final String path = "input/languages/Fortress/tests/";
	
	@Test
	public void Test_expression() throws Exception {
		String input = path + "expression/";
		int ch;
		
		// Testing a primary front
		//ch = Util.testeGrammar(grammar, input + "map_expr.txt", "primary_front");
		//assertEquals(30,ch);  // map expression
		
		//ch = Util.testeGrammar(grammar, input + "comprehension.txt", "comprehension");
		//assertEquals(47,ch);  // comprehension
		
		
	}
	
	@Test
	public void Test_keyword_expression() throws Exception {
		String input = path + "expression/keyword/";
		int ch;
		
		// Testing a do expression
		//ch = Util.testeGrammar(grammar, input + "do.txt", "delimited_expr");
		//assertEquals(16,ch);
		//assertEquals(175,ch);
		
		// Testing a map expression
		ch = Util.testeGrammar(grammar, input + "map_expr.txt", "map_expr");
		assertEquals(30,ch);
		
		// Testing an entry
		ch = Util.testeGrammar(grammar, input + "entry.txt", "entry_list");
		assertEquals(27,ch);
		
		// Testing a list of expressions
		ch = Util.testeGrammar(grammar, input + "expr_list.txt", "expr_list");
		assertEquals(25,ch);
		
		// Testing a left side of an array comprehension
		ch = Util.testeGrammar(grammar, input + "array_comprehension_left_01.txt", "array_comprehension_left");
		assertEquals(7,ch);
		
		ch = Util.testeGrammar(grammar, input + "array_comprehension_left_02.txt", "array_comprehension_left");
		assertEquals(30,ch);
		
		// Testing an array comprehension clause
		ch = Util.testeGrammar(grammar, input + "array_comprehension_clause.txt", "array_comprehension_clause");
		assertEquals(33,ch);
		
		// Testing a comprehension expression
		ch = Util.testeGrammar(grammar, input + "comprehension_01.txt", "comprehension");
		assertEquals(41,ch);
		
		ch = Util.testeGrammar(grammar, input + "comprehension_02.txt", "comprehension");
		assertEquals(39,ch);
		
		ch = Util.testeGrammar(grammar, input + "comprehension_03.txt", "comprehension");
		assertEquals(38,ch);
		
		// Testing a catch
		ch = Util.testeGrammar(grammar, input + "catch.txt", "catch");
		assertEquals(105,ch);
		
		// Testing  type case
		ch = Util.testeGrammar(grammar, input + "type_case.txt", "type_case_clauses");
		assertEquals(36,ch);
		
		// Testing a clause case
		ch = Util.testeGrammar(grammar, input + "case_clause.txt", "case_clauses");
		assertEquals(56,ch);
		
		// Testing else case		
		ch = Util.testeGrammar(grammar, input + "else_case.txt", "case_else");
		assertEquals(16,ch);
		
		// Testing parenthesized expression
		ch = Util.testeGrammar(grammar, input + "parenthesized.txt", "delimited_expr");
		assertEquals(10,ch);
		
		// Testing an arg expression
		ch = Util.testeGrammar(grammar, input + "tuple_expr.txt", "delimited_expr");
		assertEquals(11,ch); // tuple expression
		
		ch = Util.testeGrammar(grammar, input + "keyword_expr.txt", "delimited_expr");
		assertEquals(25,ch); // arg expression with keyword
		
		// Testing a do expression
		ch = Util.testeGrammar(grammar, input + "do.txt", "delimited_expr");
		assertEquals(180,ch);
		
		// Testing a object expression
		ch = Util.testeGrammar(grammar, input + "object.txt", "delimited_expr");
		assertEquals(13,ch);
		
		// Testing a label expression
		ch = Util.testeGrammar(grammar, input + "label.txt", "delimited_expr");
		assertEquals(26,ch);
		
		// Testing a while expression
		ch = Util.testeGrammar(grammar, input + "while.txt", "delimited_expr");
		assertEquals(25,ch);
		
		// Testing a for expression
		ch = Util.testeGrammar(grammar, input + "for.txt", "delimited_expr");
		assertEquals(38,ch);
		
		// Testing a if expression
		ch = Util.testeGrammar(grammar, input + "if.txt", "delimited_expr");
		assertEquals(111,ch); // it has elif and else case
		
		ch = Util.testeGrammar(grammar, input + "parenthesized_if.txt", "delimited_expr");
		assertEquals(115,ch); // parenthesized if
		
		// Testing a case expression
		//ch = Util.testeGrammar(grammar, input + "for.txt", "delimited_expr");
		//assertEquals(38,ch);
	}
	
	/*
	@Test
	public void Test_local_declaration() throws Exception {
		String input = path + "local_declaration/";
		int ch;
			
		// Testing var args
		ch = Util.testeGrammar(grammar, input + "var_args.txt", "var_args_local");
		assertEquals(11,ch);
		
		// Testing a local parameter
		ch = Util.testeGrammar(grammar, input + "param.txt", "params_local");
		assertEquals(19,ch);
		
		// Testing a definition of a keyword
		ch = Util.testeGrammar(grammar, input + "keyword.txt", "keyword_local");
		assertEquals(13,ch);
		
		// Testing a local variavle declaration
		ch = Util.testeGrammar(grammar, input + "local_var_01.txt", "local_var_decl");
		assertEquals(17,ch);
		
		ch = Util.testeGrammar(grammar, input + "local_var_02.txt", "local_var_decl");
		assertEquals(35,ch);
		
		ch = Util.testeGrammar(grammar, input + "local_var_03.txt", "local_var_decl");
		assertEquals(40,ch);
		
		ch = Util.testeGrammar(grammar, input + "local_var_04.txt", "local_var_decl");
		assertEquals(34,ch);
		
		ch = Util.testeGrammar(grammar, input + "local_var_05.txt", "local_var_decl");
		assertEquals(32,ch);
		
		// Testing a case clause
		ch = Util.testeGrammar(grammar, input + "block_elems.txt", "case_clause");
		assertEquals(57,ch);
	}
	
	@Test
	public void Test_literal() throws Exception {
		String input = path + "literal/";
		int ch;
		boolean resp;
		
		// Testing a char literal
		ch = Util.testeGrammar(grammar, input + "char_01.txt", "literal_expr");
		assertEquals(3,ch); // it's not a escape character
		
		resp = Util.isRecognized(grammar, input + "char_fail_01.txt", "literal_expr");
		assertEquals(false,resp); // there are more then one character between ' and '
		
		resp = Util.isRecognized(grammar, input + "char_fail_02.txt", "literal_expr");
		assertEquals(false,resp); // there is no character between ' and '
		
		ch = Util.testeGrammar(grammar, input + "char_02.txt", "literal_expr");
		assertEquals(4,ch); // it's a escape character
		
		resp = Util.isRecognized(grammar, input + "char_fail_03.txt", "literal_expr");
		assertEquals(false,resp); // it is not a escape character
		
		// Testing a String Literal
		ch = Util.testeGrammar(grammar, input + "string.txt", "literal_expr");
		assertEquals(40,ch);
		
		// Testing a int literal
		ch = Util.testeGrammar(grammar, input + "integer.txt", "literal_expr");
		assertEquals(5,ch);
		
		// Testing a float literal
		ch = Util.testeGrammar(grammar, input + "float.txt", "literal_expr");
		assertEquals(6,ch);
		
		// Testing a void expression
		ch = Util.testeGrammar(grammar, input + "void.txt", "literal_expr");
		assertEquals(3,ch);
	}
	
	@Test
	public void Test_decl() throws Exception {
		String input = path + "declaration/";
		int ch;
		
		// Testing a declaration of a type alias
		ch = Util.testeGrammar(grammar, input + "type_alias.txt", "decl");
		assertEquals(27, ch);
		
		// Testing a property declaration
		ch = Util.testeGrammar(grammar, input + "test.txt", "decl");
		assertEquals(74, ch);
		
		// Testing a declaration of a test
		//ch = Util.testeGrammar(grammar, input + "test.txt", "decl");
		//assertEquals(54, ch);
	}

	@Test
	public void Test_spaces_and_comments() {
		String input = path + "space_comment/";
		boolean resp;
		
		// Testing a white space
		resp = Util.isRecognized(grammar, input + "spaces.txt", "wr");
		assertEquals(true, resp);
		
		resp = Util.isRecognized(grammar, input + "spaces_fail.txt", "sr"); // tab is not a valid space in Fortress
		assertEquals(false, resp);
		
		// Testing a comment
		resp = Util.isRecognized(grammar, input + "comments.txt", "comment");
		assertEquals(true, resp);
		
		// Testing a comment without new lines
		resp = Util.isRecognized(grammar, input + "no_new_line_comment.txt", "no_new_line_comment");
		assertEquals(true, resp);
		
		resp = Util.isRecognized(grammar, input + "comments.txt", "no_new_line_comment");
		assertEquals(false, resp);
	}
	
	@Test
	public void Test_identifier() throws Exception {
		String input = path + "identifiers/";
		int resp;
		boolean b;
		
		//Testing an identifier name
		resp = Util.testeGrammar(grammar, input + "identifier.txt", "id");
		assertEquals(12, resp);
		
		b = Util.isRecognized(grammar, input + "identifier_fail_01.txt", "id");
		assertEquals(false, b); // an underscore is not a identifier
		
		b = Util.isRecognized(grammar, input + "identifier_fail_02.txt", "id");
		assertEquals(false, b); // a keyword is not a identifier
		
		b = Util.isRecognized(grammar, input + "identifier_fail_03.txt", "id");
		assertEquals(false, b); // an operator name is not a identifier
		
		//Testing a bind identifier
		resp = Util.testeGrammar(grammar, input + "bind.txt", "bind_id_list");
		assertEquals(28, resp);
		
		//Testing a bind tuple
		resp = Util.testeGrammar(grammar, input + "bind_tuple.txt", "bind_id_or_bind_tuple");
		assertEquals(24, resp);
		
		//Testing a qualified name
		resp = Util.testeGrammar(grammar, input + "qualified_name.txt", "qualified_name");
		assertEquals(15, resp);
	}
	
	@Test
	public void Test_operator_comp() throws Exception {
		String input = path + "operator/";
		int resp;
		
		// Testing operator '->'
		resp = Util.testeGrammar(grammar, input + "implies_01.txt", "implies");
		assertEquals(2,resp);
		
		resp = Util.testeGrammar(grammar, input + "implies_02.txt", "implies");
		assertEquals(7,resp);
		
		//Testing operator '>'
		resp = Util.testeGrammar(grammar, input + "greater_than_01.txt", "greater_than");
		assertEquals(1,resp);
		
		resp = Util.testeGrammar(grammar, input + "greater_than_02.txt", "greater_than");
		assertEquals(2,resp);
		
		//Testing operator '>='
		resp = Util.testeGrammar(grammar, input + "greater_than_equal_01.txt", "greater_than_equal");
		assertEquals(2,resp);
		
		resp = Util.testeGrammar(grammar, input + "greater_than_equal_02.txt", "greater_than_equal");
		assertEquals(2,resp);
		
		// Testing operator '<'
		resp = Util.testeGrammar(grammar, input + "less_than_01.txt", "less_than");
		assertEquals(1,resp);
		
		resp = Util.testeGrammar(grammar, input + "less_than_02.txt", "less_than");
		assertEquals(2,resp);
		
		// Testing operator '<='
		resp = Util.testeGrammar(grammar, input + "less_than_equal_01.txt", "less_than_equal");
		assertEquals(2,resp);
		
		resp = Util.testeGrammar(grammar, input + "less_than_equal_02.txt", "less_than_equal");
		assertEquals(2,resp);
	}
	
	@Test
	public void Test_operator_multi() throws Exception {
		String input = path + "operator/";
		int resp;
				
		// Testing operator '-/->'
		resp = Util.testeGrammar(grammar, input + "multi_01.txt", "multi_op");
		assertEquals(4,resp);
		
		// Testing operator '<-/-'
		resp = Util.testeGrammar(grammar, input + "multi_02.txt", "multi_op");
		assertEquals(4,resp);
		
		// Testing opeartor '-->'
		resp = Util.testeGrammar(grammar, input + "multi_03.txt", "multi_op");
		assertEquals(3,resp);
		
		// Testing operator '==>'
		resp = Util.testeGrammar(grammar, input + "multi_04.txt", "multi_op");
		assertEquals(3,resp);
		
		// Testing operator '>>>'
		resp = Util.testeGrammar(grammar, input + "multi_05.txt", "multi_op");
		assertEquals(3,resp);
		
		// Testing operator '|->'
		resp = Util.testeGrammar(grammar, input + "multi_06.txt", "multi_op");
		assertEquals(3,resp);
		
		// Testing operator '<<<'
		resp = Util.testeGrammar(grammar, input + "multi_07.txt", "multi_op");
		assertEquals(3,resp);
		
		// Testing operator '<->'
		resp = Util.testeGrammar(grammar, input + "multi_08.txt", "multi_op");
		assertEquals(3,resp);
		
		// Testing operator '<-'
		resp = Util.testeGrammar(grammar, input + "multi_09.txt", "multi_op");
		assertEquals(2,resp);
		
		// Testing opeartor '<=>'
		resp = Util.testeGrammar(grammar, input + "multi_10.txt", "multi_op");
		assertEquals(3,resp);
		
		// Testing operator '->'
		resp = Util.testeGrammar(grammar, input + "multi_11.txt", "multi_op");
		assertEquals(2,resp);
			
		// Testing operator '>>'
		resp = Util.testeGrammar(grammar, input + "multi_13.txt", "multi_op");
		assertEquals(2,resp);
		
		// Testing operator '<<'
		resp = Util.testeGrammar(grammar, input + "multi_14.txt", "multi_op");
		assertEquals(2,resp);
		
		// Testing operator '**'
		resp = Util.testeGrammar(grammar, input + "multi_15.txt", "multi_op");
		assertEquals(2,resp);
		
		// Testing operator '!!'
		resp = Util.testeGrammar(grammar, input + "multi_16.txt", "multi_op");
		assertEquals(2,resp);
		
		// Testing operator '::'
		resp = Util.testeGrammar(grammar, input + "multi_17.txt", "multi_op");
		assertEquals(2,resp);
		
		// Testing operator '///'
		resp = Util.testeGrammar(grammar, input + "multi_18.txt", "multi_op");
		assertEquals(3,resp);
		
		// Testing operator '//'
		resp = Util.testeGrammar(grammar, input + "multi_19.txt", "multi_op");
		assertEquals(2,resp);
	}
	
	@Test
	public void Test_operator_name() throws Exception {
		String input = path + "operator/";
		int num;
		boolean resp;
		
		// Testing a operator name with two letters
		num = Util.testeGrammar(grammar, input + "op_name_01.txt", "op_name");
		assertEquals(2,num);
		
		resp = Util.isRecognized(grammar, input + "op_name_fail_01.txt", "op_name");
		assertEquals(false,resp);
		
		resp = Util.isRecognized(grammar, input + "op_name_fail_02.txt", "op_name");
		assertEquals(false,resp);
		
		// Testing a operator name with more than two letters
		num = Util.testeGrammar(grammar, input + "op_name_02.txt", "op_name");
		assertEquals(3,num);
		
		num = Util.testeGrammar(grammar, input + "op_name_03.txt", "op_name");
		assertEquals(10,num);
		
		num = Util.testeGrammar(grammar, input + "op_name_04.txt", "op_name");
		assertEquals(7,num);
		
		resp = Util.isRecognized(grammar, input + "op_name_fail_03.txt", "op_name");
		assertEquals(false,resp);
		
		resp = Util.isRecognized(grammar, input + "op_name_fail_04.txt", "op_name");
		assertEquals(false,resp);
		
		resp = Util.isRecognized(grammar, input + "op_name_fail_05.txt", "op_name");
		assertEquals(false,resp);
	}
	
	@Test
	public void Test_type() throws Exception {
		String input = path + "type/";
		boolean resp;
		int num;
		
		// Testing type primary
		num = Util.testeGrammar(grammar, input + "parenthesized_type.txt", "type_primary");
		assertEquals(26, num); // parenthesized_type parenthesized_type_left
		
		num = Util.testeGrammar(grammar, input + "domain_01.txt", "type_primary");
		assertEquals(23, num); // domain exponentiation
		
		num = Util.testeGrammar(grammar, input + "domain_02.txt", "type_primary");
		assertEquals(86, num); // domain exponentiation
		
		num = Util.testeGrammar(grammar, input + "tuple_type.txt", "type_primary");
		assertEquals(105, num); // tuple_type array_type_size
		
		num = Util.testeGrammar(grammar, input + "type_ref_01.txt", "type_primary");
		assertEquals(5, num); // type_ref
		
		num = Util.testeGrammar(grammar, input + "type_ref_02.txt", "type_primary");
		assertEquals(19, num); // type_ref
		
		num = Util.testeGrammar(grammar, input + "void_type.txt", "type_primary");
		assertEquals(3, num); // void_type
		
		// Testing tight infix postfix
		
	}*/
	
}
