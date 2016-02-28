package example.java.xml.parser.jaxb.binding.xmltojson;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"name", "emailAddresses"})
public class CustomerXMLToJSON {
    private String name;
    private List<String> emailAddresses = new ArrayList<String>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @XmlElementWrapper(name="email-addresses")
    @XmlElement(name="email-address")
    public List<String> getEmailAddresses() {
        return emailAddresses;
    }
    public void setEmailAddresses(List<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }
}
