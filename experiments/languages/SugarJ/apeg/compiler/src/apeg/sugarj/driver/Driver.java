package apeg.sugarj.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sugarj.common.path.Path;
import org.sugarj.common.path.RelativePath;

import apeg.sugarj.common.FileCommands;

public class Driver {
	
	private static final String grammar="grammar/sugarj.apeg";
	
	// a map of sugars to rules
	private static Map<String, String> sugars = new HashMap<String, String>();
	// a list of files currently processing
	private static List<RelativePath> currentlyProcessing = new ArrayList<RelativePath>();
	// a list of file already processed
	private static List<RelativePath> processed = new ArrayList<RelativePath>();
	
	public static void run(RelativePath sourceFile, List<Path> sourcePath) throws Exception {
		// insert the current file in the list of files that are being processed
		currentlyProcessing.add(sourceFile);
		
		// parameters of compilation unit
		Object args[] = new Object[2];
		args[0] = sugars;
		
		// parse the file using the apeg interpreter
		util.Util.testeGrammar(grammar, sourceFile.toString(), "compilation_unit", args);
		
		// remote the file of the list of file being currently processed and insert it in the list of processed files
		currentlyProcessing.remove(sourceFile);
		processed.add(sourceFile);
	}
	
	public static void processImport(String name, List<Path> sourcePath) throws Exception {
		RelativePath file = FileCommands.locateSourceFile(name, sourcePath);
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
}
