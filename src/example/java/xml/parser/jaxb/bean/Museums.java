package example.java.xml.parser.jaxb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MUSEUMS")
public class Museums {
	List<Museum> museums;

	public List<Museum> getMuseums() {
		return museums;
	}

	@XmlElement(name = "MUSEUM")
	public void setMuseums(List<Museum> museums) {
		this.museums = museums;
	}

	//In case of class generation using XML schemas definition
	//method has to be added to the generated class or to helper/util
	public void add(Museum museum) {
		if (this.museums == null) {
			this.museums = new ArrayList<Museum>();
		}
		this.museums.add(museum);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (Museum museum : this.museums) {
			str.append(museum.toString());
		}
		return str.toString();
	}
}
