package apeg.compiler.syntax;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import apeg.syntax.APEGLexer;
import apeg.syntax.APEGParser;

public class TestNonterminals {

	@Test
	public void and_cond() throws IOException, RecognitionException {
		APEGParser parser;
		Tree tree;
		
		// Test an unary and_cond (without an && operator)
		String t1 = "true";
		parser = createParser(t1);
		
		tree = parser.and_cond().getTree();
		assertEquals(tree.toStringTree(), "true");
		
		// Test an sequence of and expressions (verify precedence)
		String t2 = "!false && true && -(2 + 3) < 4 && !(true || false && true)";
		parser = createParser(t2);
		
		tree = parser.and_cond().getTree();
		assertEquals(tree.toStringTree(),
				"(&& (&& (&& (OP_NOT false) true) (< (- (+ 2 3)) 4)) (OP_NOT (|| true (&& false true))))");
	}
	
	@Test
	public void aexpr() throws IOException, RecognitionException {
		APEGParser parser;
		Tree tree;
		
		// Test an unary expression
		String t1 = "-1";
		parser = createParser(t1);
		
		tree = parser.aexpr().getTree();
		assertEquals(tree.toStringTree(), "(- 1)");
		
		// Test an one operand expression (not unary)
		String t2 = "1";
		parser = createParser(t2);
		
		tree = parser.aexpr().getTree();
		assertEquals(tree.toStringTree(), "1");
		
		// Test an sequence of add expression - verify precedence
		String t3 = "-(2 + 3) * 4 + 1 * 0 + 5 ";
		parser = createParser(t3);
		
		tree = parser.aexpr().getTree();
		assertEquals(tree.toStringTree(), "(+ (+ (- (* (+ 2 3) 4)) (* 1 0)) 5)");
	}
	
	@Test
	public void addOp() throws IOException, RecognitionException {
		APEGParser parser;
		Tree tree;
		
		// Test operator '+'
		String t1 = "+";
		parser = createParser(t1);
		
		tree = parser.addOp().getTree();
		assertEquals(tree.toStringTree(), "+");
		
		// Test operator '+'
		String t2 = "-";
		parser = createParser(t2);
				
		tree = parser.addOp().getTree();
		assertEquals(tree.toStringTree(), "-");
		
	}
	
	@Test
	public void actPars() throws IOException, RecognitionException {
		APEGParser parser;
		Tree tree;
		
		/**
		 * Test case 1
		 * Only one parameter
		 */
		String t1 = "1";
		parser = createParser(t1);
		
		tree = parser.actPars().getTree();
		assertEquals(tree.toStringTree(), "(LIST 1)");
		
		/**
		 * Test case 2
		 * More than one parameter
		 */
		String t2 = "1, 2, 3";
		parser = createParser(t2);
		
		tree = parser.actPars().getTree();
		assertEquals(tree.toStringTree(), "(LIST 1 2 3)");
		
		/**
		 * Test case 3
		 * No one parameter
		 */
		String t3 = ")"; // the second alternative is only choose if the LA is '>' or ')'.
		                 // Otherwise, it is a error. I looked at the generated code :p 
		parser = createParser(t3);
		
		tree = parser.actPars().getTree();
		assertEquals(tree.toStringTree(), "LIST");
	}
	
	/*@Test
	public void testRange() throws IOException, RecognitionException {
		String input = "a";
		APEGParser parser = createParser(input);
		
		Tree t = parser.single_pair().getTree();
		//Tree t = parser.range_pair().getTree();
		
		String tree = t.toStringTree();
		System.out.println(tree);
		
		assertEquals(tree, "^(DOUBLE_PAIR a z)");
		
	}*/
	
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
