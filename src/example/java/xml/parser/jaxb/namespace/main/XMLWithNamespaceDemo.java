// not working since beginning
package example.java.xml.parser.jaxb.namespace.main;

import javax.xml.bind.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

import example.java.xml.parser.jaxb.namespace.bean.Customer;
import example.java.xml.parser.jaxb.namespace.filter.XMLWithNamespaceFilter;

public class XMLWithNamespaceDemo {
	public static void main(String[] args) throws Exception {
		// Create the JAXBContext
		JAXBContext jc = JAXBContext.newInstance(Customer.class);

		// Create the XMLFilter
		XMLFilter filter = new XMLWithNamespaceFilter();
		// Set the parent XMLReader on the XMLFilter
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		XMLReader xr = sp.getXMLReader();
		filter.setParent(xr);

		// Set UnmarshallerHandler as ContentHandler on XMLFilter
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
		filter.setContentHandler(unmarshallerHandler);

		// Parse the XML
		InputSource xml = new InputSource("src/example/java/xml/parser/jaxb/namespace/xml/namespace.xml");
		filter.parse(xml);
		Customer customer = (Customer) unmarshallerHandler.getResult();

		// Marshal the Customer object back to XML
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(customer, System.out);
	}
}
