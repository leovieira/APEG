package tests;

import util.Util;

public class TestTime {

	public static void main(String[] args) throws Exception {
		String grammarName = "./../test/syntax/teste07.apeg";
		String fileName = "./../test/syntax/input/teste07_input7.txt";
		
		blockLanguage(grammarName, fileName);
	}

	public static void blockLanguage(String grammar, String input) throws Exception {
		long beginTime = System.currentTimeMillis();
		Util.testeGrammar(grammar, input, "block");
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - beginTime));
	}
	
	public static void dataDependent(String grammar, String input) throws Exception {
		//String grammarName = "./../test/syntax/teste06.apeg";
		//String fileName = "./../test/syntax/input/teste06_input4.txt";
		
		long beginTime = System.currentTimeMillis();
		Util.testeGrammar(grammar, input, "literal");
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - beginTime));
	}
	
}
