package fortess;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestGrammar {
	private final String grammar = "input/languages/Fortress/fortress.apeg";
	private final String path = "input/languages/Fortress/tests/";
	
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
	public void Test_spaces_and_comments() {
		String input = path + "space_comment/";
		int resp = -1;
		
		// Testing a white space
		resp = executeGrammar(grammar, input + "spaces.txt", "wr");
		assertEquals(1, resp);
		
		resp = executeGrammar(grammar, input + "spaces_fail.txt", "sr"); // tab is not a valid space in Fortress
		assertEquals(-1, resp);
		
		// Testing a comment
		resp = executeGrammar(grammar, input + "comments.txt", "comment");
		assertEquals(1, resp);
		
		// Testing a comment without new lines
		resp = executeGrammar(grammar, input + "no_new_line_comment.txt", "no_new_line_comment");
		assertEquals(1, resp);
		
		resp = executeGrammar(grammar, input + "comments.txt", "no_new_line_comment");
		assertEquals(-1, resp);
	}
	
	@Test
	public void Test_identifier() throws Exception {
		String input = path + "identifiers/";
		int resp = -1;
		
		//Testing an identifier name
		resp = Util.testeGrammar(grammar, input + "identifier.txt", "id");
		assertEquals(12, resp);
		
		resp = executeGrammar(grammar, input + "identifier_fail_01.txt", "id");
		assertEquals(-1, resp); // an underscore is not a identifier
		
		resp = executeGrammar(grammar, input + "identifier_fail_02.txt", "id");
		assertEquals(-1, resp); // a keyword is not a identifier
		
		resp = executeGrammar(grammar, input + "identifier_fail_03.txt", "id");
		assertEquals(-1, resp); // an operator name is not a identifier
		
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
