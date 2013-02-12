
import semantics.Grammar;
import util.Util;

public class Test {
	
	public static void main(String args[]) throws Exception {
/*		Util.testeGrammar("input/teste01.txt", "input/teste01_input.txt", "literal");
		Util.testeGrammar("input/teste02.txt", "input/teste02_input.txt", "S1");
		Util.testeGrammar("input/teste02.txt", "input/teste02_input.txt", "S2");
		Util.testeGrammar("input/teste03.txt", "input/teste03_input.txt", "teste");
		Util.testeGrammar("input/teste04.txt", "input/teste04_input.txt", "root");
		Util.testeGrammar("input/teste05.txt", "input/teste05_input.txt", "root");*/
		Util.testeGrammar("input/teste06.txt", "input/teste01_input.txt", "literal", true);
	}
	
}
