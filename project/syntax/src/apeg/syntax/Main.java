package apeg.syntax;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import apeg.common.path.Path;

public class Main {

	public static void parse(Path path) throws RecognitionException,
			IOException {
		/**
		 * Parsing and building the AST
		 */
		// Create an input stream from a file
		ANTLRFileStream input = new ANTLRFileStream(path.getAbsolutePath());
		// Create a lexer attached to that input stream
		APEGLexer lexer = new APEGLexer(input);
		// Create a stream of tokens pilled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Create a parser attached to the token stream
		APEGParser parser = new APEGParser(tokens);
		// Invoke the parser from the started nonterminal and get the returned value
		APEGParser.grammarDef_return r = parser.grammarDef();
		Tree t = r.getTree();

		/**
		 * Walking and analyzing the AST
		 */
		// Create a treenode stream
		CommonTreeNodeStream node = new CommonTreeNodeStream(t);
		// AST nodes have payloads that point into token stream
		node.setTokenStream(tokens);
		
		// Create a tree Walker attached to the nodes stream
		APEGTree walker = new APEGTree(node);
		// Invoke the Walker start symbol (do nothing)
		walker.grammarDef();

	}
}
