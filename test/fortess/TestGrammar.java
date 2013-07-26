package fortess;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrammar {
	private final String grammar = "input/languages/Fortress/fortress.apeg";
	private final String path = "input/languages/Fortress/tests/";
	
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
		
		// Testing a double right arrow operator, '=>'
		/*resp = Util.testeGrammar(grammar, input + "multi_12.txt", "multi_op");
		assertEquals(2,resp);*/
		
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
	
	/*
	@Test
	public void Test_type() {
		String input = path + "type/";
		int resp = -1;
		
		// Testing extent range
		resp = executeGrammar(grammar, input + "extent_range.txt", "array_size");
		assertEquals(1, resp);
	}*/
	
	/*
	@Test
	public void Test_components_and_apis() {
		String input = path + "component_api/";
		int resp = -1;
		
		// Testing exports
		resp = executeGrammar(grammar, input + "exports.txt", "exports");
		assertEquals(1, resp);
		
		// Testing aliased dotted ids
		resp = executeGrammar(grammar, input + "aliased_dotted_id_01.txt", "aliased_dotted_ids");
		assertEquals(1, resp);
		
		resp = executeGrammar(grammar, input + "aliased_dotted_id_02.txt", "aliased_dotted_ids");
		assertEquals(1, resp);
		
		// Testing aliased names
		resp = executeGrammar(grammar, input + "aliased_name_01.txt", "aliased_names");
		assertEquals(1, resp);
		
		resp = executeGrammar(grammar, input + "aliased_name_02.txt", "aliased_names");
		assertEquals(1, resp);
		
		//Testing names
		resp = executeGrammar(grammar, input + "names.txt", "names");
		assertEquals(1, resp);
		
		//Testing imports
		resp = executeGrammar(grammar, input + "imports.txt", "imports");
		assertEquals(1, resp);
		
		//Testing api
		resp = executeGrammar(grammar, input + "api.txt", "api");
		assertEquals(1, resp);
		
		//Testing component
		resp = executeGrammar(grammar, input + "component.txt", "component");
		assertEquals(1, resp);
		
	}*/
}
