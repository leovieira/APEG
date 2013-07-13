package sugarj;

import java.util.Map;
import java.util.HashMap;

import util.Util;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestAdaptability {
	private String grammar = "input/languages/SugarJ/sugarj.apeg";
	private String example = "input/languages/SugarJ/examples/";
	private String test = "input/languages/SugarJ/tests/";
	
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
	public void Test_Type_declaration() {
		Object args[] = new Object[2];
		args[0] = new HashMap<String, String>();
		int resp;
		Map<String,String> map;
		
		// Testing Sugar as a Type Declaration
		args =  new Object[3];
		args[0] = "pair"; // name of the package
		args[1] = new HashMap<String,String>(); // map of names to grammar rules		
				
		resp = executeGrammar(grammar, test + "type_declaration.txt", "type_declaration", args);
		map = (Map<String,String>)args[2];
		assertEquals(true, map.containsKey("pair.Test"));
		assertEquals(1, resp);
	}
	
	@Test
	public void Test_Pair() {
		Object args[] = new Object[2];
		args[0] = new HashMap<String, String>();
		int resp;
		Map<String,String> map;
		
		// Testing the adaptability
		// In this example, I create a rule for Pair and add in the map. I do manually the process.
		String rule = "type: LPAR type COMMA type RPAR;" + "expression: LPAR expression COMMA expression RPAR;";
		String name = "pair.Pair";
		((Map<String,String>)args[0]).put(name, rule);
		resp = executeGrammar(grammar, example + "TestPair.sugj", "compilation_unit", args);
		assertEquals(1, resp);	
		
		// Testing a Pair definition and its use
		args = new Object[2];
		args[0] = new HashMap<String, String>(); // map of names to rules
		
		resp = executeGrammar(grammar, example + "Pair.sugj", "compilation_unit", args);
		assertEquals(1, resp);
		
		map = (Map<String,String>)args[1];
		assertEquals(true, map.containsKey("pair.Pair"));
		
		args = new Object[2];
		args[0] = map; // the map returned by the Pair class is used as input to TestPair class
		resp = executeGrammar(grammar, example + "TestPair.sugj", "compilation_unit", args);
		assertEquals(1, resp);
	}
}
