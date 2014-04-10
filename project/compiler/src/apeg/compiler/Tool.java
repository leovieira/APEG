package apeg.compiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;

import apeg.common.path.AbsolutePath;
import apeg.common.path.Path;
import apeg.compiler.codegen.Emitter;
import apeg.compiler.codegen.language.JavaInfo;
import apeg.compiler.codegen.language.LangInfo;
import apeg.compiler.option.HandlerOption;
import apeg.compiler.syntax.Parser;

public class Tool {
	
	private StringTemplateGroup templates;
	private Path outputPath;
	private String module;
	
	private LangInfo language = new JavaInfo();
	
	public Tool() {
		FileReader groupFile;
		try {
			// load the default template
			groupFile = new FileReader("./template/Java.stg");
		//	templates = new StringTemplateGroup(groupFile);
			groupFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Set the default output location
		String currentDir = System.getProperty("user.dir");
		outputPath = new AbsolutePath(currentDir);
	}
	
	public static void main(String[] args) {
		/**
		 * Handling the command lines args
		 */
		Tool tool = new Tool();
		String[] grammars = HandlerOption.handle(args, tool);
		for(String s : grammars) {
			//TODO only for test. Get the grammar name from the AST
			String gram_name = s.substring(s.lastIndexOf('/'), s.length()-4);
			try {
				/**
				 * Parsing the syntax of the grammar
				 */
				
				Path path = new AbsolutePath(s);
				Tree tree = Parser.parse(path);
				
				/**
				 * Generating code
				 */
			/*	// Create a stream of nodes from AST built by parser
				CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
				// Tell it where it can find the token objects
				nodes.setTokenStream(Parser.getTokensStream());
				
				// Create the tree Walker for constructing the template
				Emitter walker = new Emitter(nodes);
				walker.setTemplateLib(tool.getTemplates()); // where to find templates
				// Invoke rule grammarDef
				Emitter.grammarDef_return r = walker.grammarDef(tool.getModuleName());
				
				// Emit the code
				StringTemplate output = (StringTemplate) r.getTemplate();
				tool.generateOutputFile(gram_name, output.toString());
			*/	
			} catch (RecognitionException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(s);
		}
	}
	
	public void generateOutputFile(String grammarName, String output) throws FileNotFoundException {
		String path;
		// Set the output diretory path
		if(module != null) {
			String module = language.moduleToDir(this.module);
			path = outputPath.getAbsolutePath() + "/" + module;
		} else
			path = outputPath.getAbsolutePath();
		// Create the output diretory, if necessary
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdirs();
		// Set the file name
		String file =
			path + "/" + grammarName + "Parser." + language.fileExtension();
		PrintWriter f = new PrintWriter(file);
		f.print(output);
		f.close();
	}
	
	public StringTemplateGroup getTemplates() {
		return templates;
	}
	
	public void setTemplates(String t) {
		FileReader groupFile;
		try {
			// load the specified template
			groupFile = new FileReader("./template/" + t + ".stg");
			templates = new StringTemplateGroup(groupFile);
			groupFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Path getOutputPath() {
		return outputPath;
	}
	
	public void setOutputPath(Path outputPath) {
		this.outputPath = outputPath;
	}
	
	public String getModuleName() {
		return module;
	}
	
	public void setModuleName(String module) {
		this.module = module;
	}
	
	public LangInfo getLanguage() {
		return language;
	}
	
	public void setLanguage(LangInfo lang) {
		language = lang;
	}
}
