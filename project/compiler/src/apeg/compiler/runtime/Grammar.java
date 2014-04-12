package apeg.compiler.runtime;

import org.antlr.runtime.tree.CommonTree;

import apeg.compiler.runtime.interpreter.Environment;
import apeg.compiler.runtime.interpreter.Interpreter;
import apeg.compiler.runtime.semantics.Attribute;
import apeg.compiler.runtime.semantics.NonTerminal;
import apeg.compiler.runtime.semantics.Type;

public abstract class Grammar {

	protected static final Result fail_result = new Result(-1,null); // represent a fail result
	
	protected APEGInputStream input; // the input stream
	protected int currentPos = 0; // Current position on the input
	
	/**
	 * Information of nonterminals
	 */
	protected NonTerminal[] nonterminals;
	
	
	/**
	 * Fields related to adaptability on runtime
	 */
	protected CommonTree[] adapt; // vector of possible new choices of any nonterminal
	protected Interpreter interpreter; // the interpreter for new rules or choices
	
	
	protected Grammar(APEGInputStream input) {
		this.input = input;
		interpreter = new Interpreter(this);
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

	protected Result interpreteChoice(int pos, Environment env) throws Exception {
		if(adapt[pos] != null) { // there is a new alternative
			return interpreter.execute(pos, adapt[pos], env);
		} // else
		
		return fail_result;
	}
	
	//TODO
	public Grammar copy() {
		return this;
	}
	
	//TODO
	public Grammar addRule(String rule) {
		return this;
	}
	
	public int getCurrentPos() {
		return currentPos;
	}
	
	public void setCurrentPos(int pos) {
		currentPos = pos;
	}
	
	public NonTerminal getNonterminal(int pos) {
		if(pos >= nonterminals.length || pos < 0)
			return null;
		return nonterminals[pos];
	}
	
	/**
	 * Function to add a attribute to a given nonterminal
	 * @param nt nonterminal that will insert the attribute
	 * @param name the name of the attribute 
	 * @param type the type of the attribute
	 * @param category the category of the attribute
	 * @param num the relative position of the attribute inside its category.
	 *            If it has 3 attribute of locals category, then 0 <= num < 3
	 */
	protected void addAttribute(NonTerminal nt, String name, Type type, Attribute.Category category, int num) {
		nt.addAttribute(name, type, category, num);
	}
}
