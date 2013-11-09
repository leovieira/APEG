package xml;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Util;

public class TestXML {

	private String grammar = "input/languages/XML/xml.apeg";
	private String path = "input/languages/XML/examples/";
	
	@Test
	public void testEx321gone() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "321gone.xml", "Document");
		
		assertTrue(resp == 24516);
	}
	
	@Test
	public void testExcustomer() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "customer.xml", "Document");
		
		assertTrue(resp == 515658);
	}
	
	@Test
	public void testExebay() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "ebay.xml", "Document");
		
		assertTrue(resp == 35562);
	}

	@Test
	public void testExreed() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "reed.xml", "Document");
		
		assertTrue(resp == 283655);
	}
	
	@Test
	public void testExSigmodRecord() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "SigmodRecord.xml", "Document");
		
		assertTrue(resp == 478416); // 478415?
	}
	
	@Test
	public void testExuwm() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "uwm.xml", "Document");
		
		assertTrue(resp == 2337522);
	}
	
	@Test
	public void testExwsu() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "wsu.xml", "Document");
		
		assertTrue(resp == 1647864);
	}
	
	@Test
	public void testExyahoo() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "yahoo.xml", "Document");
		
		assertTrue(resp == 25421);
	}
	
	@Test
	public void testExudid() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "ubid.xml", "Document");
		
		assertTrue(resp == 20320);
	}
}
