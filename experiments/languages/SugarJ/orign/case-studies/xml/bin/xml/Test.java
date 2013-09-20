package xml;
import java.util.StringTokenizer;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class Test extends DefaultHandler 
{ 
  public static void main(String[] args) throws SAXException
  { 
    ContentHandler ch = new Test();
    { 
      ch.startDocument();
      { 
        org.xml.sax.helpers.AttributesImpl t_3422 = new org.xml.sax.helpers.AttributesImpl();
        { 
          t_3422.addAttribute("", "targetNamespace", "targetNamespace", "CDATA", "http://www.w3.org/2001/XMLSchema" + "");
          t_3422.addAttribute("", "blockDefault", "blockDefault", "CDATA", "#all" + "");
          t_3422.addAttribute("", "elementFormDefault", "elementFormDefault", "CDATA", "qualified" + "");
          t_3422.addAttribute("", "version", "version", "CDATA", "1.0" + "");
        }
        ch.startElement("", "schema", "xsd:schema", t_3422);
        { 
          { 
            org.xml.sax.helpers.AttributesImpl s_3422 = new org.xml.sax.helpers.AttributesImpl();
            { 
              s_3422.addAttribute("", "name", "name", "CDATA", "derivationSet" + "");
            }
            ch.startElement("http://www.w3.org/2001/XMLSchema", "simpleType", "{http://www.w3.org/2001/XMLSchema}simpleType", s_3422);
            { 
              { 
                org.xml.sax.helpers.AttributesImpl l_3422 = new org.xml.sax.helpers.AttributesImpl();
                { }
                ch.startElement("", "annotation", "annotation", l_3422);
                { 
                  { 
                    org.xml.sax.helpers.AttributesImpl j_3422 = new org.xml.sax.helpers.AttributesImpl();
                    { }
                    ch.startElement("", "documentation", "documentation", j_3422);
                    { 
                      { 
                        ch.characters(new char[]{'A', ' ', 'u', 't', 'i', 'l', 'i', 't', 'y', ' ', 't', 'y', 'p', 'e', ',', ' ', 'n', 'o', 't', ' ', 'f', 'o', 'r', ' ', 'p', 'u', 'b', 'l', 'i', 'c', ' ', 'u', 's', 'e', '\n', '	', '	', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, 0, 46);
                      }
                    }
                    ch.endElement("", "documentation", "documentation");
                  }
                  { 
                    org.xml.sax.helpers.AttributesImpl k_3422 = new org.xml.sax.helpers.AttributesImpl();
                    { }
                    ch.startElement("", "documentation", "documentation", k_3422);
                    { 
                      { 
                        ch.characters(new char[]{'#', 'a', 'l', 'l', ' ', 'o', 'r', ' ', '(', 'p', 'o', 's', 's', 'i', 'b', 'l', 'y', ' ', 'e', 'm', 'p', 't', 'y', ')', ' ', 's', 'u', 'b', 's', 'e', 't', ' ', 'o', 'f', ' ', '{', 'e', 'x', 't', 'e', 'n', 's', 'i', 'o', 'n', ',', ' ', 'r', 'e', 's', 't', 'r', 'i', 'c', 't', 'i', 'o', 'n', '}', '\n', '	', '	', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}, 0, 71);
                      }
                    }
                    ch.endElement("", "documentation", "documentation");
                  }
                }
                ch.endElement("", "annotation", "annotation");
              }
              { 
                org.xml.sax.helpers.AttributesImpl r_3422 = new org.xml.sax.helpers.AttributesImpl();
                { }
                ch.startElement("", "union", "union", r_3422);
                { 
                  { 
                    org.xml.sax.helpers.AttributesImpl o_3422 = new org.xml.sax.helpers.AttributesImpl();
                    { }
                    ch.startElement("", "simpleType", "simpleType", o_3422);
                    { 
                      { 
                        org.xml.sax.helpers.AttributesImpl n_3422 = new org.xml.sax.helpers.AttributesImpl();
                        { 
                          n_3422.addAttribute("", "base", "base", "CDATA", "token" + "");
                        }
                        ch.startElement("", "restriction", "restriction", n_3422);
                        { 
                          { 
                            org.xml.sax.helpers.AttributesImpl m_3422 = new org.xml.sax.helpers.AttributesImpl();
                            { 
                              m_3422.addAttribute("", "value", "value", "CDATA", "#all" + "");
                            }
                            ch.startElement("", "enumeration", "enumeration", m_3422);
                            ch.endElement("", "enumeration", "enumeration");
                          }
                        }
                        ch.endElement("", "restriction", "restriction");
                      }
                    }
                    ch.endElement("", "simpleType", "simpleType");
                  }
                  { 
                    org.xml.sax.helpers.AttributesImpl q_3422 = new org.xml.sax.helpers.AttributesImpl();
                    { }
                    ch.startElement("", "simpleType", "simpleType", q_3422);
                    { 
                      { 
                        org.xml.sax.helpers.AttributesImpl p_3422 = new org.xml.sax.helpers.AttributesImpl();
                        { 
                          p_3422.addAttribute("", "itemType", "itemType", "CDATA", "reducedDerivationControl" + "");
                        }
                        ch.startElement("", "list", "list", p_3422);
                        ch.endElement("", "list", "list");
                      }
                    }
                    ch.endElement("", "simpleType", "simpleType");
                  }
                }
                ch.endElement("", "union", "union");
              }
            }
            ch.endElement("http://www.w3.org/2001/XMLSchema", "simpleType", "{http://www.w3.org/2001/XMLSchema}simpleType");
          }
        }
        ch.endElement("", "schema", "xsd:schema");
      }
      ch.endDocument();
    }
  }

  private int indentation = 0;

  public void startElement(String namespaceUri, String localName, String qualifiedName, Attributes attributes) throws SAXException
  { 
    indent(indentation);
    System.out.print("<" + qualifiedName);
    int numAttributes = attributes.getLength();
    if(numAttributes > 0)
    { 
      System.out.print(" ");
      for(int i = 0; i < numAttributes; i++)
      { 
        if(i > 0)
        { 
          System.out.print(" ");
        }
        System.out.print(attributes.getQName(i) + "=\"" + attributes.getValue(i) + "\"");
      }
    }
    System.out.println(">");
    indentation = indentation + 2;
  }

  public void endElement(String namespaceUri, String localName, String qualifiedName) throws SAXException
  { 
    indentation = indentation - 2;
    indent(indentation);
    System.out.println("</" + qualifiedName + ">");
  }

  public void characters(char[] chars, int startIndex, int endIndex)
  { 
    String data = new String(chars, startIndex, endIndex);
    StringTokenizer st = new StringTokenizer(data, "\n");
    while(st.hasMoreTokens())
    { 
      indent(indentation);
      System.out.println(st.nextToken());
    }
  }

  private void indent(int indentation)
  { 
    for(int i = 0; i < indentation; i++)
    { 
      System.out.print(" ");
    }
  }
}