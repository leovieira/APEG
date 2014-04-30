package apeg.compiler.runtime;

import java.util.HashMap;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import apeg.compiler.adapt.AddRulesTree;

import apeg.compiler.runtime.interpreter.Environment;
import apeg.compiler.runtime.interpreter.Interpreter;

import apeg.compiler.syntax.tree.APEGTreeAdaptor;
import apeg.compiler.syntax.tree.NonTerminal;

import apeg.syntax.APEGLexer;
import apeg.syntax.APEGParser;

public abstract class Grammar implements Cloneable {

	// represent a fail result
	protected static final Result fail_result = new Result(-1, null);

	protected APEGInputStream input; // the input stream
	protected int currentPos = 0; // current position on the input

	protected APEGTreeAdaptor adaptor;
	
	/**
	 * Information of nonterminals
	 */
	protected NonTerminal[] nonterminals; // information of all predefined nonterminals
	// map to get the position of a nonterminal on the vector nonterminals
	protected HashMap<String, Integer> ntIndex = new HashMap<String, Integer>();

	/**
	 * Fields related to adaptability on runtime
	 */
	protected CommonTree[] adapt; // vector of possible new choices of any predefined nonterminal

	protected HashMap<String, NonTerminal> nonMap; // map of new nonterminals (added during adaptability)

	/**
	 * Grammar constructor
	 * @param input stream of character
	 */
	protected Grammar(APEGInputStream input) {
		this.input = input;
		nonMap = new HashMap<String, NonTerminal>();
		
		adaptor = new APEGTreeAdaptor();
	}

	/**
	 * Function that match a string on the input starting from a specific position
	 * @param string
	 * @param pos
	 * @return the next position if the match succeed or failure position
	 * @throws Exception
	 */
	public int match(String string, int pos) throws Exception {
		return input.match(string, pos);
	}

	/**
	 * Function to read a character from a specific position
	 * @param pos
	 * @return the character read
	 * @throws Exception
	 */
	public char read(int pos) throws Exception {
		return input.read(pos);
	}

	/**
	 * Function to return a result which represents a failure
	 * @return
	 */
	public Result failResult() {
		return fail_result;
	}

	/**
	 * Function to interpreter a new choice
	 * @param pos
	 * @param env
	 * @return
	 * @throws Exception
	 */
	protected Result interpreteChoice(int pos, Environment env)
			throws Exception {
		if (adapt[pos] != null) { // there is a new alternative
			Interpreter interpreter = new Interpreter(this);
			return interpreter.execute(pos, adapt[pos], env, currentPos);
		} // else

		return fail_result;
	}

	/**
	 * Funtion to copy the grammar
	 * @return
	 */
	public Grammar copy() {
		try {
			return (Grammar) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// TODO
	public Grammar addRule(String rule) throws Exception {
		ANTLRStringStream input = new ANTLRStringStream(rule);
		APEGLexer lexer = new APEGLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		APEGParser parser = new APEGParser(tokens);

		System.out.println("Trying to add rules: " + rule);

		APEGParser.rules_return result = parser.rules();
		Tree t = (Tree) result.getTree();

		// check for errors
		if(parser.getNumberOfSyntaxErrors() > 0) {
			//TODO - do better
			throw new Error("Error when trying to add rules");
		}
		
		// Check the AST, set the pointers and adapt the grammar
		CommonTreeNodeStream node = new CommonTreeNodeStream(t);
		node.setTokenStream(tokens);
		AddRulesTree walker = new AddRulesTree(node);
		walker.enableErrorMessageCollection(true);
		walker.rules(this);
		
		// check for errors
		if(walker.hasErrors()) {
			//TODO - do better
			walker.printErrorMessages();
			throw new Error("Error when trying to add rules");
		}

		return this;
	}

	public void addChoice(NonTerminal nt, CommonTree choice) {
		Integer index = ntIndex.get(nt.getName());
		if(index != null) { // it is a predefined nonterminal
			int v = index.intValue();
			
			if(adapt[v] == null)
				adapt[v] = choice;
			else {
				CommonTree root = (CommonTree) adaptor.create(APEGLexer.CHOICE, "CHOICE");
				root.addChild(adapt[v]); // the left child is the old expression
				root.addChild(choice); // the right child is the new choice
				
				adapt[v] = root;
			}
		} else { // it is not a predefined nonterminal
			NonTerminal n = nonMap.get(nt.getName());
			if(n == null) { // it is a new nonterminal
				nt.setPegExpr(choice); // Assure that nt has the correct choice
				nonMap.put(nt.getName(), nt); //  put it in the map of nonterminals
			} else { // it already has the nonterminal
				CommonTree root = (CommonTree) adaptor.create(APEGLexer.CHOICE, "CHOICE");
				root.addChild(n.getPegExpr());
				root.addChild(choice);
				
				n.setPegExpr(root);
			}
		}
	}
	
	public int getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(int pos) {
		currentPos = pos;
	}

	/**
	 * Return the predefined nonterminal of a given position
	 * @param pos
	 * @return
	 */
	public NonTerminal getNonterminal(int pos) {
		if (pos >= nonterminals.length || pos < 0)
			return null;
		return nonterminals[pos];
	}
	
	/**
	 * Return a nonterminal with the this name.
	 *  Can be a predefined one or a new one, added during adaptability 
	 * @param name
	 * @return
	 */
	public NonTerminal getNonterminal(String name) {
		Integer i = ntIndex.get(name);
		if(i != null) {
			int index = i;
			return nonterminals[index]; // return a predefined nonterminal
		} else
			return nonMap.get(name); // return a nonterminal defined during runtime
		                             // maybe a null value if it was not defined yet
	}

	/**
	 * Return a nonterminal which was added during adaptability
	 * @param name
	 * @return
	 */
	public NonTerminal getNewNonterminal(String name) {
		return nonMap.get(name);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Grammar resp = (Grammar) super.clone();

		// use the same tree adaptor
		resp.adaptor = this.adaptor;
		
		// copy the current position on the input
		resp.currentPos = this.currentPos;
		
		/**
		 * It is possible to change the list of locals attributes.
		 * So, we duplicate the list of nonterminals information
		 * point to the same set of nonterminal
		 */
		resp.nonterminals = new NonTerminal[this.nonterminals.length];
		for(int i = 0; i < resp.nonterminals.length; ++i) {
			resp.nonterminals[i] = this.nonterminals[i].copy();
		}
		
		/**
		 * Point to the same set of index, because it will not change during runtime
		 *  * even when adapt
		 */
		resp.ntIndex = this.ntIndex; // point to the same set of index

		/**
		 * Fields related to adaptability on runtime
		 */
		// Create a new set of possibles choice to every nonterminal, but
		// set to the same value
		resp.adapt = new CommonTree[this.adapt.length];
		for (int i = 0; i < resp.adapt.length; i++)
			resp.adapt[i] = this.adapt[i];

		/**
		 * The list of new nonterminals can have the local attributes changed
		 *  * or its parsing expression. So, we duplicate it
		 */
		Set<String> key = this.nonMap.keySet();
		resp.nonMap = new HashMap<String, NonTerminal>();
		for(String s : key) {
			resp.nonMap.put(s, (this.nonMap.get(s)).copy());
		}
		return resp;
	}
}
