package apeg.compiler.option;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;

public class HandlerOption {

	public static String[] handle(String[] args) {
		Options options = specifyOptions();

		try {
			CommandLine line = parseOptions(options, args);
			for(Option opt : line.getOptions()) {
				switch(opt.getLongOpt()) {
				case "help":
					usage(options);
					break;
				case "package":
					//TODO
					opt.getValue();
					break;
				case "output":
					// TODO
					opt.getValue();
					break;
				default:
					System.out.println("Invalid option");
				}
			}
			String[] grammars = line.getArgs();
			if(grammars.length < 1)
				throw new Error("No grammar file specified.");
			return grammars;
			
		} catch (ParseException e) {
			throw new Error(e.getMessage());
		}
	}

	private static Options specifyOptions() {
		Options options = new Options();

		options.addOption("o", "output", true, "Specific the output directory");
		options.addOption("p", "package", true,
				"The package name of the generated code");
		options.addOption("h", "help", true, "Print the help message");

		return options;

	}
	
	private static CommandLine parseOptions(Options options, String[] args)
			throws org.apache.commons.cli.ParseException {
		CommandLineParser parser = new GnuParser();
		return parser.parse(options, args);
	}
	
	/**
	 * TODO
	 */
	private static void usage(Options opt) {
		System.out.println(opt.toString());
	}
}
