package xml;

import static org.junit.Assert.*;

import org.hamcrest.core.IsNot;
import org.junit.Test;

import util.Util;

public class TestGrammarXML {

	private String grammar = "input/languages/XML/xml.apeg";
	private String path = "input/languages/XML/tests/";
	
	
	@Test
	public void testDocument() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "document.txt", "Document");
		
		assertTrue(resp == 885);
	}

	@Test
	public void testNames() throws Exception {
		// Testing a namespace URI
		int resp = Util.testeGrammar(grammar, path + "namespaceURI.txt", "NamespaceURI");
		assertTrue(resp == 32);
		
		// Testing a QName
		resp = Util.testeGrammar(grammar, path + "qname_01.txt", "QName");
		assertTrue(resp == 10);
		
		resp = Util.testeGrammar(grammar, path + "qname_02.txt", "QName");
		assertTrue(resp == 44);
	}
	
	@Test
	public void testAttributes() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "attribute_01.txt", "Attribute");
		assertTrue(resp == 20);
		
		resp = Util.testeGrammar(grammar, path + "attribute_02.txt", "Attribute");
		assertTrue(resp == 60);
	}
	
	@Test
	public void testCommentsAndSpace() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "comment.txt", "Comment");
		assertTrue(resp == 42);
	}
	
	@Test
	public void testCharData() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "char_data.txt", "CharData");
		assertTrue(resp == 72);
		
		resp = Util.testeGrammar(grammar, path + "char_data_fail_01.txt", "CharData");
		assertTrue(resp == 31); // it consumes the prefix until the & symbol
		
		resp = Util.testeGrammar(grammar, path + "char_data_fail_02.txt", "CharData");
		assertTrue(resp == 38); // it consumes the prefix until the < symbol
	}
	
	@Test
	public void testRef() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "ref_01.txt", "Ref");
		assertTrue(resp == 9);
		resp = Util.testeGrammar(grammar, path + "ref_02.txt", "Ref");
		assertTrue(resp == 5);
	}
	
	@Test
	public void testDataSection() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "data_section.txt", "CDataSection");
		assertTrue(resp == 27);
	}
	
	@Test
	public void testPI() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "pi.txt", "PI");
		assertTrue(resp == 30);
	}
	
	@Test
	public void testXML_Decl() throws Exception {
		int resp = Util.testeGrammar(grammar, path + "xml_decl.txt", "XMLDecl");
		assertTrue(resp == 69);
	}
	
	@Test
	public void testElement() throws Exception {
		// Testing empty elements
		int resp = Util.testeGrammar(grammar, path + "element_01.txt", "Element");
		assertTrue(resp == 13);
		
		resp = Util.testeGrammar(grammar, path + "element_02.txt", "Element");
		assertTrue(resp == 134);
		
		// Testing a non empty element
		resp = Util.testeGrammar(grammar, path + "element_03.txt", "Element");
		assertTrue(resp == 694);
	}
}
