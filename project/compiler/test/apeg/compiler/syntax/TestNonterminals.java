package apeg.compiler.syntax;

import static org.junit.Assert.*;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import apeg.syntax.APEGLexer;
import apeg.syntax.APEGParser;

public class TestNonterminals {

	@Test
	public void testRange() throws IOException, RecognitionException {
		String input = "a";
		APEGParser parser = createParser(input);
		
		Tree t = parser.single_pair().getTree();
		//Tree t = parser.range_pair().getTree();
		
		String tree = t.toStringTree();
		System.out.println(tree);
		
		assertEquals(tree, "^(DOUBLE_PAIR a z)");
		
	}
	
	public APEGParser createParser(String text) throws IOException {
		/**
		 * Parsing and building the AST
		 */
		// Create an input stream from a file
		ANTLRStringStream input = new ANTLRStringStream(text);
		// Create a lexer attached to that input stream
		APEGLexer lexer = new APEGLexer(input);
		// Create a stream of tokens pilled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Create a parser attached to the token stream
		APEGParser parser = new APEGParser(tokens);
		// Return the parser
		return parser;
	}
}
