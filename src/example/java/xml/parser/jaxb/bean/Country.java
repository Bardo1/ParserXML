package example.java.xml.parser.jaxb.bean;

import java.time.LocalDate;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import example.java.xml.parser.jaxb.adapter.DateLocalAdapter;

@XmlRootElement(name = "Country")
@XmlType(propOrder = { "name", "capital", "foundation", "continent", "population" })
public class Country {
	String name;
	String capital;
	LocalDate foundation;
	//Date foundation;
	String continent;
	int population;

	public int getPopulation() {
		return population;
	}

	@XmlElement(name = "Country_Population")
	public void setPopulation(int population) {
		this.population = population;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "Country_Name")
	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	@XmlElement(name = "Country_Capital")
	public void setCapital(String capital) {
		this.capital = capital;
	}

	public LocalDate getFoundation() {
	//public Date getFoundation() {
		return foundation;
	}

	@XmlElement(name = "Country_Foundation_Date")
	@XmlJavaTypeAdapter(DateLocalAdapter.class)
	public void setFoundation(LocalDate foundation) {
	//public void setFoundation(Date foundation) {
		this.foundation = foundation;
	}

	public String getContinent() {
		return continent;
	}

	@XmlElement(name = "Country_Continent")
	public void setContinent(String continent) {
		this.continent = continent;
	}
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer("Country [Name: " + getName() + ", ");
		str.append("Capital: " + getCapital() + ", ");
		if (getFoundation() != null) {
			str.append("Foundation: " + getFoundation().toString() + ", ");
		}
		if (getContinent() != null) {
			str.append("Continent: " + getContinent().toString());
			str.append("]\n");
		}
		return str.toString();
	}
}
