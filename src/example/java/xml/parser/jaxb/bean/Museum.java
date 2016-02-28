package example.java.xml.parser.jaxb.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//indicates the root node and the name is the name that will appear in XML 
//if no name is specified, the class name will be used
@XmlRootElement(name = "MUSEUM")
//represents the order of attributes in the generated XML using annotation XmlType
@XmlType(propOrder = { "name", "city", "permanent", "special" })
public class Museum {
	String name;
	Boolean childrenAllowed;
	Exhibition special;
	Exhibition permanent;
	private String city;

	public String getName() {
		return name;
	}

	//indicates a child node
	@XmlElement(name = "MUSEUM_NAME")
	public void setName(String name) {
		this.name = name;
	}

	public Boolean getChildrenAllowed() {
		return childrenAllowed;
	}

	//indicates an attribute of the root node
	@XmlAttribute(name = "children_allowed", required = true)
	public void setChildrenAllowed(Boolean childrenAllowed) {
		this.childrenAllowed = childrenAllowed;
	}

	public Exhibition getSpecial() {
		return special;
	}

	@XmlElement(name = "SPECIAL_EXHIBITION")
	public void setSpecial(Exhibition special) {
		this.special = special;
	}

	public Exhibition getPermanent() {
		return permanent;
	}

	@XmlElement(name = "PERMANENT_EXHIBITION")
	public void setPermanent(Exhibition permanent) {
		this.permanent = permanent;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@XmlElement(name = "CITY")
	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("Name: " + getName() + "\n");
		str.append("City: " + getCity() + "\n");

		if (getChildrenAllowed() != null && !getChildrenAllowed()) {
			str.append("ATTENTION! Children are not allowed in this museum\n");
		}
		if (getPermanent() != null) {
			str.append(getPermanent().toString());
		}
		if (getSpecial() != null) {
			str.append(getSpecial().toString());
		}
		str.append("\n");
		return str.toString();
	}
}
