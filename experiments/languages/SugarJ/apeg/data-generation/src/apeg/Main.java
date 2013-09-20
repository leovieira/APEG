package apeg;

import java.io.File;

import apeg.sugarj.driver.Driver;

public class Main {
	private static final int NUM_EXEC = 1;

	public static void main(String[] cmd) throws Throwable {
		final String path = "/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/case-studies";
		String project[] = { "closures", "pairs" };
		String source[] = { "src", "src" };
		String files[][] = { { "javaclosure/Test.sugj" }, {"pair/TestPair.sugj"} };

		for (int i = 0; i < project.length; ++i) {
			for (int j = 1; j <= NUM_EXEC; ++j) {
				createDir("./data/" + project[i]);
				run(path, project[i], files[i], source[i], project[i] + "_" + j);
				Driver.clear();
			}
		}
	}

	private static void run(String path, String project, String[] files,
			String source, String outputName) throws Throwable {
		// Generating the input arguments
		String args[] = new String[2 + files.length];
		args[0] = "--sourcepath";
		args[1] = path + "/" + project + "/" + source;
		for (int j = 0; j < files.length; ++j) {
			args[2 + j] = files[j];
		}
		apeg.data.DataManager.init(outputName, "data/" + project);
		apeg.sugarj.driver.cli.Main.main(args);
		apeg.data.DataManager.flush();
	}

	private static void createDir(String path) {
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
	}
}
