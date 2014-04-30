package generated;

import org.antlr.runtime.tree.CommonTree;

import apeg.common.path.AbsolutePath;
import apeg.common.path.Path;
import apeg.compiler.runtime.APEGInputStream;
import apeg.compiler.runtime.Grammar;
import apeg.compiler.runtime.Result;
import apeg.compiler.runtime.interpreter.Environment;
import apeg.compiler.syntax.tree.Attribute;
import apeg.compiler.syntax.tree.NonTerminal;
import apeg.compiler.syntax.tree.Type;

public class BlockLanguage extends Grammar {

	public BlockLanguage(APEGInputStream input) {
		super(input);
		
		// Adding nonterminals informations
		nonterminals = new NonTerminal[8];
		adapt = new CommonTree[8];
		
		NonTerminal nt;
		// Nonterminal block
		nt = new NonTerminal("block", 1); // only one attribute (inherited or synthesized)
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("g1", new Type("Grammar"), Attribute.Category.LOCAL);
		nonterminals[0] = nt;
		ntIndex.put("block", 0);
		
		// Nonterminal dlist
		nt = new NonTerminal("dlist", 2); // it has two attributes (inherited or synthesized)
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("g1", new Type("Grammar"), Attribute.Category.RETURN);
		nonterminals[1] = nt;
		ntIndex.put("dlist", 1);
		
		// Nonterminal decl
		nt = new NonTerminal("decl", 2); // it has two attributes (inherited or synthesized)
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("g1", new Type("Grammar"), Attribute.Category.RETURN);
		nt.addAttribute("s", new Type("String"), Attribute.Category.LOCAL);
		nonterminals[2] = nt;
		ntIndex.put("decl", 2);
		
		// Nonterminal var
		nt = new NonTerminal("var", 1); // it has one attributes (inherited or synthesized)
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("ch", new Type("char"), Attribute.Category.LOCAL);
		nonterminals[3] = nt;
		ntIndex.put("var", 3);
		
		// Nonterminal slist
		nt = new NonTerminal("slist", 1); // it has one attributes (inherited or synthesized)
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nonterminals[4] = nt;
		ntIndex.put("slist", 4);
		
		// Nonterminal stmt
		nt = new NonTerminal("stmt", 1); // it has one attributes (inherited or synthesized)
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nonterminals[5] = nt;
		ntIndex.put("stmt", 5);
		
		// Nonterminal id
		nt = new NonTerminal("id", 2); // it has two attributes (inherited or synthesized)
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("s", new Type("String"), Attribute.Category.RETURN);
		nt.addAttribute("ch1", new Type("String"), Attribute.Category.LOCAL);
		nt.addAttribute("ch2", new Type("String"), Attribute.Category.LOCAL);
		nonterminals[6] = nt;
		ntIndex.put("id", 6);
		
		// Nonterminal alpha
		nt = new NonTerminal("alpha", 2); // it has two attributes (inherited or synthesized)
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("ch", new Type("String"), Attribute.Category.RETURN);
		nonterminals[7] = nt;
		ntIndex.put("alpha", 7);
		
	}

	public Result block(BlockLanguage g) throws Exception {
		BlockLanguage g1; // local attribute
		
		Result result;
		int position = g.match("{", currentPos);
		if(position > 0) {
			g.currentPos = position;
			result = g.dlist(g);
			if(!result.isFail()) {
				g1 = (BlockLanguage) result.getAttribute(0);
				g1.currentPos = result.getNext_pos();
				result = g1.slist(g1);
				if(!result.isFail()) {
					position = g.match("}", result.getNext_pos());
					if(position > 0) {
						char ch = g.read(position);
						if(APEGInputStream.isEOF(ch)) {
							return new Result(position);
						}
					}
				}
			}
		}
		
		Environment env = new Environment(nonterminals[0].getNumParam() // this set is known and fixed
                + nonterminals[0].getNumRet() // this set is known and fixed
                + nonterminals[0].getNumLocal()); // this set can change
		
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(0, env);
	}
	
	public Result dlist(BlockLanguage g) throws Exception {
		BlockLanguage g1;
		
		Result result;
		result = g.decl(g);
		if(!result.isFail()) {
			int position;
			position = result.getNext_pos();
			g1 = (BlockLanguage) result.getAttribute(0); // the return value
			g = g1;
			do {
				position = result.getNext_pos();
				g.currentPos = position;
				result = g.decl(g);
				if(!result.isFail()) {
					position = result.getNext_pos();
					g1 = (BlockLanguage) result.getAttribute(0);
					g = g1;
				}
			} while(!result.isFail());
			Object[] ret = new Object[1];
			ret[0] = g1;
			return new Result(position, ret);
		}
		
		Environment env = new Environment(nonterminals[1].getNumParam() // this set is known and fixed
                + nonterminals[1].getNumRet() // this set is known and fixed
                + nonterminals[1].getNumLocal()); // this set can change
		
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(1, env);
	}
	
	public Result decl(BlockLanguage g) throws Exception {
		BlockLanguage g1; // synthesized attribute
		String s; // local attribute
		
		Result result;
		int position = g.currentPos;
		
		int old_position = position;
		
		position = g.match("int ", position); // 'int '
		if(position > 0) {
			g.currentPos = position;
			result = g.var(g);
			position = result.getNext_pos();
		}
		if(position < 0) { // !('int' var)
			position = old_position;
			position = g.match("int ", position);
			if(position > 0) {
				g.currentPos = position;
				result = g.id(g);
				if(!result.isFail()) {
					position = result.getNext_pos();
					s = (String) result.getAttribute(0);
					position = g.match(";", position);
					if(position > 0) {
						g1 = (BlockLanguage) g.copy().addRule("var: \'" + s + "\' !alpha<g, ch>;");
						Object[] ret = new Object[1];
						ret[0] = g1;
						result = new Result(position, ret);
						return result;
					}
				}
			}
		}		
		
		Environment env = new Environment(nonterminals[2].getNumParam() // this set is known and fixed
                + nonterminals[2].getNumRet() // this set is known and fixed
                + nonterminals[2].getNumLocal()); // this set can change
		
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(2, env);
	}
	
	public Result var(BlockLanguage g) throws Exception {
		
		Environment env = new Environment(nonterminals[3].getNumParam() // this set is known and fixed
                + nonterminals[3].getNumRet() // this set is known and fixed
                + nonterminals[3].getNumLocal()); // this set can change
		
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(3, env);
	}
	
	public Result slist(BlockLanguage g) throws Exception {
		
		Result result;
		result = g.stmt(g);
		if(!result.isFail()) {
			int position;
			do {
				position = result.getNext_pos();
				g.currentPos = position;
				result = g.stmt(g);
			} while(!result.isFail());
			return new Result(position);
		}
		
		Environment env = new Environment(nonterminals[4].getNumParam() // this set is known and fixed
                + nonterminals[4].getNumRet() // this set is known and fixed
                + nonterminals[4].getNumLocal()); // this set can change
		
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(4, env);
	}
	
	public Result stmt(BlockLanguage g) throws Exception {
		Result result;
		
		result = g.var(g);
		if(!result.isFail()) {
			int position = result.getNext_pos();
			position = g.match("=", position);
			if(position > 0) {
				g.currentPos = position;
				result = g.var(g);
				if(!result.isFail()) {
					position = result.getNext_pos();
					position = g.match(";", position);
					return new Result(position);
				}
			}
		}
		
		Environment env = new Environment(nonterminals[5].getNumParam() // this set is known and fixed
                + nonterminals[5].getNumRet() // this set is known and fixed
                + nonterminals[5].getNumLocal()); // this set can change
		
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(5, env);
	}
	
	public Result id(BlockLanguage g) throws Exception {
		String s; // synthesized attribute
		String ch1, ch2; // local attributes
		
		Result result;
		
		result = g.alpha(g);
		if(!result.isFail()) {
			int pos;
			ch1 = (String) result.getAttribute(0);
			s = ch1;
			do {
				pos = result.getNext_pos();
				g.currentPos = pos;
				result = g.alpha(g);
				if(!result.isFail()) {
					ch2 = (String) result.getAttribute(0);
					s = s + ch2;
				}
			} while(!result.isFail());
			Object[] ret = new Object[1];
			ret[0] = s;
			return new Result(pos, ret);
		}
		
		Environment env = new Environment(nonterminals[6].getNumParam() // this set is known and fixed
                + nonterminals[6].getNumRet() // this set is known and fixed
                + nonterminals[6].getNumLocal()); // this set can change
		
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(6, env);
	}

	public Result alpha(BlockLanguage g) throws Exception {
		String ch; // synthesized attribute
		
		int pos = g.currentPos;
		
		if((g.read(pos) >= 'a' && g.read(pos) <= 'z') || (g.read(pos) >= 'A' && g.read(pos) <= 'Z')) {
			ch = "" + g.read(pos);
			pos++;
			Object[] ret = new Object[1];
			ret[0] = ch;
			return new Result(pos, ret);
		}
		
		Environment env = new Environment(nonterminals[7].getNumParam() // this set is known and fixed
                + nonterminals[7].getNumRet() // this set is known and fixed
                + nonterminals[7].getNumLocal()); // this set can change
		
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(7, env);
	}
	
	public static void main(String args[]) throws Exception {
		// Teste DataDependent (teste06.apeg)
		String inputName = "./../test/syntax/input/teste07_input.txt";
		Path inputPath = new AbsolutePath(inputName);
				
		// Parser
		APEGInputStream input = new APEGInputStream(inputPath);
		BlockLanguage parser = new BlockLanguage(input);
				
		// Run
		Result result = parser.block(parser);
		System.out.println("Portion consumed of the input: " + result.getNext_pos());
	}
}
