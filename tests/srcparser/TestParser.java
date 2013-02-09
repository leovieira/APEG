package srcparser;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

public class TestParser {

	public static void main(String[] args) throws IOException, RecognitionException {
		args = new String[2];
		args[0] = "teste01.txt";
		args[1] = "teste02.txt";
		
		int i = 0;
		String fileName;
		while(i < args.length) {
			fileName = args[i];
			ANTLRFileStream input = new ANTLRFileStream(fileName);
			AdaptablePEGLexer lexer = new AdaptablePEGLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			AdaptablePEGParser parser = new AdaptablePEGParser(tokens);
			
			parser.grammarDef();
		}

	}

}
