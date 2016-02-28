package example.java.xml.parser.jaxb.namespace.filter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

public class XMLWithNamespaceFilter extends XMLFilterImpl {
    private static final String NAMESPACE = "http://www.example.com/customer";
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        super.endElement(NAMESPACE, localName, qName);
    }
    @Override
    public void startElement(String uri, String localName, String qName,
            Attributes atts) throws SAXException {
        super.startElement(NAMESPACE, localName, qName, atts);
    }
}

