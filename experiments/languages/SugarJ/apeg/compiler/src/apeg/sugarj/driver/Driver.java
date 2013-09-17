package apeg.sugarj.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sugarj.common.path.Path;
import org.sugarj.common.path.RelativePath;

import apeg.data.DataManager;
import apeg.sugarj.common.FileCommands;

public class Driver {
	
	private static final String grammar="/home/leo/workspace/APEG/experiments/languages/SugarJ/apeg/compiler/grammar/sugarj.apeg";
	
	// a map of sugars to rules
	private static Map<String, String> sugars = new HashMap<String, String>();
	// a list of files currently processing
	private static List<RelativePath> currentlyProcessing = new ArrayList<RelativePath>();
	// a list of file already processed
	private static List<RelativePath> processed = new ArrayList<RelativePath>();
	
	public static void run(RelativePath sourceFile, List<Path> sourcePath) throws Exception {
		System.out.println("Analysing source file: " + sourceFile.toString());
		// insert the current file in the list of files that are being processed
		currentlyProcessing.add(sourceFile);
		
		// parameters of compilation unit
		Object args[] = new Object[1];
		args[0] = sourcePath;
		
		// parse the file using the apeg interpreter
		long beginTime = System.currentTimeMillis();
		util.Util.testeGrammar(grammar, sourceFile.toString(), "compilation_unit", args);
		long endTime = System.currentTimeMillis();
		DataManager.addParseTime(endTime-beginTime); // parse time of the all project, including adapt time 
		
		// remote the file of the list of file being currently processed and insert it in the list of processed files
		currentlyProcessing.remove(sourceFile);
		processed.add(sourceFile);
	}
	
	public static void processImport(String name, List<Path> sourcePath) throws Exception {
		System.out.println("Processing import: " + name);
		RelativePath file = FileCommands.locateSourceModule(name, sourcePath);
		if(file == null) {
			return; // I assume that it imports a module that is not a sugar definition 
		} // else
		// the file is locate in the source path
		if(currentlyProcessing.contains(file)) {
			// it is a circular import and I assume that is not sugar definition (SugarJ compiler that this approach)
			return;
		} // else
		if(processed.contains(file)) { // check if the file has been processed
			// the file has been processed.
			return;
		} // else
		// processes the file
		run(file, sourcePath);
	}

	public static boolean containsSugarlibrary(String entry) {
		return sugars.containsKey(entry);
	}

	public static void addSugarLibrary(String entry, String rule) {
		sugars.put(entry, rule);		
	}

	public static String getSugarLibrary(String name) {
		return sugars.get(name);
	}
	
	public static void clear() {
		sugars.clear();
		processed.clear();
		currentlyProcessing.clear();
	}
}
