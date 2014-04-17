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

	APEGParser parser;
	Tree tree;

	@Test
	public void varDecl() throws RecognitionException, IOException {
		// Test a variable declaration
		String t1 = "int x";
		parser = createParser(t1);

		tree = parser.varDecl().getTree();
		assertEquals(tree.toStringTree(), "(VARDECL int x)");
	}
	
	@Test
	public void type() throws IOException, RecognitionException {
		// A type is just a identifier
		
		// Test a basic type integer
		String t1 = "int";
		parser = createParser(t1);

		tree = parser.type().getTree();
		assertEquals(tree.toStringTree(), "int");
		
		// Test a basic type char
		String t2 = "char";
		parser = createParser(t2);

		tree = parser.type().getTree();
		assertEquals(tree.toStringTree(), "char");		
		
		// Test a basic type double
		String t3 = "double";
		parser = createParser(t3);

		tree = parser.type().getTree();
		assertEquals(tree.toStringTree(), "double");		
		
		// Test a basic type boolean
		String t4 = "boolean";
		parser = createParser(t4);

		tree = parser.type().getTree();
		assertEquals(tree.toStringTree(), "boolean");		
		
		// Test a basic type String
		String t5 = "String";
		parser = createParser(t5);

		tree = parser.type().getTree();
		assertEquals(tree.toStringTree(), "String");		
		
		// Test a Grammar type
		String t6 = "Grammar";
		parser = createParser(t6);

		tree = parser.type().getTree();
		assertEquals(tree.toStringTree(), "Grammar");		
		
		// Test any other type
		String t7 = "MyType";
		parser = createParser(t7);

		tree = parser.type().getTree();
		assertEquals(tree.toStringTree(), "MyType");		
	}
	
	@Test
	public void termOptUnary() throws IOException, RecognitionException {
		// Test a positive term
		String t1 = "x * y / 2 % 5 * z;"; // it must have a follow symbol
		parser = createParser(t1);

		tree = parser.termOptUnary().getTree();
		assertEquals(tree.toStringTree(), "(* (% (/ (* x y) 2) 5) z)");
		
		// Test a negative term
		String t2 = "-(1+2*3-4)";
		parser = createParser(t2);

		tree = parser.termOptUnary().getTree();
		assertEquals(tree.toStringTree(), "(- (- (+ 1 (* 2 3)) 4))");
	}
	
	@Test
	public void term() throws RecognitionException, IOException {
		// a term expression without star or division or mod operators
		String t1 = "(1+2*3-4)";
		parser = createParser(t1);

		tree = parser.term().getTree();
		assertEquals(tree.toStringTree(), "(- (+ 1 (* 2 3)) 4)");
		
		// Test precedence of mul operators
		String t2 = "x * y / 2 % 5 * z;"; // it must have a follow symbol
		parser = createParser(t2);

		tree = parser.term().getTree();
		assertEquals(tree.toStringTree(), "(* (% (/ (* x y) 2) 5) z)");
	}
	
	@Test
	public void single_pair() throws IOException, RecognitionException {
		// Test a LETTER
		String t1 = "a";
		parser = createParser(t1);

		tree = parser.single_pair().getTree();
		assertEquals(tree.toStringTree(), "a");
		
		// Test a digit
		String t2 = "5";
		parser = createParser(t2);

		tree = parser.single_pair().getTree();
		assertEquals(tree.toStringTree(), "5");
		
		// Test a escape
		String t3 = "\\uAaFf";
		parser = createParser(t3);

		tree = parser.single_pair().getTree();
		assertEquals(tree.toStringTree(), "\\uAaFf");

	}
	
	@Test
	public void rules() throws IOException, RecognitionException {
		// Test only one rule
		String t1 = "literal locals[int n] : number<n> '[' strN<n> ']' !.;";
		parser = createParser(t1);

		tree = parser.rules().getTree();
		assertEquals(tree.toStringTree(), "(RULE literal LIST LIST (LIST (VARDECL int n)) "
						+ "(SEQ (NONTERM number (LIST n)) '[' "
						+ "(NONTERM strN (LIST n)) ']' (NOT_LOOKAHEAD ANY)))");
		
		// Test more than one rule
		String t2 = "strN[int n] : ( {? n > 0 } CHAR { n = n - 1; } )* {? n == 0 } ;"
				+ "number returns[int x2] locals[int x1] : digit<x2> ( digit<x1> { x2 = x2 * 10 + x1; } )*;"
				+ "digit returns [int x] locals[String s]:  s=[0-9] { x = toInt(s); };"
				+ "CHAR : . ;";
		parser = createParser(t2);

		tree = parser.rules().getTree();
		assertEquals(tree.toStringTree(),
			"(RULE strN (LIST (VARDECL int n)) LIST LIST (SEQ (REPEAT (SEQ (COND (> n 0)) (NONTERM CHAR LIST) "
			+ "(ASSIGNLIST (ASSIGN n (- n 1))))) (COND (== n 0))))"	+ " "
			
			+ "(RULE number LIST (LIST (VARDECL int x2)) (LIST (VARDECL int x1)) (SEQ (NONTERM digit (LIST x2)) "
			+ "(REPEAT (SEQ (NONTERM digit (LIST x1)) (ASSIGNLIST (ASSIGN x2 (+ (* x2 10) x1)))))))" + " "
			
			+ "(RULE digit LIST (LIST (VARDECL int x)) (LIST (VARDECL String s)) (SEQ (CAPTURE_TEXT s "
			+ "(RANGE (DOUBLE_PAIR 0 9))) (ASSIGNLIST (ASSIGN x (CALL toInt (LIST s))))))" + " "
			
			+ "(RULE CHAR LIST LIST LIST ANY)");
		
	}
	
	@Test
	public void rule() throws IOException, RecognitionException {
		/**
		 * Rules with annotations
		 */
		// Test a rule with annotation and all parameters declaration
		String t1 = "@transient r1[Grammar g] returns[int i] locals[String s]: .;";
		parser = createParser(t1);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r1 TRANSIENT (LIST (VARDECL Grammar g)) (LIST (VARDECL int i)) "
						+ "(LIST (VARDECL String s)) ANY)");

		// Test a rule without a locals declaration section
		String t2 = "@memoize r2[Grammar g] returns[int i]: ;";
		parser = createParser(t2);

		tree = parser.rule().getTree();
		assertEquals(
				tree.toStringTree(),
				"(RULE r2 MEMOIZE (LIST (VARDECL Grammar g)) (LIST (VARDECL int i)) LIST LAMBDA)");

		// Test a rule without a returns declaration section
		String t3 = "@transient r3[Grammar g] locals[String s]: .*;";
		parser = createParser(t3);

		tree = parser.rule().getTree();
		assertEquals(
				tree.toStringTree(),
				"(RULE r3 TRANSIENT (LIST (VARDECL Grammar g)) LIST (LIST (VARDECL String s)) (REPEAT ANY))");

		// Test a rule without a inherited attributes declaration section
		String t4 = "@memoize r4 returns[int i] locals[String s]: .?;";
		parser = createParser(t4);

		tree = parser.rule().getTree();
		assertEquals(
				tree.toStringTree(),
				"(RULE r4 MEMOIZE LIST (LIST (VARDECL int i)) (LIST (VARDECL String s)) (OPTIONAL ANY))");

		// Test a rule with only the inherited attributes declaration section
		String t5 = "@transient r5[Grammar g]: .;";
		parser = createParser(t5);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r5 TRANSIENT (LIST (VARDECL Grammar g)) LIST LIST ANY)");

		// Test a rule with only the returns section
		String t6 = "@memoize r6 returns[int i] : ;";
		parser = createParser(t6);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r6 MEMOIZE LIST (LIST (VARDECL int i)) LIST LAMBDA)");

		// Test a rule with only the locals section
		String t7 = "@transient r7 locals[String s]: .;";
		parser = createParser(t7);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r7 TRANSIENT LIST LIST (LIST (VARDECL String s)) ANY)");

		// Test a rule without parameters declarations
		String t8 = "@memoize r8: ;";
		parser = createParser(t8);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r8 MEMOIZE LIST LIST LIST LAMBDA)");

		/**
		 * Rules without annotations
		 */
		// Test a rule with annotation and all parameters declaration
		String t9 = "r1[Grammar g] returns[int i] locals[String s]: .;";
		parser = createParser(t9);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r1 (LIST (VARDECL Grammar g)) (LIST (VARDECL int i)) "
						+ "(LIST (VARDECL String s)) ANY)");

		// Test a rule without a locals declaration section
		String t10 = "r2[Grammar g] returns[int i]: ;";
		parser = createParser(t10);

		tree = parser.rule().getTree();
		assertEquals(
				tree.toStringTree(),
				"(RULE r2 (LIST (VARDECL Grammar g)) (LIST (VARDECL int i)) LIST LAMBDA)");

		// Test a rule without a returns declaration section
		String t11 = "r3[Grammar g] locals[String s]: .*;";
		parser = createParser(t11);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r3 (LIST (VARDECL Grammar g)) LIST (LIST (VARDECL String s)) (REPEAT ANY))");

		// Test a rule without a inherited attributes declaration section
		String t12 = "r4 returns[int i] locals[String s]: .?;";
		parser = createParser(t12);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r4 LIST (LIST (VARDECL int i)) (LIST (VARDECL String s)) (OPTIONAL ANY))");

		// Test a rule with only the inherited attributes declaration section
		String t13 = "r5[Grammar g]: .;";
		parser = createParser(t13);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(), "(RULE r5 (LIST (VARDECL Grammar g)) LIST LIST ANY)");

		// Test a rule with only the returns section
		String t14 = "r6 returns[int i] : ;";
		parser = createParser(t14);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(),
				"(RULE r6 LIST (LIST (VARDECL int i)) LIST LAMBDA)");

		// Test a rule with only the locals section
		String t15 = "r7 locals[String s]: .;";
		parser = createParser(t15);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(), "(RULE r7 LIST LIST (LIST (VARDECL String s)) ANY)");

		// Test a rule without parameters declarations
		String t16 = "r8: ;";
		parser = createParser(t16);

		tree = parser.rule().getTree();
		assertEquals(tree.toStringTree(), "(RULE r8 LIST LIST LIST LAMBDA)");
	}

	@Test
	public void relOp() throws IOException, RecognitionException {
		// Test an equals operator
		String t1 = "==";
		parser = createParser(t1);

		tree = parser.relOp().getTree();
		assertEquals(tree.toStringTree(), "==");

		// Test a not equals operator
		String t2 = "!=";
		parser = createParser(t2);

		tree = parser.relOp().getTree();
		assertEquals(tree.toStringTree(), "!=");

		// Test a less than operator
		String t3 = "<";
		parser = createParser(t3);

		tree = parser.relOp().getTree();
		assertEquals(tree.toStringTree(), "<");

		// Test a great than operator
		String t4 = ">";
		parser = createParser(t4);

		tree = parser.relOp().getTree();
		assertEquals(tree.toStringTree(), ">");

		// Test a less than or equals operator
		String t5 = "<=";
		parser = createParser(t5);

		tree = parser.relOp().getTree();
		assertEquals(tree.toStringTree(), "<=");

		// Test a great than or equals operator
		String t6 = ">=";
		parser = createParser(t6);

		tree = parser.relOp().getTree();
		assertEquals(tree.toStringTree(), ">=");
	}

	@Test
	public void range_pair() throws RecognitionException, IOException {
		// Test a letter - letter pair
		String t1 = "a-z";
		parser = createParser(t1);

		tree = parser.range_pair().getTree();
		assertEquals(tree.toStringTree(), "(DOUBLE_PAIR a z)");

		// Test a digit - digit pair
		String t2 = "0-9";
		parser = createParser(t2);

		tree = parser.range_pair().getTree();
		assertEquals(tree.toStringTree(), "(DOUBLE_PAIR 0 9)");

		// Test a ESC - ESC pair
		String t3 = "\\u1234-\\u4567";
		parser = createParser(t3);

		tree = parser.range_pair().getTree();
		assertEquals(tree.toStringTree(), "(DOUBLE_PAIR \\u1234 \\u4567)");

		// Test a LETTER
		String t4 = "a]"; // it must have a follow symbol
		parser = createParser(t4);

		tree = parser.range_pair().getTree();
		assertEquals(tree.toStringTree(), "a");

		// Test a DIGIT
		String t5 = "7]"; // it must have a follow symbol
		parser = createParser(t5);

		tree = parser.range_pair().getTree();
		assertEquals(tree.toStringTree(), "7");

		// Test a ESC
		String t6 = "\\u89AB]"; // it must have a follow symbol
		parser = createParser(t6);

		tree = parser.range_pair().getTree();
		assertEquals(tree.toStringTree(), "\\u89AB");
	}

	@Test
	public void peg_unary_op() throws RecognitionException, IOException {
		// Test the optional operator
		String t1 = ".?";
		parser = createParser(t1);

		tree = parser.peg_unary_op().getTree();
		assertEquals(tree.toStringTree(), "(OPTIONAL ANY)");

		// Test the repeat operator
		String t2 = ".*";
		parser = createParser(t2);

		tree = parser.peg_unary_op().getTree();
		assertEquals(tree.toStringTree(), "(REPEAT ANY)");

		// Test the one_repeat operator
		String t3 = ".+";
		parser = createParser(t3);

		tree = parser.peg_unary_op().getTree();
		assertEquals(tree.toStringTree(), "(ONE_REPEAT ANY)");

		// Test the and operator
		String t4 = "&.";
		parser = createParser(t4);

		tree = parser.peg_unary_op().getTree();
		assertEquals(tree.toStringTree(), "(AND_LOOKAHEAD ANY)");

		// Test the not operator
		String t5 = "!.";
		parser = createParser(t5);

		tree = parser.peg_unary_op().getTree();
		assertEquals(tree.toStringTree(), "(NOT_LOOKAHEAD ANY)");

		// Test conditional peg expressions
		String t6 = "{? x < y}";
		parser = createParser(t6);

		tree = parser.peg_unary_op().getTree();
		assertEquals(tree.toStringTree(), "(COND (< x y))");

		// Test assignment peg expressions
		String t7 = "{x = 1; y = x * 2; z = x + y * y;}";
		parser = createParser(t7);

		tree = parser.peg_unary_op().getTree();
		assertEquals(tree.toStringTree(),
				"(ASSIGNLIST (ASSIGN x 1) (ASSIGN y (* x 2)) (ASSIGN z (+ x (* y y))))");
	}

	@Test
	public void peg_seq() throws RecognitionException, IOException {
		// Test the lambda peg expression
		String t1 = ";"; // it must have a follow symbol
		parser = createParser(t1);

		tree = parser.peg_seq().getTree();
		assertEquals(tree.toStringTree(), "LAMBDA");

		// Test a sequence of only one peg expression
		String t2 = "x = 'symbol';"; // it must have a follow symbol
		parser = createParser(t2);

		tree = parser.peg_seq().getTree();
		assertEquals(tree.toStringTree(), "(CAPTURE_TEXT x 'symbol')");

		// Test a sequence of more than one peg expressions
		String t3 = "x = 'symbol' . { x = 1;}"; // it must have a follow symbol
		parser = createParser(t3);

		tree = parser.peg_seq().getTree();
		assertEquals(tree.toStringTree(),
				"(SEQ (CAPTURE_TEXT x 'symbol') ANY (ASSIGNLIST (ASSIGN x 1)))");
	}

	@Test
	public void peg_factor() throws IOException, RecognitionException {
		// Test a string peg expression
		String t1 = "'APEG'";
		parser = createParser(t1);

		tree = parser.peg_factor().getTree();
		assertEquals(tree.toStringTree(), "'APEG'");

		// Test a nonterminal call as a peg expression
		String t2 = "digit<x1>";
		parser = createParser(t2);

		tree = parser.peg_factor().getTree();
		assertEquals(tree.toStringTree(), "(NONTERM digit (LIST x1))");

		// Test a ANY peg expression
		String t3 = ".";
		parser = createParser(t3);

		tree = parser.peg_factor().getTree();
		assertEquals(tree.toStringTree(), "ANY");

		// Test a parenthesis peg expression
		String t4 = "({? false } / .)";
		parser = createParser(t4);

		tree = parser.peg_factor().getTree();
		assertEquals(tree.toStringTree(), "(CHOICE (COND false) ANY)");

		// Test a range peg expression
		String t5 = "[a-zA-Z0-9]";
		parser = createParser(t5);

		tree = parser.peg_factor().getTree();
		assertEquals(tree.toStringTree(), "(RANGE (DOUBLE_PAIR a zA Z0 9))");
		// must check and split it during analysis phase
	}

	@Test
	public void peg_expr() throws RecognitionException, IOException {
		// Test a sequence peg expression (no external choice operator)
		String t1 = ".;"; // it must have a follow symbol
		parser = createParser(t1);

		tree = parser.peg_expr().getTree();
		assertEquals(tree.toStringTree(), "ANY");

		// Test a choice peg expression (verify precedence)
		String t2 = "'0' { x = 0;} / '1' { x = 1;} / x = .;"; // it must have a
																// follow symbol
		parser = createParser(t2);

		tree = parser.peg_expr().getTree();
		assertEquals(
				tree.toStringTree(),
				"(CHOICE (SEQ '0' (ASSIGNLIST (ASSIGN x 0))) "
						+ "(CHOICE (SEQ '1' (ASSIGNLIST (ASSIGN x 1))) (CAPTURE_TEXT x ANY)))");
	}

	@Test
	public void peg_capturetext() throws RecognitionException, IOException {
		// Test a peg expression which does not capture text
		String t1 = ".;"; // it must have a follow symbol
		parser = createParser(t1);

		tree = parser.peg_capturetext().getTree();
		assertEquals(tree.toStringTree(), "ANY");

		// Test a peg capture text expression
		String t2 = "s = .;"; // it must have a follow symbol
		parser = createParser(t2);

		tree = parser.peg_capturetext().getTree();
		assertEquals(tree.toStringTree(), "(CAPTURE_TEXT s ANY)");
	}

	@Test
	public void optReturn() throws RecognitionException, IOException {
		// Test an empty locals declaration
		String t1 = "locals"; // it must have a follow symbol
		parser = createParser(t1);

		tree = parser.optReturn().getTree();
		assertEquals(tree.toStringTree(), "LIST");

		// Test a return declaration section
		String t2 = "returns [Grammar g, int i, String s]";
		parser = createParser(t2);

		tree = parser.optReturn().getTree();
		assertEquals(tree.toStringTree(),
				"(LIST (VARDECL Grammar g) (VARDECL int i) (VARDECL String s))");
	}

	@Test
	public void optLocals() throws RecognitionException, IOException {
		// Test an empty locals declaration
		String t1 = ":"; // it must have a follow
		parser = createParser(t1);

		tree = parser.optLocals().getTree();
		assertEquals(tree.toStringTree(), "LIST");

		// Test a local declaration section
		String t2 = "locals [Grammar g, int i, String s]";
		parser = createParser(t2);

		tree = parser.optLocals().getTree();
		assertEquals(tree.toStringTree(),
				"(LIST (VARDECL Grammar g) (VARDECL int i) (VARDECL String s))");
	}

	@Test
	public void option() throws IOException, RecognitionException {
		// Test an empty option section
		String t1 = "functions"; // it must have a follow
		parser = createParser(t1);

		tree = parser.option().getTree();
		assertEquals(tree.toStringTree(), "LIST");

		// Test the option section
		String t2 = "options {isAdaptable = true; envSemantics = simple; memoize = true;}";
		parser = createParser(t2);

		tree = parser.option().getTree();
		assertEquals(tree.toStringTree(),
				"(LIST ADAPTABLE NOT_ENV_DISCARDING MEMOIZATION)");
	}

	@Test
	public void optDecls() throws RecognitionException, IOException {
		// Test an empty list of inherited attributes declaration
		String t1 = "returns"; // it must have a follow
		parser = createParser(t1);

		tree = parser.optDecls().getTree();
		assertEquals(tree.toStringTree(), "LIST");

		// Test a nonempty list of inherited attributes declaration
		String t2 = "[Grammar g, int i, String s]";
		parser = createParser(t2);

		tree = parser.optDecls().getTree();
		assertEquals(tree.toStringTree(),
				"(LIST (VARDECL Grammar g) (VARDECL int i) (VARDECL String s))");
	}

	@Test
	public void number() throws IOException, RecognitionException {
		// Test an integer number
		String t1 = "1234567890";
		parser = createParser(t1);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), "1234567890");

		// Test a real number - It has the integer and decimal part and also a
		// positive exponent
		String t2 = "1.01e+2";
		parser = createParser(t2);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), "1.01e+2");

		// Test a real number - It has the integer and decimal part and also a
		// negative exponent
		String t3 = "2.12E-3";
		parser = createParser(t3);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), "2.12E-3");

		// Test a real number - It has only the integer and exponent parts
		String t4 = "3E4";
		parser = createParser(t4);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), "3E4");

		// Test a real number - It has only the integer and exponent (negative)
		// parts
		String t5 = "4.e-5";
		parser = createParser(t5);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), "4.e-5");

		// Test a real number - It only does not have the exponent
		String t6 = "5.6789";
		parser = createParser(t6);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), "5.6789");

		// Test a real number - It only does not have the exponent
		String t7 = "67.";
		parser = createParser(t7);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), "67.");

		// Test a real number - It does not have the integer part
		String t8 = ".99e-10";
		parser = createParser(t8);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), ".99e-10");

		// Test a real number - It does not have the integer part
		String t9 = ".999999";
		parser = createParser(t9);

		tree = parser.number().getTree();
		assertEquals(tree.toStringTree(), ".999999");
	}

	@Test
	public void ntcall() throws RecognitionException, IOException {
		// Test a nonterminal call without attributes
		String t1 = "nt;"; // it must have a follow symbol
		parser = createParser(t1);

		tree = parser.ntcall().getTree();
		assertEquals(tree.toStringTree(), "(NONTERM nt LIST)");

		// Test a nonterminal call without attributes, but using a angular
		// parenthesis
		String t2 = "nt<>";
		parser = createParser(t2);

		tree = parser.ntcall().getTree();
		assertEquals(tree.toStringTree(), "(NONTERM nt LIST)");

		// Test a nonterminal call with attributes
		String t3 = "nt<1+2, a, !(x < y || z ==2)>";
		parser = createParser(t3);

		tree = parser.ntcall().getTree();
		assertEquals(tree.toStringTree(),
				"(NONTERM nt (LIST (+ 1 2) a (OP_NOT (|| (< x y) (== z 2)))))");
	}

	@Test
	public void mulOp() throws RecognitionException, IOException {
		// Test a star operator
		String t1 = "*";
		parser = createParser(t1);

		tree = parser.mulOp().getTree();
		assertEquals(tree.toStringTree(), "*");

		// Test a division operator
		String t2 = "/";
		parser = createParser(t2);

		tree = parser.mulOp().getTree();
		assertEquals(tree.toStringTree(), "/");

		// Test a mod operator
		String t3 = "%";
		parser = createParser(t3);

		tree = parser.mulOp().getTree();
		assertEquals(tree.toStringTree(), "%");
	}

	@Test
	public void idAssign() throws IOException, RecognitionException {
		// It is just a identifier name
		String t1 = "id";
		parser = createParser(t1);

		tree = parser.idAssign().getTree();
		assertEquals(tree.toStringTree(), "id");
	}

	@Test
	public void grammarDef() throws RecognitionException, IOException {
		// Test a grammar definition with an option and with a function
		// declarations sections
		String t1 = "apeg g;"
				+ "options {isAdaptable = true; envSemantics = simple; memoize = true;}"
				+ "functions AdaptableFunctions;" + "rule: .;";
		parser = createParser(t1);

		tree = parser.grammarDef().getTree();
		assertEquals(
				tree.toStringTree(),
				"(GRAMMAR g (LIST ADAPTABLE NOT_ENV_DISCARDING MEMOIZATION) "
						+ "(FILES AdaptableFunctions) (RULE rule LIST LIST LIST ANY))");

		// Test a grammar without the options section
		String t2 = "apeg g;" + "functions AdaptableFunctions;" + "rule: .;";
		parser = createParser(t2);

		tree = parser.grammarDef().getTree();
		assertEquals(tree.toStringTree(), "(GRAMMAR g LIST "
				+ "(FILES AdaptableFunctions) (RULE rule LIST LIST LIST ANY))");

		// Test a grammar without the function sections
		String t3 = "apeg g;"
				+ "options {isAdaptable = true; envSemantics = simple; memoize = true;}"
				+ "rule: .;";
		parser = createParser(t3);

		tree = parser.grammarDef().getTree();
		assertEquals(tree.toStringTree(),
				"(GRAMMAR g (LIST ADAPTABLE NOT_ENV_DISCARDING MEMOIZATION) "
						+ "FILES (RULE rule LIST LIST LIST ANY))");

		// Test a grammar without the option and function sections
		String t4 = "apeg g; rule01: .; rule02: .;";
		parser = createParser(t4);

		tree = parser.grammarDef().getTree();
		assertEquals(
				tree.toStringTree(),
				"(GRAMMAR g LIST "
						+ "FILES (RULE rule01 LIST LIST LIST ANY) (RULE rule02 LIST LIST LIST ANY))");
	}

	@Test
	public void grammar_opt() throws IOException, RecognitionException {
		// Test the grammar option isAdaptable set as true
		String t1 = "isAdaptable = true";
		parser = createParser(t1);

		tree = parser.grammar_opt().getTree();
		assertEquals(tree.toStringTree(), "ADAPTABLE");

		// Test the grammar option isAdaptable set as false
		String t2 = "isAdaptable = false";
		parser = createParser(t2);

		tree = parser.grammar_opt().getTree();
		assertEquals(tree.toStringTree(), "NOT_ADAPTABLE");

		// Test the grammar option envSemantics set as simple
		String t3 = "envSemantics = simple";
		parser = createParser(t3);

		tree = parser.grammar_opt().getTree();
		assertEquals(tree.toStringTree(), "NOT_ENV_DISCARDING");

		// Test the grammar option envSemantics set as simple
		String t4 = "envSemantics = discardChangesWhenFail";
		parser = createParser(t4);

		tree = parser.grammar_opt().getTree();
		assertEquals(tree.toStringTree(), "ENV_DISCARDING");

		// Test the grammar option memoize set as true
		String t5 = "memoize = true";
		parser = createParser(t5);

		tree = parser.grammar_opt().getTree();
		assertEquals(tree.toStringTree(), "MEMOIZATION");

		// Test the grammar option memoize set as false
		String t6 = "memoize = false";
		parser = createParser(t6);

		tree = parser.grammar_opt().getTree();
		assertEquals(tree.toStringTree(), "NOT_MEMOIZATION");
	}

	@Test
	public void functions() throws RecognitionException, IOException {
		// Test a list of functions declarations
		String t1 = "functions AdaptableFunctions FortressFunctions OtherFunctions;";
		parser = createParser(t1);

		tree = parser.functions().getTree();
		assertEquals(tree.toStringTree(),
				"(FILES AdaptableFunctions FortressFunctions OtherFunctions)");

		// Test a list of non function declarations
		String t2 = "rule"; // It must have a follow. Here I put only a possible
							// name of a rule
		parser = createParser(t2);

		tree = parser.functions().getTree();
		assertEquals(tree.toStringTree(), "FILES");
	}

	@Test
	public void factor() throws RecognitionException, IOException {
		// Test an attribute name
		String t1 = "x>"; // It must have a follow
		parser = createParser(t1);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "x");

		// Test a grammar reference
		String t2 = "$g";
		parser = createParser(t2);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "GRAMMAR_REF");

		// Test a function call
		String t3 = "func()";
		parser = createParser(t3);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "(CALL func LIST)");

		// Test a real number
		String t4 = "1.001";
		parser = createParser(t4);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "1.001");

		// Test a integer number
		String t5 = "100000";
		parser = createParser(t5);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "100000");

		// Test a string literal
		String t6 = "'string literal'";
		parser = createParser(t6);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "'string literal'");

		// Test an expression between parenthesis
		String t7 = "(1 + 2 * 3 + 4)";
		parser = createParser(t7);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "(+ (+ 1 (* 2 3)) 4)");

		// Test a not conditional
		String t8 = "!(x == y)";
		parser = createParser(t8);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "(OP_NOT (== x y))");

		// Test a true expression
		String t9 = "true";
		parser = createParser(t9);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "true");

		// Test a false expression
		String t10 = "false";
		parser = createParser(t10);

		tree = parser.factor().getTree();
		assertEquals(tree.toStringTree(), "false");
	}

	@Test
	public void expr() throws IOException, RecognitionException {
		// Test an expression - An expression is a conditional expression. So,
		// there is no much to do
		String t1 = "(x < y || z == 2) && w > 10";
		parser = createParser(t1);

		tree = parser.expr().getTree();
		assertEquals(tree.toStringTree(), "(&& (|| (< x y) (== z 2)) (> w 10))");
	}

	@Test
	public void designator() throws RecognitionException, IOException {
		// Currently, I am not using a designator.
		// Also, It is not allowing a function call as part of it, for the
		// moment

		// Just a ID name
		String t1 = "id";
		parser = createParser(t1);

		tree = parser.designator().getTree();
		assertEquals(tree.toStringTree(), "id");

		// Array reference
		String t2 = "array[func(true) * 2 + 1]";
		parser = createParser(t2);

		tree = parser.designator().getTree();
		assertEquals(tree.toStringTree(),
				"(ARRAY_REF array (+ (* (CALL func (LIST true)) 2) 1))");

		// designator
		String t3 = "x[i].z.y[j]";
		parser = createParser(t3);

		tree = parser.designator().getTree();
		assertEquals(tree.toStringTree(),
				"(ARRAY_REF (DOT (DOT (ARRAY_REF x i) z) y) j)");
	}

	@Test
	public void decls() throws IOException, RecognitionException {
		// Only one attribute declaration
		String t1 = "[Grammar g]";
		parser = createParser(t1);

		tree = parser.decls().getTree();
		assertEquals(tree.toStringTree(), "(LIST (VARDECL Grammar g))");

		// More than one attribute declarations
		String t2 = "[ int i, boolean b, double d, Grammar g ]";
		parser = createParser(t2);

		tree = parser.decls().getTree();
		assertEquals(
				tree.toStringTree(),
				"(LIST (VARDECL int i) (VARDECL boolean b) (VARDECL double d) (VARDECL Grammar g))");
	}

	@Test
	public void cond_expr() throws IOException, RecognitionException {
		// Test an unary cond_expr (without an || operator)
		String t1 = "x >= y && !(false || func())";
		parser = createParser(t1);

		tree = parser.condExpr().getTree();
		assertEquals(tree.toStringTree(),
				"(&& (>= x y) (OP_NOT (|| false (CALL func LIST))))");

		// Test an sequence of OR expressions (verify precedence)
		String t2 = "x <= y || true && !func() || z == 2";
		parser = createParser(t2);

		tree = parser.condExpr().getTree();
		assertEquals(tree.toStringTree(),
				"(|| (|| (<= x y) (&& true (OP_NOT (CALL func LIST)))) (== z 2))");
	}

	@Test
	public void bool_expr() throws RecognitionException, IOException {
		// Test a boolean expression without relation operators
		String t1 = "!( x < y && func(z + 1))";
		parser = createParser(t1);

		tree = parser.bool_expr().getTree();
		assertEquals(tree.toStringTree(),
				"(OP_NOT (&& (< x y) (CALL func (LIST (+ z 1)))))");

		// Test a boolean expression with relation operators
		String t2 = "!( x < y && func(z + 1)) == false";
		parser = createParser(t2);

		tree = parser.bool_expr().getTree();
		assertEquals(tree.toStringTree(),
				"(== (OP_NOT (&& (< x y) (CALL func (LIST (+ z 1))))) false)");
	}

	@Test
	public void attrORfunccall() throws IOException, RecognitionException {
		// Test of a attribute name
		String t1 = "x>"; // it must have a follow. In that case, the and of a
							// nonterminal call
		parser = createParser(t1);

		tree = parser.attrORfuncall().getTree();
		assertEquals(tree.toStringTree(), "x");

		// Test of a function call - case more than one parameters
		String t2 = "func(true, 0, x+2)";
		parser = createParser(t2);

		tree = parser.attrORfuncall().getTree();
		assertEquals(tree.toStringTree(), "(CALL func (LIST true 0 (+ x 2)))");

		// Test of a function call - only one parameter
		String t3 = "func(x+2)";
		parser = createParser(t3);

		tree = parser.attrORfuncall().getTree();
		assertEquals(tree.toStringTree(), "(CALL func (LIST (+ x 2)))");

		// Test of a function call - no parameters
		String t4 = "func()";
		parser = createParser(t4);

		tree = parser.attrORfuncall().getTree();
		assertEquals(tree.toStringTree(), "(CALL func LIST)");

		// Test of a grammar reference
		String t5 = "$g";
		parser = createParser(t5);

		tree = parser.attrORfuncall().getTree();
		assertEquals(tree.toStringTree(), "GRAMMAR_REF");
	}

	@Test
	public void assign() throws IOException, RecognitionException {
		// Test an assignment of a condition expression
		String t1 = "x = y < z;";
		parser = createParser(t1);

		tree = parser.assign().getTree();
		assertEquals(tree.toStringTree(), "(ASSIGN x (< y z))");

		// Test an assignment of a arithmetic expression
		String t2 = "x = 1 + 2 * 3 - 4;";
		parser = createParser(t2);

		tree = parser.assign().getTree();
		assertEquals(tree.toStringTree(), "(ASSIGN x (- (+ 1 (* 2 3)) 4))");
	}

	@Test
	public void annotation() throws IOException, RecognitionException {
		// Test a memoize annotation
		String t1 = "@memoize";
		parser = createParser(t1);

		tree = parser.annotation().getTree();
		assertEquals(tree.toStringTree(), "MEMOIZE");

		// Test a memoize annotation
		String t2 = "@transient";
		parser = createParser(t2);

		tree = parser.annotation().getTree();
		assertEquals(tree.toStringTree(), "TRANSIENT");
	}

	@Test
	public void and_cond() throws IOException, RecognitionException {
		// Test an unary and_cond (without an && operator)
		String t1 = "true";
		parser = createParser(t1);

		tree = parser.and_cond().getTree();
		assertEquals(tree.toStringTree(), "true");

		// Test an sequence of and expressions (verify precedence)
		String t2 = "!false && true && -(2 + 3) < 4 && !(true || false && true)";
		parser = createParser(t2);

		tree = parser.and_cond().getTree();
		assertEquals(
				tree.toStringTree(),
				"(&& (&& (&& (OP_NOT false) true) (< (- (+ 2 3)) 4)) (OP_NOT (|| true (&& false true))))");
	}

	@Test
	public void aexpr() throws IOException, RecognitionException {
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
		/**
		 * Test case 1 Only one parameter
		 */
		String t1 = "1";
		parser = createParser(t1);

		tree = parser.actPars().getTree();
		assertEquals(tree.toStringTree(), "(LIST 1)");

		/**
		 * Test case 2 More than one parameter
		 */
		String t2 = "1, 2, 3";
		parser = createParser(t2);

		tree = parser.actPars().getTree();
		assertEquals(tree.toStringTree(), "(LIST 1 2 3)");

		/**
		 * Test case 3 No one parameter
		 */
		String t3 = ")"; // the second alternative is only choose if the LA is
							// '>' or ')'.
							// Otherwise, it is a error. I looked at the
							// generated code :p
		parser = createParser(t3);

		tree = parser.actPars().getTree();
		assertEquals(tree.toStringTree(), "LIST");
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
