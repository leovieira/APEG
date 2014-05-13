package generated;

import org.antlr.runtime.tree.CommonTree;

import apeg.common.path.AbsolutePath;
import apeg.common.path.Path;
import apeg.compiler.runtime.APEGInputStream;
import apeg.compiler.runtime.Result;
import apeg.compiler.runtime.Grammar;
import apeg.compiler.runtime.interpreter.Environment;
import apeg.compiler.syntax.tree.Attribute;
import apeg.compiler.syntax.tree.NonTerminal;
import apeg.compiler.syntax.tree.Type;

//file APEG/project/test/syntax/teste06.apeg
public class DataDependent extends Grammar { 

	public DataDependent(APEGInputStream input) {
		super(input);
		
		// create the nonterminal vector - the size is known during the syntax analysis
		nonterminals = new NonTerminal[6];
		// Create the set of possible new choices for every nonterminal
		adapt = new CommonTree[6];
		
		/**
		 * Insert information for every nonterminal
		 */
		NonTerminal nt;
		// nonterminal literal3
		nt = new NonTerminal("literal3", 1); // size of inherited plus synthesized attributes is 1
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nonterminals[0] = nt;
		ntIndex.put("litera3", 0);
		
		// nonterminal literal
		nt = new NonTerminal("literal", 1); // size of inherited plus synthesized attributes is 1
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("n", new Type("int"), Attribute.Category.LOCAL);
		nt.addAttribute("g1", new Type("Grammar"), Attribute.Category.LOCAL);
		nonterminals[1] = nt;
		ntIndex.put("literal", 1);

		// nonterminal strN
		nt = new NonTerminal("strN", 1); // size of inherited plus synthesized attributes is 1
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nonterminals[2] = nt;
		ntIndex.put("strN", 2);
		
		// nonterminal CHAR
		nt = new NonTerminal("CHAR", 1); // size of inherited plus synthesized attributes is 1
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nonterminals[3] = nt;
		ntIndex.put("CHAR", 3);
		
		// nonterminal number
		nt = new NonTerminal("number", 2); // size of inherited plus synthesized attributes is 2
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("r", new Type("int"), Attribute.Category.RETURN);
		nt.addAttribute("aux", new Type("int"), Attribute.Category.LOCAL);
		nonterminals[4] = nt;
		ntIndex.put("number", 4);
		
		// nonterminal digit
		nt = new NonTerminal("digit", 2); // size of inherited plus synthesized attributes is 2
		nt.addAttribute("g", new Type("Grammar"), Attribute.Category.PARAM);
		nt.addAttribute("x1", new Type("int"), Attribute.Category.RETURN);
		nonterminals[5] = nt;
		ntIndex.put("digit", 5);
	}

	public Result literal3(DataDependent g) throws Exception {
		// code for the expression literal<g> literal<g> literal<g> !.
		
		Result result = g.literal(g);
		if(!result.isFail()) {
			currentPos = result.getNext_pos();
			result = g.literal(g);
			if(!result.isFail()) {
				currentPos = result.getNext_pos();
				result = g.literal(g);
				if(!result.isFail()) {
					currentPos = result.getNext_pos();
					if(APEGInputStream.isEOF(g.read(currentPos)))
						return new Result(currentPos);
				}
			}
		}
		// Create the correspondent environment of the nonterminal
		Environment env = new Environment(nonterminals[0].getNumParam() // this set is known and fixed
                                          + nonterminals[0].getNumRet() // this set is known and fixed
                                          + nonterminals[0].getNumLocal()); // this set can change
		env.setValue(0, g); // set the value of the language attribute
		
		return g.interpreteChoice(0, env); // supor que a posição de literal3 no vetor de choices é 0
	}

	public Result literal(DataDependent g) throws Exception {
		// code for locals[Grammar g1, int n]
		int n;
		DataDependent g1;
		
		// Code for the parsing expression number<g,n>
		Result result = g.number(g);
		if(!result.isFail()) {
			n = (int) result.getAttribute(0);
			currentPos = result.getNext_pos();
			g1 = (DataDependent) g.copy().addRule("strN: "
					         + functions.AdaptableFunctions.concatN("CHAR<g> ", n)
					         + ";");
			if(g.match("[", currentPos) > 0) { // nao falhou
				currentPos++;
				g1.setCurrentPos(currentPos);
				result = g.strN(g1);
				if(!result.isFail()) {
					currentPos = result.getNext_pos();
					if(g.match("]", currentPos) > 0) { // nao falhou
						currentPos++;
						return new Result(currentPos);
					}
				}
			};
		}
		// Create the correspondent environment of the nonterminal
		Environment env = new Environment(nonterminals[1].getNumParam() // this set is known and fixed
                + nonterminals[1].getNumRet() // this set is known and fixed
                + nonterminals[1].getNumLocal()); // this set can change
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		// The semantics of choice allow us only to set the inherited attributes.
		// If we use the alternative semantics of choice, we must to set all values 
		
		return g.interpreteChoice(1, env); // supor que a posição de literal no vetor de 1
	}
	
	public Result strN(DataDependent g) throws Exception {
		//codigo para a expressao {? false }
		
		// Create the correspondent environment of the nonterminal
		Environment env = new Environment(nonterminals[2].getNumParam() // this set is known and fixed
                + nonterminals[2].getNumRet() // this set is known and fixed
                + nonterminals[2].getNumLocal()); // this set can change
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
		return g.interpreteChoice(2, env); // supor que a posição de strN no vetor de 2
		
		/* Usei esse codigo em interpreterChoice para testar literal
		 * if(pos == 2) {
			DataDependent g = (DataDependent) this;
			try {
				g.CHAR(g);
				g.CHAR(g);
				g.CHAR(g);
				return new Result(g.currentPos);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

	public Result CHAR(DataDependent g) throws Exception {
		//codigo para a expressao .
		
		char ch = g.read(currentPos);
		if(!APEGInputStream.isEOF(ch)) {
			currentPos++;
			return new Result(currentPos);
		} // else
		
		// Create the correspondent environment of the nonterminal
		Environment env = new Environment(nonterminals[3].getNumParam() // this set is known and fixed
                + nonterminals[3].getNumRet() // this set is known and fixed
                + nonterminals[3].getNumLocal()); // this set can change
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		
	    return g.interpreteChoice(3, env); // supor que a posição de CHAR no vetor de 3
	}
	
	public Result number(DataDependent g) throws Exception {
		/*
		 * digit<g,r> ( digit<g,aux> { r = r * 10 + aux; } )*
		 */
		int aux;	
		int r;
		Object[] attr = new Object[1]; // Lista dos atributos sintetizados		
		
		Result result = g.digit(g);
		if(!result.isFail()) { // se o resultado nao eh falha, entao continua com
			currentPos = result.getNext_pos(); // atualiza a posicao corrente na entrada
			// retorno de digit - colocar uma variavel r eh uma otimizacao para
			//                    nao fazer cast toda hora e evitar copias de objetos
			r = ((Integer) result.getAttribute(0)).intValue();
			
			// codigo para (expr)*
			do {
				result = g.digit(g);
				if(!result.isFail()) {
					currentPos = result.getNext_pos(); // atualiza a posicao corrente na entrada
					aux = ((Integer) result.getAttribute(0)).intValue(); // retorno de digit
					r = r * 10 + aux;
				}
			} while(!result.isFail());
			
			attr[0] = r; // colocar o valor do atributo sintetizado no objeto de retorno
			result = new Result(currentPos, attr);
			
			return result; // sucesso
			
		} //else
			// o resultado da sequencia falhou, entao interpreta a possivel nova alternativa
		
		// Create the correspondent environment of the nonterminal
		Environment env = new Environment(nonterminals[4].getNumParam() // this set is known and fixed
                + nonterminals[4].getNumRet() // this set is known and fixed
                + nonterminals[4].getNumLocal()); // this set can change
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		// The semantics of choice allow us only to set the inherited attributes.
		// If we use the alternative semantics of choice, we must to set all values 
				
		return g.interpreteChoice(4, env); // supor que a posição de number no vetor de 4
	}
	
	public Result digit(DataDependent g) throws Exception {
		/*
		   '0'  { x1 = 0; } / '1'  { x1 = 1; } / '2'  { x1 = 2; }
         / '3'  { x1 = 3; } / '4'  { x1 = 4; } / '5'  { x1 = 5; }
         / '6'  { x1 = 6; } / '7'  { x1 = 7; } / '8'  { x1 = 8; }
         / '9'  { x1 = 9; }
		*/
		
		// codigo para a expressao de digit
		// a geracao automatica ira fazer uma coisa menos otimizada e mais generica
		
		int x1;
		
		char ch = read(currentPos);
		Object[] attr = new Object[1]; // cria lista de retorno para o atributo sintetizado x1;
		switch(ch) {
			case '0': // alternativa '0'  { x1 = 0; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 0; // { x1 = 0; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '1': // alternativa '1'  { x1 = 1; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 1; // { x1 = 1; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '2': // alternativa '2'  { x1 = 2; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 2; // { x1 = 2; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '3': // alternativa '3'  { x1 = 3; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 3; // { x1 = 3; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '4': // alternativa '4'  { x1 = 4; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 4; // { x1 = 4; }
				return new Result(currentPos, attr); // cria o objeto de retorno			
			case '5': // alternativa '5'  { x1 = 5; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 5; // { x1 = 5; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '6': // alternativa '6'  { x1 = 6; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 6; // { x1 = 6; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '7': // alternativa '7'  { x1 = 7; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 7; // { x1 = 7; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '8': // alternativa '8'  { x1 = 8; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = x1 = 8; // { x1 = 8; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '9': // alternativa '9'  { x1 = 9; }
				currentPos++; // atualiza a posicao na entrada1
				attr[0] = x1 = 9; // { x1 = 9; }
				return new Result(currentPos, attr); // cria o objeto de retorno				
			default:
				break;
		}

		// Create the correspondent environment of the nonterminal
		Environment env = new Environment(nonterminals[5].getNumParam() // this set is known and fixed
                + nonterminals[5].getNumRet() // this set is known and fixed
                + nonterminals[5].getNumLocal()); // this set can change
		env.setValue(0, g); // set the value of the language attribute. It is always the first one
		// The semantics of choice allow us only to set the inherited attributes.
		// If we use the alternative semantics of choice, we must to set all values 
		
		// Resultado anterior falhou
		return g.interpreteChoice(5, env); // supor que a posição de digit no vetor eh 5
	}
	
	/****************************************************
	 * **************************************************
	 * **************************************************
	 */
	public static void main(String[] args) throws Exception {
		// Teste DataDependent (teste06.apeg)
		String inputName = "./../test/syntax/input/teste06_input3.txt";
		Path inputPath = new AbsolutePath(inputName);
		
		// Parser
		APEGInputStream input = new APEGInputStream(inputPath);
		DataDependent parser = new DataDependent(input);
		
		// Run
		long beginTime = System.currentTimeMillis();		
		Result result = parser.literal(parser);
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - beginTime));
		System.out.println("Portion consumed of the input: " + result.getNext_pos());
		
		//Result result = parser.literal(parser);
		//System.out.println(result.getNext_pos());

	}
}
