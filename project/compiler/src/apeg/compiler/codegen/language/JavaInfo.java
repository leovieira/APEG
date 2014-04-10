package apeg.compiler.codegen.language;

public class JavaInfo implements LangInfo {

	@Override
	public String moduleToDir(String module) {
		return module.replace('.', '/');
	}

	@Override
	public String fileExtension() {
		return "java";
	}

	@Override
	public String languageName() {
		return "Java";
	}

}
