package example.java.xml.parser.jaxb.remove.jaxbfromdomain;

import javax.xml.bind.annotation.*;
import javax.xml.namespace.QName;

@XmlAccessorType(XmlAccessType.FIELD)
public class Address {

	@XmlTransient
	private QName qName;
	private String street;
	private String city;

	public QName getQName() {
		return qName;
	}

	public void setQName(QName name) {
		this.qName = name;
	}

}
