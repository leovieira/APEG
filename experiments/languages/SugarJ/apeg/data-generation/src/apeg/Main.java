package apeg;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;

public class Main {

	public static void main(String[] cmd) throws Throwable {
		try {
			CommandLine opts = parseOptions(specifyOptions(), cmd);
			String files[] = opts.getArgs();
			if(files.length < 1) {
				throw new Exception("No source files specified.");
			}
			String args[] = new String[2 + files.length];
			args[0] = "--sourcepath";
			args[1] = opts.getOptionValue("sourcepath");
			for (int j = 0; j < files.length; ++j) {
				args[2 + j] = files[j];
			}
			String output;
			if(opts.getOptionValue("output").endsWith(".csv"))
				output = opts.getOptionValue("output").substring(0, opts.getOptionValue("output").length() - 4);
			else
				output = opts.getOptionValue("output");
			String project = output.substring(output.lastIndexOf("/")+1, output.length());
			String path = output.substring(0, output.lastIndexOf("/")+1);
			boolean append = opts.hasOption("append");
			
			apeg.data.DataManager.init(project, path, append);
			apeg.sugarj.driver.cli.Main.main(args);
			apeg.data.DataManager.flush();
		} catch(org.apache.commons.cli.ParseException exp) {
			
		}
		
		//String files[][] = { /*{ "javaclosure/Test.sugj" }, {"pair/TestPair.sugj"},*/ {"xml/Test.sugj"} };
	}
	
	// *************************************************************************
	// ******************** Handle Options *************************************
	// ************************************************************************

	private static CommandLine parseOptions(Options options, String[] args)
			throws org.apache.commons.cli.ParseException {
		CommandLineParser parser = new GnuParser();
		return parser.parse(options, args);
	}

	private static Options specifyOptions() {
		Options options = new Options();

		options.addOption("sp", "sourcepath", true,
				"Specify where to find source files.");
		options.addOption("o", "output", true,
				"Specify the output name path of the generated file with the execution time.");
		options.addOption(null, "append", false,
				"Specify if it is to create a new output file or append in an existing one");
		
		options.addOption(null, "help", false, "Print this synopsis of options");

		return options;
	}
}
