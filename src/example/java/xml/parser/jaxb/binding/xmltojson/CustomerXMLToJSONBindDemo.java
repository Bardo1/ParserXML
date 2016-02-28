//not working since beginning

package example.java.xml.parser.jaxb.binding.xmltojson;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.MarshallerProperties;

public class CustomerXMLToJSONBindDemo {
	public static void main(String[] args) throws Exception {
		CustomerXMLToJSON customer = new CustomerXMLToJSON();
        customer.setName("Jane Doe");
        customer.getEmailAddresses().add("jane.doe@example.com");
        customer.getEmailAddresses().add("jdoe@example.org");
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(MarshallerProperties.JSON_WRAPPER_AS_ARRAY_NAME, true);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {CustomerXMLToJSON.class}, properties);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // Output XML
        marshaller.marshal(customer, System.out);
        // Output JSON
        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.marshal(customer, System.out);
    }
}
