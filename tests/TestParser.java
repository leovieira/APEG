

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import srcparser.AdaptablePEGLexer;
import srcparser.AdaptablePEGParser;

public class TestParser {

	public static void main(String[] args) throws IOException, RecognitionException {
		args = new String[1];
//		args[0] = "input/teste01.txt";
		args[0] = "input/teste02.txt";
		
		int i = 0;
		String fileName;
		while(i < args.length) {
			fileName = args[i];
			System.out.println(fileName);
			ANTLRFileStream input = new ANTLRFileStream(fileName);
			AdaptablePEGLexer lexer = new AdaptablePEGLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			AdaptablePEGParser parser = new AdaptablePEGParser(tokens);
			
			parser.grammarDef();
			++i;
		}

	}

}
