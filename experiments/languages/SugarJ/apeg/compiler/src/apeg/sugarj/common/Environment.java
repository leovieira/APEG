package apeg.sugarj.common;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.sugarj.common.path.AbsolutePath;
import org.sugarj.common.path.Path;

/**
 * Shared execution environment.
 * this file is a adaptation version of org.sugarj.common.Environment
 * 
 * @author leo
 *
 */

public class Environment {
	public static String sep = "/";
	public static String classpathsep = File.pathSeparator;

	private Path root = new AbsolutePath(".");
	
	private List<Path> sourcePath = new LinkedList<Path>();
	private List<Path> includePath = new LinkedList<Path>();

	public Environment() {
		// do nothing
	}
	
	public Path getRoot() {
		return root;
	}

	public void setRoot(Path root) {
		this.root = root;
	}

	public void addToSourcePath(Path p) {
		sourcePath.add(p);
	}
	
	public List<Path> getSourcePath() {
		return Collections.unmodifiableList(new ArrayList<>(sourcePath));
	}

	public void setSourcePath(List<Path> sourcePath) {
		this.sourcePath = sourcePath;
	}
	
	public void addToIncludePath(Path p) {
		this.includePath.add(p);
	}
	  
	public List<Path> getIncludePath() {
		return Collections.unmodifiableList(new ArrayList<>(includePath));
	}

	public void setIncludePath(List<Path> includePath) {
		this.includePath = includePath;
	}
}
