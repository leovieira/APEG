package apeg.sugarj.driver.cli;

import java.util.HashSet;
import java.util.Set;

import org.sugarj.common.path.AbsolutePath;
import org.sugarj.common.path.RelativePath;

import apeg.sugarj.common.Environment;
import apeg.sugarj.common.FileCommands;
import apeg.sugarj.driver.Driver;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Environment env = getConsoleEnvironment();
		Set<RelativePath> allInputFiles = new HashSet<RelativePath>();

		try {
			// handle options and location source files
			
			String[] sources = DriverCLI.handleOptions(args, env);

			for (String source : sources) {
				RelativePath sourceLocation = FileCommands.locateSourceFile(source,
						env.getSourcePath());

				if (sourceLocation == null) {
					System.err.println("Could not locate source file \""
							+ source + "\".");
					continue;
				}
				System.out.println("Location: " + sourceLocation.toString());
				allInputFiles.add(sourceLocation);
			}

			// Compile every source file
			for(RelativePath sourceFile : allInputFiles) {
				Driver.run(sourceFile);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Environment getConsoleEnvironment() {
		Environment env = new Environment();
		env.addToSourcePath(new AbsolutePath("."));
		for (String cp : System.getProperty("java.class.path").split(
				System.getProperty("path.separator"))) {
			if (cp.length() > 0)
				env.addToIncludePath(new AbsolutePath(cp));
		}
		return env;
	}
}
