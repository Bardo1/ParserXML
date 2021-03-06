package example.java.xml.parser.jaxb.rootelement;

import java.io.File;
import javax.xml.bind.*;
 
public class JAXBIntrospectorDemo {
 
    public static void main(String[] args) throws Exception {
    	// package path "example.java.xml.parser.jaxb.rootelement" should be same for both the statements 
    	// JAXBContext.newInstance("example.java.xml.parser.jaxb.rootelement") and 
    	// package example.java.xml.parser.jaxb.rootelement in package-info.java
        JAXBContext jc = JAXBContext.newInstance("example.java.xml.parser.jaxb.rootelement");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
 
        // Unmarshal Customer
        File customerXML = new File("src/example/java/xml/parser/jaxb/rootelement/customer.xml");
        Customer customer = (Customer) JAXBIntrospector.getValue(unmarshaller
                .unmarshal(customerXML));
 
        // Unmarshal Shipping Address
        File shippingXML = new File("src/example/java/xml/parser/jaxb/rootelement/shipping.xml");
        AddressType shipping = (AddressType) JAXBIntrospector
                .getValue(unmarshaller.unmarshal(shippingXML));
    }
 
}
