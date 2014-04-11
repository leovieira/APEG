package generated;

import apeg.common.path.AbsolutePath;
import apeg.common.path.Path;
import apeg.compiler.runtime.APEGInputStream;
import apeg.compiler.runtime.Result;

public class ExecTest {

	public static void main(String[] args) throws Exception {
		// Teste DataDependent (teste06.apeg)
		String inputName = "./../test/syntax/input/teste06_input.txt";
		Path inputPath = new AbsolutePath(inputName);
		
		// Parser
		APEGInputStream input = new APEGInputStream(inputPath);
		DataDependent parser = new DataDependent(input);
		
		// Run
		//Result result = parser.literal3(parser);
		
		Result result = parser.literal(parser);
		System.out.println(result.getNext_pos());

	}

}
