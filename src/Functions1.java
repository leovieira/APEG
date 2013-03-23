import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class Functions1 {

	public static int add(int i, int j) {
		return i+j;
	}
		
	public static void main(String[] args) throws Exception {
		/*
		Class c = Class.forName("Functions1");
		for (Method m : c.getDeclaredMethods()) {
			if (!m.getName().equals("main") && Modifier.isStatic(m.getModifiers())) {
				System.out.println(m);
				Object x = m.invoke(null, new Integer(1), 2);
				System.out.println(x);
				Object array[] = new Object[2];
				array[0] = 1;
				array[1] = 2;
				x = m.invoke(null, array);
				System.out.println(x);
			}
		}
		*/
		
		TesteHash t1 = new TesteHash();
		TesteHash t2 = new TesteHash();
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t1.equals(t2));
		System.out.println(t1.args.hashCode());
		System.out.println(t2.args.hashCode());
		System.out.println(t1.args.equals(t2.args));
		String s1 = new String("abc");
		String s2 = "a"; String s3 = "bc"; String s4 = s2 + s3;
		System.out.println(s1.hashCode());
		System.out.println(s4.hashCode());
		System.out.println(s1.equals(s4));
		TesteHash2 x1 = new TesteHash2();
		x1.args[0] = 0;
		x1.args[1] = 1;
		x1.args[2] = s1;
		TesteHash2 x2 = new TesteHash2();
		x2.args[0] = 0;
		x2.args[1] = 1;
		x2.args[2] = s4;
		System.out.println(x1.hashCode());
		System.out.println(x2.hashCode());
		System.out.println(x1.equals(x2));
	}

}

class TesteHash {
	Object args[];
	TesteHash() { args = new Object[3]; }
}


class TesteHash2 {
	Object args[];
	TesteHash2() { args = new Object[3]; }
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (Object x : args) {
			if (x != null) {
				result = prime * result + x.hashCode();				
			}
		}
		return result;
	}
	public boolean equals(Object other) {
		if (! (other instanceof TesteHash2)) {
			return false;
		}
		TesteHash2 o = (TesteHash2) other;
		if (args.length != o.args.length) {
			return false;
		}
		for (int i = 0; i < args.length; ++ i) {
			if (args[i] == null) {
				if (o.args[i] != null) {
					return false;
				}
			} else if (o.args[i] == null) {
				return false;
			} else if (! args[i].equals(o.args[i])) {
				return false;
			}
		}
		return true;
	}
	
}

