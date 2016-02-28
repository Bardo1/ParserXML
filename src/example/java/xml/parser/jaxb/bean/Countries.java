package example.java.xml.parser.jaxb.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Countries")
public class Countries {
	List<Country> countries;

	public List<Country> getCountries() {
		return countries;
	}

	@XmlElement(name = "Country")
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public void add(Country country) {
		if (this.countries == null) {
			this.countries = new ArrayList<Country>();
		}
		this.countries.add(country);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		for (Country museum : this.countries) {
			str.append(museum.toString());
		}
		return str.toString();
	}
}
