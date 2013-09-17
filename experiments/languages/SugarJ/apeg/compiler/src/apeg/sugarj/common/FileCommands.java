package apeg.sugarj.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.sugarj.common.path.Path;
import org.sugarj.common.path.RelativePath;

/**
 * copied and adapted from org.sugarj.common.FileCommands and org.sugarj.driver.ModuleSystemCommands
 * @author leo
 *
 */

public class FileCommands {

	// ************************ Functions to find out a source file ************

	public static RelativePath locateSourceModule(String module, List<Path> sourcePath) {
		String fileName = module.replace('.', '/');
		RelativePath file = searchFileInSourceLocationPath(fileName, "sugj", sourcePath);
		if(file == null)
			searchFileInSourceLocationPath(fileName, "java", sourcePath);
		return file;
	}
	
	public static RelativePath locateSourceFile(String source,
			List<Path> sourcePath) {
		int i = source.lastIndexOf('.');
		String modulePath = i > 0 ? source.substring(0, i) : source;
		String extension = i > 0 ? source.substring(i + 1, source.length())
				: null;

		return searchFileInSourceLocationPath(modulePath, extension, sourcePath);
	}

	private static RelativePath searchFileInSourceLocationPath(
			String modulePath, String extension, List<Path> searchPath) {
		for (Path loc : searchPath) {
			RelativePath p = searchFile(loc, modulePath, extension);
			if (p != null)
				return p;
		}
		return null;
	}

	@SuppressWarnings("resource")
	private static RelativePath searchFile(Path base, String relativePath,
			String extension) {
		if (relativePath.startsWith(base.getAbsolutePath())) {
			int sepOffset = relativePath.endsWith(Environment.sep) ? 0 : 1;
			relativePath = relativePath.substring(base.getAbsolutePath()
					.length() + sepOffset);
		}

		RelativePath p = new RelativePath(base, relativePath + "." + extension);
		if (p.getFile().exists())
			return p;

		URLClassLoader cl = null;
		try {
			cl = new URLClassLoader(
					new URL[] { base.getFile().toURI().toURL() }, null);
			if (cl.getResource(relativePath + "." + extension) != null)
				return new RelativePath(base, relativePath + "." + extension);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
