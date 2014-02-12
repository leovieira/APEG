package tests;
import static org.junit.Assert.assertEquals;
import util.Util;


public class Tests {
	
	public static void main(String args[]) throws Exception {
		/*
		Util.testeGrammar("input/teste01.txt", "input/teste01_input.txt", "literal");
		Util.testeGrammar("input/teste02.txt", "input/teste02_input.txt", "S1");
		Util.testeGrammar("input/teste02.txt", "input/teste02_input.txt", "S2");
		Object args3[] = new Object[3];
		args3[0] = 1; args3[1] = 2;
		Util.testeGrammar("input/teste03.txt", "input/teste03_input.txt", "teste", args3);
		System.out.println("Return value(s) = " + args3[2]);
		Util.testeGrammar("input/teste04.txt", "input/teste04_input.txt", "root");
		Util.testeGrammar("input/teste05.txt", "input/teste05_input.txt", "root");
		Util.testeGrammar("input/teste06.txt", "input/teste06_input.txt", "literal3");
		Util.testeGrammar("input/teste06a.txt", "input/teste06_input.txt", "literal3");
		Object args6[] = new Object[1];
		Util.testeGrammar("input/teste06b.txt", "input/teste06_input.txt", "literal3", args6);
		System.out.println("Return value(s) = " + args6[0]);
		Util.testeGrammar("input/teste06b.txt", "input/teste06_input2.txt", "literal", args6);
		System.out.println("Return value(s) = " + args6[0]);
		Util.testeGrammar("input/teste07.txt", "input/teste07_input.txt", "block");
		Util.testeGrammar("input/teste07a.txt", "input/teste07_input.txt", "block");
		Object args8[] = new Object[1];
		Util.testeGrammar("input/teste08.txt", "input/teste08_input.txt", "name", args8);
		System.out.println("Return value(s) = " + args8[0]);		
		Object args9_1[] = new Object[1];
		Util.testeGrammar("input/teste09.txt", "input/teste09_input.txt", "a", args9_1);
		System.out.println("Return value(s) = " + args9_1[0]);
		*/
		Object args9_1a[] = new Object[1];
		int resp = Util.testeGrammar("input/teste09a.txt", "input/teste09_input.txt", "a", args9_1a);
		System.out.println("Resp = " + resp);
		System.out.println("Return value(s) = " + args9_1a[0]);
		resp = Util.testeGrammar("input/teste09a.txt", "input/teste09_input.txt", "c", args9_1a);
		System.out.println("Resp = " + resp);
		System.out.println("Return value(s) = " + args9_1a[0]);

	}

}
