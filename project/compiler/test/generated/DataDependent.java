package generated;

import apeg.compiler.runtime.APEGInputStream;
import apeg.compiler.runtime.Result;
import apeg.compiler.runtime.Grammar;

//file APEG/project/test/syntax/teste06.apeg
public class DataDependent extends Grammar { 

	public DataDependent(APEGInputStream input) {
		super(input);
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
					if(g.read(currentPos) < 0)
						return new Result(currentPos);
				}
			}
		}
		return g.interpreteChoice(0); // supor que a posição de literal3 no vetor de choices é 0
	}

	public Result literal(DataDependent g) throws Exception {
		// code for locals[Grammar g1, int n]
		int n;
		DataDependent g1;
		
		// Code for the parsing expression number<g,n>
		Result result = g.number(g);
		if(!result.isFail()) {
			n = (int) result.getAttribute(0);
			g1 = (DataDependent) g.copy().addRule("strN: "
					         + functions.AdaptableFunctions.concatN("CHAR<g> ", n)
					         + ";");
			if(g.match("[", currentPos) > 0) { // nao falhou
				currentPos++;
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
		return g.interpreteChoice(1); // supor que a posição de literal no vetor de 1
	}
	
	public Result strN(DataDependent g) {
		//codigo para a expressao {? false }
		
		return g.interpreteChoice(2); // supor que a posição de strN no vetor de 2
	}

	public Result CHAR(DataDependent g) throws Exception {
		//codigo para a expressao .
		
		char ch = g.read(currentPos);
		if(!APEGInputStream.isEOF(ch)) {
			currentPos++;
			return new Result(currentPos);
		} // else
	    return g.interpreteChoice(3); // supor que a posição de CHAR no vetor de 3
	}
	
	public Result number(DataDependent g) throws Exception {
		/*
		 * digit<g,r> ( digit<g,aux> { r = r * 10 + aux; } )*
		 */
		int aux;
		Object[] attr = new Object[1]; // Lista dos atributos sintetizados		
		
		Result result = g.digit(g);
		if(!result.isFail()) { // se o resultado nao eh falha, entao continua com
			currentPos = result.getNext_pos(); // atualiza a posicao corrente na entrada
			// retorno de digit - colocar uma variavel r eh uma otimizacao para
			//                    nao fazer cast toda hora e evitar copias de objetos
			int r = ((Integer) result.getAttribute(0)).intValue();
			
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
		return g.interpreteChoice(4); // supor que a posição de number no vetor de 4
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
		
		char ch = read(currentPos);
		Object[] attr = new Object[1]; // cria lista de retorno para o atributo sintetizado x1;
		switch(ch) {
			case '0': // alternativa '0'  { x1 = 0; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 0; // { x1 = 0; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '1': // alternativa '1'  { x1 = 1; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 1; // { x1 = 1; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '2': // alternativa '2'  { x1 = 2; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 2; // { x1 = 2; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '3': // alternativa '3'  { x1 = 3; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 3; // { x1 = 3; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '4': // alternativa '4'  { x1 = 4; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 4; // { x1 = 4; }
				return new Result(currentPos, attr); // cria o objeto de retorno			
			case '5': // alternativa '5'  { x1 = 5; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 5; // { x1 = 5; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '6': // alternativa '6'  { x1 = 6; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 6; // { x1 = 6; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '7': // alternativa '7'  { x1 = 7; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 7; // { x1 = 7; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '8': // alternativa '8'  { x1 = 8; }
				currentPos++; // atualiza a posicao na entrada
				attr[0] = 8; // { x1 = 8; }
				return new Result(currentPos, attr); // cria o objeto de retorno
			case '9': // alternativa '9'  { x1 = 9; }
				currentPos++; // atualiza a posicao na entrada1
				attr[0] = 9; // { x1 = 9; }
				return new Result(currentPos, attr); // cria o objeto de retorno				
			default:
				break;
		}
		
	// Resultado anterior falhou
	return g.interpreteChoice(5); // supor que a posição de digit no vetor eh 5
	}
}
