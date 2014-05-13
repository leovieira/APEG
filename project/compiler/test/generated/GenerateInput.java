package generated;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class GenerateInput {
	public static void main(String[] args) throws FileNotFoundException {
		String fileName = "./../test/syntax/input/teste06_input4.txt";
		PrintWriter file = new PrintWriter(fileName);
		int size[] = {150000};
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
