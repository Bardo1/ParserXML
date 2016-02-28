package example.java.xml.parser.jaxb.remove.jaxbfromdomain;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

	@XmlElementRefs({ @XmlElementRef(name = "billing-address"), @XmlElementRef(name = "shipping-address") })
	// removed part from previous version
	//private JAXBElement<Address> address;
	
	@XmlJavaTypeAdapter(AddressAdapter.class)
    private Address address;
 
    public Address getAddress() {
        return address;
    }
}
