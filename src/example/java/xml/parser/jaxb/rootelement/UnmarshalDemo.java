package example.java.xml.parser.jaxb.rootelement;

import java.io.File;
import javax.xml.bind.*;
 
public class UnmarshalDemo {
 
    public static void main(String[] args) throws Exception {
    	// package path "example.java.xml.parser.jaxb.rootelement" should be same for both the statements 
    	// JAXBContext.newInstance("example.java.xml.parser.jaxb.rootelement") and 
    	// package example.java.xml.parser.jaxb.rootelement in package-info.java
        JAXBContext jc = JAXBContext.newInstance("example.java.xml.parser.jaxb.rootelement");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
 
        // Unmarshal Customer
        File customerXML = new File("src/example/java/xml/parser/jaxb/rootelement/customer.xml");
        Customer customer = (Customer) unmarshaller.unmarshal(customerXML);
 
        // Unmarshal Shipping Address
        File shippingXML = new File("src/example/java/xml/parser/jaxb/rootelement/shipping.xml");
        JAXBElement<AddressType> je = (JAXBElement<AddressType>) unmarshaller.unmarshal(shippingXML);
        AddressType shipping = je.getValue();
    }
 
}
