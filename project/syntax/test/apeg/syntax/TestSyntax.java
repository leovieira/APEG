package apeg.syntax;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

public class TestSyntax {

	public static void main(String[] args) throws IOException, RecognitionException {
		String grammarFileName="../test/syntax/teste00.apeg";
		
		ANTLRFileStream input = new ANTLRFileStream(grammarFileName);
		APEGLexer lexer = new APEGLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		APEGParser parser = new APEGParser(tokens);
		parser.grammarDef();

		System.out.println("End");
	}

}
