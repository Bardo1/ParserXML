package example.java.xml.parser.jaxb.remove.jaxbfromdomain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AddressAdapter extends XmlAdapter<JAXBElement<Address>, Address> {

	@Override
	public JAXBElement<Address> marshal(Address address) throws Exception {
		return new JAXBElement<Address>(address.getQName(), Address.class, address);
	}

	@Override
	public Address unmarshal(JAXBElement<Address> jaxbElement) throws Exception {
		Address address = jaxbElement.getValue();
		address.setQName(jaxbElement.getName());
		return address;
	}
}
