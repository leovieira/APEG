package apeg.sugarj.driver.cli;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.sugarj.common.path.AbsolutePath;
import org.sugarj.common.path.Path;

import apeg.sugarj.common.Environment;

public class DriverCLI {
	// ************************ Functions to handle options *********************

	public static String[] handleOptions(String[] args, Environment env) {
		Options options = specifyOptions();

		try {
			CommandLine line = parseOptions(options, args);
			return processOptions(options, line, env);
		} catch (ParseException e) {
			throw new Error(e.getMessage());
		}
	}

	private static String[] processOptions(Options options, CommandLine line,
			Environment environment)
			throws org.apache.commons.cli.ParseException {
		if (line.hasOption("help"))
			;

		if (line.hasOption("sourcepath")) {
			List<Path> sourcePath = new LinkedList<Path>();
			for (String path : line.getOptionValue("sourcepath").split(
					org.sugarj.common.Environment.classpathsep))
				sourcePath.add(pathArgument(path));
			environment.setSourcePath(sourcePath);
		}
		String[] sources = line.getArgs();
		if (sources.length < 1)
			throw new Error("No source files specified.");
		return sources;
	}

	private static AbsolutePath pathArgument(String path) {
		if (!AbsolutePath.acceptable(path)) {
			if (path.startsWith(File.separator) || path.startsWith("/"))
				path = "." + path;
			else
				path = "./" + path;
		}
		return new AbsolutePath(path);
	}

	private static CommandLine parseOptions(Options options, String[] args)
			throws org.apache.commons.cli.ParseException {
		CommandLineParser parser = new GnuParser();
		return parser.parse(options, args);
	}

	private static Options specifyOptions() {
		Options options = new Options();

		options.addOption(
				"cp",
				"buildpath",
				true,
				"Specify where to find compiled files. Multiple paths can be given separated by \'"
						+ org.sugarj.common.Environment.classpathsep + "\'.");

		options.addOption(
				null,
				"sourcepath",
				true,
				"Specify where to find source files. Multiple paths can be given separated by \'"
						+ org.sugarj.common.Environment.classpathsep + "\'.");

		options.addOption(null, "help", false, "Print this synopsis of options");

		return options;
	}
}
