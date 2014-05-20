package generated;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateInput {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "./../test/syntax/input/teste07_input7.txt";
		blockLanguage(fileName, 10000, 10000);
		
		System.out.println("END");
	}
	
	public static void blockLanguage(String outputName, int numVar, int numStmt)
					throws FileNotFoundException {
		PrintWriter file = new PrintWriter(outputName);
		file.print('{');
		// creating variable 
		String vars[] = new String[numVar + 1];
		vars[0] = "";
		for(int i = 1; i <= numVar; ++i) {
			vars[i] = vars[(i-1)/26] + ((char) ('a' + ((i-1)%26)));
			file.print("int " + vars[i] + ";");
		}
		// creating assignments
		for(int i = 0; i < numStmt; ++i) {
			file.print(vars[(i%numVar + 1)]);
			file.print("=");
			file.print(vars[((i+1)%numVar + 1)]);
			file.print(";");
		}
		file.print('}');
		file.close();
	}
	
	public static void dataDependentLanguage(String fileName, int[] size) throws FileNotFoundException {
		//String fileName = "./../test/syntax/input/teste06_input4.txt";
		//int size[] = {150000};
		
		PrintWriter file = new PrintWriter(fileName);		
		for(int i = 0; i < size.length; ++i) {
			int lenght = size[i];
			file.print(lenght);
			file.print('[');
			for(int j = 0; j < lenght; ++j) {
				Random r = new Random();
				char c = (char)(r.nextInt(26) + 'a');
				file.append(c);
			}		
			file.print(']');
		}
		file.close();
		System.out.println("END");
	}
}