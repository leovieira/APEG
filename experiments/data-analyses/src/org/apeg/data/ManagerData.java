package org.apeg.data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apeg.exception.DataException;

public class ManagerData {
	//private String project_name;	
	private String[] unit = {"", "(ms)", "(ms)"};
	private DataTable csv_file;
	private Map<String, int[]> rows;
	
	private static final String[] row_title = {"File", "Adapt", "No_Adapt"};
	private static ManagerData instance = null;
	
	private static final int EMPTY = -1; // Flag marking a empty position
	public static final int ADAPT = 0; // Flag marking the position of the adaptability time in the vector rows
	public static final int NO_ADAPT = 1; // Flag marking the position of in the vector rows
	private static final int FLAG = 2; // Flag marking if all vector time is filled
	
	public static ManagerData getInstance() {
		return instance;
	}
	
	public static ManagerData init(String project, String path) throws IOException, DataException {
		instance = new ManagerData();
		//instance.project_name = project;
		instance.csv_file = new DataTable(new FileWriter(path + "/" + project + "_data.csv", true),
				                                         row_title.length, ';', "0");
		instance.csv_file.createTableTitle(row_title);
		instance.rows = new HashMap<String, int[]>();
		
		return getInstance();
	}
	
	public static void timeAdaptability(String file, int time) throws DataException, IOException {
		putTime(file, time, ADAPT);
	}
	
	public static void timeNoAdaptability(String file, int time) throws DataException, IOException {
		putTime(file, time, NO_ADAPT);
	}
	
	public static void putTime(String file, int time, int pos) throws DataException, IOException {
		ManagerData instance = getInstance();
		if(instance.rows.containsKey(file)) {
			int[] entry = instance.rows.get(file);
			if(entry[FLAG] == row_title.length - 1)
				throw new DataException("The time for the file " + file + " have been already setted");
			entry[pos] = time;
			entry[FLAG]++;
			if(entry[FLAG] == row_title.length - 1) {
				String[] line = new String[row_title.length];
				line[0] = file;
				for(int i = 1; i < entry.length; i++)
					line[i] = Integer.toString(entry[i-1]); 					
				instance.csv_file.putLine(line);
			}
		} else {
			int[] entry = new int[row_title.length];
			for(int i = 0; i < entry.length; ++i)
				entry[i] = EMPTY;
			entry[pos] = time;
			entry[FLAG] = 1;
			instance.rows.put(file, entry);
		}
	}
	
	public static void flush() throws DataException, IOException {
		ManagerData instance = getInstance();
		for(String s : instance.rows.keySet()) {
			int[] entry = instance.rows.get(s);
			if(entry[FLAG] != row_title.length-1) {
				String[] line = new String[row_title.length];
				line[0] = s;
				for(int i = 1; i < entry.length; i++) {
					if(entry[i-1] == EMPTY)
						line[i] = instance.csv_file.getBlank();
					else
						line[i] = Integer.toString(entry[i-1]);
				}
				instance.csv_file.putLine(line);
			}
		}
	}
	
	//---------------
	public void setUnit(String unit, int pos) throws DataException {
		if(pos > this.unit.length-1)
			throw new DataException("Invalid position of unit");
		this.unit[pos] = "(" + unit + ")";
	}
}
