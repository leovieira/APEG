package functions;

public class AdaptableFunctions {
	public static String concatN(String s, int n) {
		String resp = "";
		for(int i = 0; i < n; ++i)
			resp += s;
		return resp;
	}
}
