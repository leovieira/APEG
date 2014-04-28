package apeg.compiler.runtime;

import java.util.HashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;

import apeg.compiler.runtime.interpreter.Environment;
import apeg.compiler.runtime.interpreter.Interpreter;
import apeg.compiler.syntax.tree.APEGTreeAdaptor;
import apeg.compiler.syntax.tree.Attribute;
import apeg.compiler.syntax.tree.NonTerminal;
import apeg.compiler.syntax.tree.Type;
import apeg.syntax.APEGLexer;
import apeg.syntax.APEGParser;
import apeg.compiler.adapt.AddRulesTree;

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
			if(!nonterminals[v].equals(nt)) { // if the nonterminals are different: the set of attributes are different
				// TODO emit an error
				throw new Error("It is not possible to change the set of nonterminal attributes");
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
				
				if(!n.equals(nt)) { // if the two nonterminal are not equals: the set of attributes are different
					// TODO emit an error
					throw new Error("It is not possible to change the set of nonterminal attributes");
				}
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

	/**
	 * Function to add a attribute to a given nonterminal
	 * 
	 * @param nt nonterminal that will insert the attribute
	 * @param name the name of the attribute
	 * @param type the type of the attribute
	 * @param category the category of the attribute
	 * @param num the relative position of the attribute inside its category. If
	 *             it has 3 attribute of locals category, then 0 <= num < 3
	 */
	protected void addAttribute(NonTerminal nt, String name, Type type,
			Attribute.Category category, int num) {
		nt.addAttribute(name, type, category, num);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Grammar resp = (Grammar) super.clone();

		// use the same tree adaptor
		resp.adaptor = this.adaptor;
		
		// copy the current position on the input
		resp.currentPos = this.currentPos;
		/**
		 * point to the same set of nonterminal, because it is the information
		 * from functions that has been generated and it will not change during
		 * the execution
		 */
		resp.nonterminals = this.nonterminals; // point to the same set of
												// nonterminals
		resp.ntIndex = this.ntIndex; // point to the same set of index

		/**
		 * Fields related to adaptability on runtime
		 */
		// Create a new set of possibles choice to every nonterminal, but
		// set to the same value
		resp.adapt = new CommonTree[this.adapt.length];
		for (int i = 0; i < resp.adapt.length; i++)
			resp.adapt[i] = this.adapt[i];

		// Create a new map of new nonterminal with the same values of the
		// old one
		// Only when adding a new rule we will change the Nonterminal value
		// (to save space)
		resp.nonMap = new HashMap<String, NonTerminal>(this.nonMap);

		return resp;
	}
}
