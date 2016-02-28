package example.java.xml.parser.jaxb.rootelement;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlRegistry
public class ObjectFactory {

	private final static QName _BillingAddress_QNAME = new QName("http://www.example.org/customer", "billing-address");
	private final static QName _ShippingAddress_QNAME = new QName("http://www.example.org/customer",
			"shipping-address");

	public ObjectFactory() {
	}

	public Customer createCustomer() {
		return new Customer();
	}

	public AddressType createAddressType() {
		return new AddressType();
	}

	@XmlElementDecl(namespace = "http://www.example.org/customer", name = "billing-address")
	public JAXBElement<AddressType> createBillingAddress(AddressType value) {
		return new JAXBElement<AddressType>(_BillingAddress_QNAME, AddressType.class, null, value);
	}

	@XmlElementDecl(namespace = "http://www.example.org/customer", name = "shipping-address")
	public JAXBElement<AddressType> createShippingAddress(AddressType value) {
		return new JAXBElement<AddressType>(_ShippingAddress_QNAME, AddressType.class, null, value);
	}

}
