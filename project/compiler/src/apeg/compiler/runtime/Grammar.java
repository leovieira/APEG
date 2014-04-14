package apeg.compiler.runtime;

import java.util.HashMap;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

import apeg.compiler.runtime.interpreter.Environment;
import apeg.compiler.runtime.interpreter.Interpreter;
import apeg.compiler.syntax.tree.APEGTreeAdaptor;
import apeg.compiler.syntax.tree.Attribute;
import apeg.compiler.syntax.tree.NonTerminal;
import apeg.compiler.syntax.tree.Type;

import apeg.syntax.APEG_OldLexer;
import apeg.syntax.APEG_OldParser;

public abstract class Grammar implements Cloneable {

	protected static final Result fail_result = new Result(-1, null); // represent
																		// a
																		// fail
																		// result

	protected APEGInputStream input; // the input stream
	protected int currentPos = 0; // Current position on the input

	/**
	 * Information of nonterminals
	 */
	protected NonTerminal[] nonterminals;
	protected HashMap<String, Integer> ntIndex = new HashMap<String, Integer>();

	/**
	 * Fields related to adaptability on runtime
	 */
	protected CommonTree[] adapt; // vector of possible new choices of any
									// nonterminal
	protected Interpreter interpreter; // the interpreter for new rules or
										// choices

	protected HashMap<String, NonTerminal> nonMap; // map of new nonterminals

	protected Grammar(APEGInputStream input) {
		this.input = input;
		interpreter = new Interpreter(this);
		nonMap = new HashMap<String, NonTerminal>();
	}

	public int match(String string, int pos) throws Exception {
		return input.match(string, pos);
	}

	public char read(int pos) throws Exception {
		return input.read(pos);
	}

	public Result failResult() {
		return fail_result;
	}

	protected Result interpreteChoice(int pos, Environment env)
			throws Exception {
		if (adapt[pos] != null) { // there is a new alternative
			return interpreter.execute(pos, adapt[pos], env, currentPos);
		} // else

		return fail_result;
	}

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
		APEG_OldLexer lexer = new APEG_OldLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		APEG_OldParser parser = new APEG_OldParser(tokens);
		APEGTreeAdaptor adaptor = new APEGTreeAdaptor();
		parser.setTreeAdaptor(adaptor);

		System.out.println("Trying to add rules: " + rule);

		APEG_OldParser.addrules_return result = parser.addrules();
		Tree t = (Tree) result.getTree();

		// TODO check for errors

		Tree ntName, param, rets, locals, pegExpr;
		if (APEG_OldLexer.RULE == t.getType()) { // there is only one rule
			// Create a new tree if just one rule. Only to avoid duplicate code
			Tree aux = new CommonTree();
			aux.addChild(t);
			t = aux;
		}
		// Now, this code should work even when have only one rule
		for (int i = 0; i < t.getChildCount(); ++i) { // to each rule
			Tree child = t.getChild(i); // it must be a RULE child type
			ntName = child.getChild(0); // the nonterminal name
			param = child.getChild(1); // list of parameters
			rets = child.getChild(2); // list of returns
			locals = t.getChild(3); // list of locals
			pegExpr = child.getChild(4); // peg expression of the nonterminal

			//TODO - não verifiquei se os parametros estão todos corretos!
			
			Integer index = ntIndex.get(ntName.toString());
			if(index != null) { // it is an generated nonterminal
				int v = index.intValue();
				if(nonterminals[v] == null) {
					adapt[v] = (CommonTree) pegExpr;
				} else {
					CommonTree root = (CommonTree) adaptor.create(APEG_OldLexer.CHOICE, "CHOICE");
					root.addChild(adapt[v]);
					root.addChild(pegExpr);
					
					adapt[v] = (CommonTree) pegExpr;
				}
			} else { // it does have a function code generate
				NonTerminal nt = nonMap.get(ntName.toString());
				if(nt == null) { // it is a new nonterminal
					//TODO - I must to put the new nonterminal in the map nonMap
				} else { // it already has the nonterminal
					CommonTree root = (CommonTree) adaptor.create(APEG_OldLexer.CHOICE, "CHOICE");
					root.addChild(nt.getPegExpr());
					root.addChild(pegExpr);
					
					nt.setPegExpr(root);
				}
			}
		}
		return this;
	}

	public int getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(int pos) {
		currentPos = pos;
	}

	public NonTerminal getNonterminal(int pos) {
		if (pos >= nonterminals.length || pos < 0)
			return null;
		return nonterminals[pos];
	}

	public NonTerminal getNewNonterminal(String name) {
		return nonMap.get(name);
	}

	/**
	 * Function to add a attribute to a given nonterminal
	 * 
	 * @param nt
	 *            nonterminal that will insert the attribute
	 * @param name
	 *            the name of the attribute
	 * @param type
	 *            the type of the attribute
	 * @param category
	 *            the category of the attribute
	 * @param num
	 *            the relative position of the attribute inside its category. If
	 *            it has 3 attribute of locals category, then 0 <= num < 3
	 */
	protected void addAttribute(NonTerminal nt, String name, Type type,
			Attribute.Category category, int num) {
		nt.addAttribute(name, type, category, num);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Grammar resp = (Grammar) super.clone();

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

		resp.interpreter = new Interpreter(resp); // set the interpreter

		// Create a new map of new nonterminal with the same values of the
		// old one
		// Only when adding a new rule we will change the Nonterminal value
		// (to save space)
		resp.nonMap = new HashMap<String, NonTerminal>(this.nonMap);

		return resp;
	}
}
