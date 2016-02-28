package example.java.xml.parser.jaxb.rootelement;

import javax.xml.bind.*;

public class MarshalDemo {
 
    public static void main(String[] args) throws Exception {
    	// package path "example.java.xml.parser.jaxb.rootelement" should be same for both the statements 
    	// JAXBContext.newInstance("example.java.xml.parser.jaxb.rootelement") and 
    	// package example.java.xml.parser.jaxb.rootelement in package-info.java
        JAXBContext jc = JAXBContext.newInstance("example.java.xml.parser.jaxb.rootelement");
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
        // Create Domain Objects
        AddressType billingAddress = new AddressType();
        billingAddress.setStreet("1 Any Street");
        Customer customer = new Customer();
        customer.setBillingAddress(billingAddress);
 
        // Marshal Customer
        marshaller.marshal(customer, System.out);
 
        // Marshal Billing Address
        ObjectFactory objectFactory = new ObjectFactory();
        JAXBElement<AddressType> je =  objectFactory.createBillingAddress(billingAddress);
        marshaller.marshal(je, System.out);
    }
 
}

/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<customer xmlns="http://www.example.org/customer">
    <billing-address>
        <street>1 Any Street</street>
    </billing-address>
</customer>
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<billing-address xmlns="http://www.example.org/customer">
    <street>1 Any Street</street>
</billing-address>*/
