package runtime.memoization;

import java.util.HashMap;


/**
 * This class stores the intermediates computations in executions of a APEG
 * @author leo
 *
 */
public class Memoization {
	
	HashMap<Entry,Result> map;
	
	public Memoization() {
		map = new HashMap<Entry, Result>();
	}
}
