package apeg.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import apeg.exception.DataException;

public class DataManager {
	private String project_name;	
	private String[] unit = {"", "(ms)", "(ms)"};
	private DataTable csv_file;
	private Map<String, long[]> rows;
	
	private static final String[] row_title = {"File", "Adapt", "Parse"};
	private static DataManager instance = null;
	
	private static final int EMPTY = -1; // Flag marking a empty position
	public static final int ADAPT = 0; // Flag marking the position of the adaptability time in the vector rows
	public static final int PARSE = 1; // Flag marking the position of in the vector rows
	
	private DataManager() {}
	
	public static DataManager getInstance() {
		return instance;
	}
	
	public static DataManager init(String project, String path, boolean append) throws IOException, DataException {
		instance = new DataManager();
		instance.project_name = project;
		instance.csv_file = new DataTable(new FileWriter(path + "/" + project + "_data.csv", append),
				                                         row_title.length, ';', "0");
		if(!append)
			instance.csv_file.createTableTitle(row_title);
		instance.rows = new HashMap<String, long[]>();
		
		return getInstance();
	}
	
	public static void addAdaptabilityTime(long time) throws DataException, IOException {
		putTime(getInstance().project_name, time, ADAPT);
	}
	
	public static void addParseTime(long time) throws DataException, IOException {
		putTime(getInstance().project_name, time, PARSE);
	}
	
	public static void addAdaptabilityTime(String file, long time) throws DataException, IOException {
		putTime(file, time, ADAPT);
	}
	
	public static void addParseTime(String file, long time) throws DataException, IOException {
		putTime(file, time, PARSE);
	}
	
	public static void putTime(String file, long time, int pos) throws DataException, IOException {
		if(pos >= row_title.length - 1 || pos < 0)
			throw new DataException("Time position " + pos + " not defined");
		DataManager instance = getInstance();
		if(instance.rows.containsKey(file)) {
			long[] entry = instance.rows.get(file);
			if(entry[pos] == EMPTY)
				entry[pos] = time;
			else
				entry[pos] += time;
		} else {
			long[] entry = new long[row_title.length-1];
			for(int i = 0; i < entry.length; ++i)
				entry[i] = EMPTY;
			entry[pos] = time;
			instance.rows.put(file, entry);
		}
	}
	
	public static void flush() throws DataException, IOException {
		DataManager instance = getInstance();
		for(String s : instance.rows.keySet()) {
			long[] entry = instance.rows.get(s);
			String[] line = new String[row_title.length];
			line[0] = s;
			for(int i = 0; i < entry.length; i++) {
				if(entry[i] == EMPTY)
					line[i+1] = instance.csv_file.getBlank();
				else
					line[i+1] = Long.toString(entry[i]);
			}
			instance.csv_file.putLine(line);
		}
		instance.csv_file.close();
	}
	
	public static String getFileName() {
		return instance.project_name + "_data.csv";
	}
	
	//---------------
	public void setUnit(String unit, int pos) throws DataException {
		if(pos > this.unit.length-1)
			throw new DataException("Invalid position of unit");
		this.unit[pos] = "(" + unit + ")";
	}
	
	public static void main(String args[]) {
		try {
			DataManager.init("test", "/home/leo/workspace/APEG/experiments/languages/SugarJ/data", false);
			
			DataManager.addParseTime("test01", 2);
			DataManager.addParseTime("test01", 3);
			
			DataManager.addAdaptabilityTime("test02", 7);
			
			DataManager.flush();
		} catch (IOException | DataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
