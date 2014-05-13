package tests;

import util.Util;

public class TestTime {

	public static void main(String[] args) throws Exception {
		String grammarName = "./../test/syntax/teste06.apeg";
		
		String fileName = "./../test/syntax/input/teste06_input3.txt";
		long beginTime = System.currentTimeMillis();
		Util.testeGrammar(grammarName, fileName, "literal");
		long endTime = System.currentTimeMillis();
		System.out.println("Time: " + (endTime - beginTime));
	}

}
