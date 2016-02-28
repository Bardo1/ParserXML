package example.java.xml.parser.jaxb.main;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;

import example.java.xml.parser.jaxb.bean.Customer;

public class CustomerJAXBNoAnnotationDemo {
	public static void main(String[] args) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Customer.class);
		StreamSource xml = new StreamSource("src/example/java/xml/parser/jaxb/xml/no-annotation.xml");
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		JAXBElement<Customer> je1 = unmarshaller.unmarshal(xml, Customer.class);
		Customer customer = je1.getValue();
		JAXBElement<Customer> je2 = new JAXBElement<Customer>(new QName(
				"customer"), Customer.class, customer);
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(je2, System.out);
	}
}
