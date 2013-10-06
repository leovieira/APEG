package apeg.data;

import java.io.IOException;
import java.io.Writer;


import apeg.exception.DataException;

import com.csvreader.CsvWriter;

/**
 * 
 * @author Leonardo Reis
 *
 */

public class DataTable {
	private CsvWriter output; // a csv file
	private int columns; // number of columns of the table
	private String blank; // the string to put in empty cells in a row

	private int pos_column; // current column position
	
	public DataTable(Writer output, int columns, char separator, String blank) {
		this.output = new CsvWriter(output, separator);
		this.columns = columns;
		this.blank = blank;
		
		pos_column = 1;
	}
	
	public void createTableTitle(String[] titles) throws DataException, IOException {
		for(String t : titles) {
			putColumnElement(t);
		}
		output.endRecord();
		pos_column = 1;
	}
	
	public void putLine(String[] column) throws DataException, IOException {
		for(String c : column)
			putColumnElement(c);
		newLine();
	}
	
	public void putColumnElement(String elem) throws DataException, IOException {
		if(pos_column > columns) {
			throw new DataException("Trying to insert a new element out of the bound of the number of columns");
		}
		output.write(elem);
		pos_column++;
	}
	
	public void newLine() throws IOException {
		while(pos_column <= columns) {
			try {
				putColumnElement(blank);
			} catch (DataException e) {
				// It is impossible to throw this exception.
				// because the pos_column is always less than columns
				e.printStackTrace();
			} catch (IOException e) {
				throw e;
			}
		}
		output.endRecord();
		pos_column = 1;
	}
	
	public String getBlank() {
		return blank;
	}

	public void close() {
		output.close();
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		close();
	}
	
	
}
