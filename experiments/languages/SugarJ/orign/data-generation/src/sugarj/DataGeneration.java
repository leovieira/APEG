package sugarj;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;

public class DataGeneration {
	
	/**
	 * @param cmd
	 */
	public static void main(String[] cmd) throws Throwable {
		try {
			CommandLine opts = parseOptions(specifyOptions(), cmd);
			
			//Generating the input arguments
			String files[] = opts.getArgs();
			if(files.length < 1) {
				throw new Exception("No source files specified.");
			}
			String args[] = new String[7+files.length];
			args[0] = "-l"; args[1] = "java";
			args[2] = "--sourcepath";
			//
			args[3] = opts.getOptionValue("sourcepath");
			args[4] = "-d";
			args[5] = opts.getOptionValue("binpath");
			args[6] = "--gen-files";
			for(int j = 0; j < files.length; ++j) {
				args[7+j] = files[j];
			}
			String output;
			if(opts.getOptionValue("output").endsWith(".csv"))
				output = opts.getOptionValue("output").substring(0, opts.getOptionValue("output").length() - 4);
			else
				output = opts.getOptionValue("output");
			String project = output.substring(output.lastIndexOf("/")+1, output.length());
			String path = output.substring(0, output.lastIndexOf("/")+1);
			apeg.data.DataManager.init(project, path, false);
			org.sugarj.driver.cli.Main.main(args);
			apeg.data.DataManager.flush();
		} catch(org.apache.commons.cli.ParseException exp) {
			
		}
		System.exit(0);
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

		options.addOption("sp", "sourcepath", true, "Specify where to find source files.");
		options.addOption("bp", "binpath", true, "Specify where to output the generated files.");
		options.addOption("o", "output", true,
				               "Specify the output name path of the generated file with the execution time.");

		options.addOption(null, "help", false, "Print this synopsis of options");

		return options;
	}
}
