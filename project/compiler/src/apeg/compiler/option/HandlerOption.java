package apeg.compiler.option;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;

import apeg.common.path.AbsolutePath;
import apeg.common.path.RelativePath;
import apeg.compiler.Tool;
import apeg.compiler.codegen.language.JavaInfo;

public class HandlerOption {

	public static String[] handle(String[] args, Tool tool) {
		Options options = specifyOptions();

		try {
			CommandLine line = parseOptions(options, args);
			for(Option opt : line.getOptions()) {
				switch(opt.getLongOpt()) {
				case "help":
					usage(options);
					break;
				case "package":
					tool.setModuleName(opt.getValue());
					break;
				case "output":
					String output = opt.getValue();
					if(AbsolutePath.isAbsolute(output)) {
						tool.setOutputPath(new AbsolutePath(output));
					} else {
						tool.setOutputPath(new RelativePath(new AbsolutePath(System.getProperty("user.dir")),
								           output));
					}
					break;
				case "language":
					String language = opt.getValue();
					tool.setTemplates(language);
					switch(language) {
					case "Java":
						tool.setLanguage(new JavaInfo());
						break;
					default:
						break;
					}
					break;
				default:
					//System.out.println("Invalid option");
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
				"The package/namespace for the generated code");
		options.addOption("l", "language", true,
				"Specific the target language for the generated code");
		options.addOption("h", "help", false, "Print the help message");

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
