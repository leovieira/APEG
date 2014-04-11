package apeg.compiler.runtime;

import java.io.FileReader;
import java.util.ArrayList;

import apeg.common.path.Path;

public class APEGInputStream {
	private FileReader input;
	private ArrayList<Character> buf;
	
	private static final char EOF = (char) -1;
	
	public APEGInputStream() {
		buf = new ArrayList<Character>();
	}
	
	public APEGInputStream(Path path) throws Exception {
		buf = new ArrayList<Character>();
		setInputFile(path);
	}
	
	public void setInputFile(Path filePath) throws Exception {
		input = new FileReader(filePath.getAbsolutePath());
	}
	
	public char read(int pos) throws Exception {
		if (pos < 0) throw new Exception("Index invalid for buffer");
		if (pos < buf.size()) {
			return buf.get(pos);
		}
		char ch = '?';

		int i = buf.size();
		do {
			ch = (char) input.read();
			buf.add(ch);
			++i;
		} while(i <= pos);
		
		return ch;
	}
	
	public int match(String s, int pos) throws Exception {
		for (int i = 0; i < s.length(); ++i) {
			char ch = read(pos + i);
			char ch2 = s.charAt(i);
			if (ch != ch2) {
				return -1;
			}
		}
		return pos + s.length();
	}
	
	public static boolean isEOF(char ch) {
		return ch == EOF;
	}
}
