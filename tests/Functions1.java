import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class Functions1 {

	public static int add(int i, int j) {
		return i+j;
	}
	
	public static void main(String[] args) throws Exception {
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
	}

}
