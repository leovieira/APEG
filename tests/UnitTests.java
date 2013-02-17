
import util.Util;
import static org.junit.Assert.*;
import org.junit.Test;

public class UnitTests {

	@Test
	public void Test01() {
		try {
			int resp = Util.testeGrammar("input/teste01.txt", "input/teste01_input.txt", "literal");
			assertEquals(24, resp);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}

	@Test
	public void Test02_1() {
		try {
			int resp = Util.testeGrammar("input/teste02.txt", "input/teste02_input.txt", "S1");
			assertEquals(9, resp);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}

	@Test
	public void Test02_2() {
		try {
			int resp = Util.testeGrammar("input/teste02.txt", "input/teste02_input.txt", "S2");
			assertEquals(9, resp);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}

	@Test
	public void Test03() {
		try {
			Object args3[] = new Object[3];
			args3[0] = 1; args3[1] = 2;
			int resp = Util.testeGrammar("input/teste03.txt", "input/teste03_input.txt", "teste", args3);
			System.out.println("Return value(s) = " + args3[2]);
			assertEquals(6, resp);
			assertEquals(args3[2], 3);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void Test04() {
		try {
			int resp = Util.testeGrammar("input/teste04.txt", "input/teste04_input.txt", "root");
			assertEquals(11, resp);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void Test05() {
		try {
			int resp = Util.testeGrammar("input/teste05.txt", "input/teste05_input.txt", "root");;
			assertEquals(5, resp);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void Test06_1() {
		try {
			int resp = Util.testeGrammar("input/teste06.txt", "input/teste06_input.txt", "literal3");
			assertEquals(37, resp);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void Test06_2() {
		try {
			int resp = Util.testeGrammar("input/teste06a.txt", "input/teste06_input.txt", "literal3");
			assertEquals(37, resp);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void Test06_3() {
		try {
			Object args6[] = new Object[1];
			int resp = Util.testeGrammar("input/teste06b.txt", "input/teste06_input.txt", "literal3", args6);
			assertEquals(37, resp);
			System.out.println("Return value(s) = " + args6[0]);
			assertEquals(args6[0], 27);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void Test06_4() {
		try {
			Object args6[] = new Object[1];
			int resp = Util.testeGrammar("input/teste06b.txt", "input/teste06_input2.txt", "literal", args6);
			assertEquals(1006, resp);
			System.out.println("Return value(s) = " + args6[0]);
			assertEquals(args6[0], 1000);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void Test07_1() {
		try {
			int resp = Util.testeGrammar("input/teste07.txt", "input/teste07_input.txt", "block");
			assertEquals(resp, 22);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
		
	@Test
	public void Test07_2() {
		try {
			int resp = Util.testeGrammar("input/teste07a.txt", "input/teste07_input.txt", "block");
			assertEquals(resp, 22);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}
	
	@Test
	public void Test08() {
		try {
			Object args8[] = new Object[1];
			int resp = Util.testeGrammar("input/teste08.txt", "input/teste08_input.txt", "name", args8);
			assertEquals(resp, 5);
			System.out.println("Return value(s) = " + args8[0]);
			assertEquals(args8[0], "teste");
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}

	@Test
	public void Test09_1() {
		try {
			Object args9_1[] = new Object[1];
			int resp = Util.testeGrammar("input/teste09.txt", "input/teste09_input.txt", "a", args9_1);
			assertEquals(resp, 1);
			System.out.println("Return value(s) = " + args9_1[0]);
			assertEquals(args9_1[0], 3);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}

	@Test
	public void Test09_2() {
		try {
			Object args9_1[] = new Object[1];
			int resp = Util.testeGrammar("input/teste09a.txt", "input/teste09_input.txt", "a", args9_1);
			assertEquals(resp, 1);
			System.out.println("Return value(s) = " + args9_1[0]);
			assertEquals(args9_1[0], 1);
		} catch (Exception e) {
			System.out.println(e);
			assertTrue(false);
		}
	}

	
}
