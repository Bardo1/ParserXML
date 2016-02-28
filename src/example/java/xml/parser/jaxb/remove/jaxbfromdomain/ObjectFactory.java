package example.java.xml.parser.jaxb.remove.jaxbfromdomain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

	static final String BILLING_ADDRESS = "billing-address";
	static final String SHIPPING_ADDRESS = "shipping-address";

	@XmlElementDecl(name = BILLING_ADDRESS)
	public JAXBElement<Address> createBillingAddress(Address address) {
		return new JAXBElement<Address>(new QName(BILLING_ADDRESS), Address.class, address);
	}

	@XmlElementDecl(name = SHIPPING_ADDRESS)
	public JAXBElement<Address> createShippingAddress(Address address) {
		return new JAXBElement<Address>(new QName(SHIPPING_ADDRESS), Address.class, address);
	}

}
