package apeg.syntax;

import java.io.IOException;

import org.antlr.runtime.RecognitionException;

import apeg.common.path.AbsolutePath;
import apeg.common.path.Path;
import apeg.common.path.RelativePath;

public class TestSyntax {

	public static void main(String[] args) throws IOException, RecognitionException {
		String grammarFileName="./../test/syntax/teste00.apeg";
		
		Path path = new AbsolutePath(grammarFileName);
		Main.parse(path);
		
		System.out.println("------------- END -------------------");
	}

}
