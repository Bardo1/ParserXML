package example.java.xml.parser.jaxb.rootelement;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "address-type", propOrder = { "street" })
public class AddressType {

	@XmlElement(required = true)
	protected String street;

	public String getStreet() {
		return street;
	}

	public void setStreet(String value) {
		this.street = value;
	}

}
