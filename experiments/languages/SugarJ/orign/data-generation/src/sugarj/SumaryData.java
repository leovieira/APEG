package sugarj;

import java.io.File;
import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;

import apeg.data.DataManager;
import apeg.exception.DataException;

import com.csvreader.CsvReader;

public class SumaryData {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		try {
			CommandLine opts = parseOptions(specifyOptions(), args);
			String files[] = opts.getArgs();
			if(files.length < 1) {
				throw new Exception("No source files specified.");
			}
			String path = opts.getOptionValue("input");
			String project = path.substring(path.lastIndexOf("/")+1, path.length());
			sumaryData(path, project, files);
		} catch(org.apache.commons.cli.ParseException exp) {
			
		}
		System.exit(0);
	}
	
	private static void sumaryData(String path, String project, String[] files) throws DataException, IOException {
		DataManager.init(project + "_sumary", path, false);
		File dir = new File("data/" + project);
		int i = 1;
		for(String file : dir.list()) {
			if(file.equals(DataManager.getFileName()))
				continue;
			System.out.println(file);
			CsvReader csv = new CsvReader(dir.getAbsolutePath() + "/" + file, ';');
			csv.readHeaders(); // read the first line as header columns
			while(csv.readRecord()) {
				String file_name = csv.get("File");
				String parse_time = csv.get("Parse");
				String adapt_time = csv.get("Adapt");
				if(isOneOf(file_name, files) || file_name.equals("init")) {
					DataManager.addAdaptabilityTime("execution: " + getFileName(file), Long.parseLong(adapt_time));
					DataManager.addParseTime("execution: " + getFileName(file), Long.parseLong(parse_time));
				}				
			}
			csv.close();
			i++;
		}	
		DataManager.flush();
	}
	
	private static boolean isOneOf(String file, String[] files) {
		if(file.isEmpty())
			return false;
		for(String f : files) {
			if(file.endsWith(f))
				return true;
		}
		return false;
	}
	
	private static String getFileName(String file) {
		String resp;
		System.out.println(file);
		resp = file.substring(file.lastIndexOf("/")+1, file.length()-9);
		return resp;
	}
	
	//*************************************************************************
	//******************** Handle Options *************************************
	//************************************************************************
	
	private static CommandLine parseOptions(Options options, String[] args)
			throws org.apache.commons.cli.ParseException {
		CommandLineParser parser = new GnuParser();
		return parser.parse(options, args);
	}
	
	private static Options specifyOptions() {
		Options options = new Options();

		options.addOption("i", "input", true, "Specify where to find data files.");

		options.addOption(null, "help", false, "Print this synopsis of options");

		return options;
	}
}
