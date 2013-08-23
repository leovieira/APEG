package fortress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GrammarDef {
	private String name;
	private List<String> nonterminals;
	private Map<String, String> rules;
	
	public GrammarDef(String name) {
		this.name = name;
		nonterminals = new ArrayList<String>();
		rules = new HashMap<String, String>();
	}
	
	public boolean addNonterminal(String name) {
		return nonterminals.add(name);
	}
	
	public String addRule(String nt, String rule) {
		if(!nonterminals.contains(nt)) {
			nonterminals.add(nt); // É um não terminal estendido de outra gramática.
		}
		return rules.put(nt, rule);
	}
	
	public List<String> getNonterminals() {
		return nonterminals;
	}
	
	public String getRule(String nonterminal) {
		return rules.get(nonterminal);
	}
	
	public String getName() {
		return name;
	}
}
