package generated;

import apeg.compiler.runtime.Result;
import apeg.compiler.runtime.Grammar;

public class DataDependent extends Grammar {

	public Result literal3(DataDependent g) {
		// code for the expression literal<g> literal<g> literal<g> !.
		
		g.literal(g);
		// algum teste para verificar falha
		g.literal(g);
		// algum teste para verificar falha
		g.literal(g);
		
		// if (resultado anterior for falha) {
		     return g.interpreteChoice(0); // supor que a posição de literal3 no vetor de choices adicionadas no final é 0
		// }
		// else
		     // resultado da parsing expression
	}

	public Result literal(DataDependent g) {
		// code for locals[Grammar g1, int n]
		//int n;
		//DataDependent g1;
		
		// Code for the parsing expression number<g,n>
		g.number(g);
		// verifica se a expressao anterior falhou
		// atualiza o valor com o resultado da expressao anteior
		
		// Codigo para a expressao g1 = addRule(copyGrammar(g), concat(concat('strN : ', concatN('CHAR<g> ', n)), ';')) ;  }
		DataDependent g1 = (DataDependent) g.copy().addRule("strN: CHAR<g> CHAR<g> CHAR<g>"); // <- simplifiquei
		
		// codigo para a expressao '['
		
		g.strN(g1); // chama a regra strN buscando na gramatica g, mas passa como language attribute a g1
		
		// codigo para a expressao ']'
		
	// if (resultado anterior for falha) {
	     return g.interpreteChoice(1); // supor que a posição de literal no vetor de 1
	// }
	// else
	     // resultado da parsing expression
	}
	
	public Result strN(DataDependent g) {
		//codigo para a expressao {? false }
		
	// if (resultado anterior for falha) {
	     return g.interpreteChoice(2); // supor que a posição de strN no vetor de 2
	// }
	// else
	     // resultado da parsing expression
	}

	public Result CHAR(DataDependent g) {
		//codigo para a expressao .
		
	// if (resultado anterior for falha) {
	     return g.interpreteChoice(3); // supor que a posição de CHAR no vetor de 3
	// }
	// else
	     // resultado da parsing expression
	}
	public Result number(DataDependent g) { // Os atributos sintetizados de number serão colocados em Result
		//codigo par locals[int aux]
		//int aux;
		
		//codigo para a expressao {? false }
		
		
	// if (resultado anterior for falha) {
	     return g.interpreteChoice(4); // supor que a posição de number no vetor de 4
	// }
	// else
	     // resultado da parsing expression
	}
	
	public Result digit(DataDependent g) { // Os atributos sintetizados de digit serão colocados em Result
		//codigo para a expressao:
		/*
		 '0'  { x1 = 0; }
       / '1'  { x1 = 1; }
       / '2'  { x1 = 2; }
       / '3'  { x1 = 3; }
       / '4'  { x1 = 4; }
       / '5'  { x1 = 5; }
       / '6'  { x1 = 6; }
       / '7'  { x1 = 7; }
       / '8'  { x1 = 8; }
       / '9'  { x1 = 9; }
		 */
		
	// if (resultado anterior for falha) {
	     return g.interpreteChoice(5); // supor que a posição de digit no vetor de 5
	// }
	// else
	     // resultado da parsing expression
	}
}
