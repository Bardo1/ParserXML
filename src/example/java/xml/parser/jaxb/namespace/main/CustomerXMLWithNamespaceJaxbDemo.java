package example.java.xml.parser.jaxb.namespace.main;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import example.java.xml.parser.jaxb.namespace.bean.Customer;

public class CustomerXMLWithNamespaceJaxbDemo {
	public static void main(String[] args) throws Exception {
		// Create the JAXBContext
		JAXBContext jc = JAXBContext.newInstance(Customer.class);

		Customer customer = new Customer();
		customer.setId(123);
		customer.setName("Jane Doe");

		// Marshal the Customer object back to XML
		Marshaller marshaller = jc.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(customer, System.out);
	}
}


//before adding namespace
/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<customer id="123">
    <name>Jane Doe</name>
</customer>*/


//@XmlSchema(namespace = "http://www.example.org/package", elementFormDefault = XmlNsForm.QUALIFIED)
/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<customer xmlns="http://www.example.org/package" id="123">
    <name>Jane Doe</name>
</customer>*/


//@XmlType(namespace="http://www.example.org/type")
/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:customer xmlns="http://www.example.org/type" xmlns:ns2="http://www.example.org/package" id="123">
    <name>Jane Doe</name>
</ns2:customer>*/


//@XmlElement(namespace="http://www.example.org/property")
/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ns2:customer xmlns="http://www.example.org/property" xmlns:ns2="http://www.example.org/package" id="123">
    <name>Jane Doe</name>
</ns2:customer>*/
