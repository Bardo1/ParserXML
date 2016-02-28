package example.java.xml.parser.jaxb.remove.jaxbfromdomain;

import java.io.File;
import javax.xml.bind.*;
import javax.xml.namespace.QName;

public class CustomerJaxbEltRemoveFromDomainDemo {

	public static void main(String[] args) throws Exception {
		JAXBContext jc = JAXBContext.newInstance(Customer.class, ObjectFactory.class);

		Unmarshaller u = jc.createUnmarshaller();
		File xml = new File("src/example/java/xml/parser/jaxb/remove/jaxbfromdomain/remove-jaxb-from-domain.xml");
		Customer customer = (Customer) u.unmarshal(xml);

		// Change the Wrapper Element
		customer.getAddress().setQName(new QName(ObjectFactory.SHIPPING_ADDRESS));

		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(customer, System.out);
	}
}

/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<customer>
    <shipping-address>
        <street>123 A Street</street>
        <city>Any Town</city>
    </shipping-address>
</customer>*/
