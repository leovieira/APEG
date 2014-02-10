package apeg.compiler;

import apeg.compiler.option.HandlerOption;

public class Tool {
	
	public static void main(String[] args) {
		/**
		 * Handling the command lines args
		 */
		String[] grammars = HandlerOption.handle(args);
		for(String s : grammars) {
			/**
			 * Parsing the syntax of the grammar
			 */
			
			
			System.out.println(s);
		}
	}
}
