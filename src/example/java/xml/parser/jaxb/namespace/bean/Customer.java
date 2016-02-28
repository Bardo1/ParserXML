package example.java.xml.parser.jaxb.namespace.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
//override the package level namespace information at the type level using the @XmlType annotation
@XmlType(namespace="http://www.example.org/type")
public class Customer {
	private long id;
	private String name;

	@XmlAttribute
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
	
    //control namespaces at the property/field level
    @XmlElement(namespace="http://www.example.org/property")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}