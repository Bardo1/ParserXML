package example.java.xml.parser.jaxb.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//defines root element of XML file
@XmlRootElement
//optional; define order of elements in XML file
@XmlType(propOrder = { "countryName", "countryPopulation", "listOfStates" })
public class Country2 {

	private String countryName;
	private double countryPopulation;

	private ArrayList<State> listOfStates;

	public Country2() {
	}

	public String getCountryName() {
		return countryName;
	}

	//define element in XML file and sets name of entity
	@XmlElement
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public double getCountryPopulation() {
		return countryPopulation;
	}

	@XmlElement
	public void setCountryPopulation(double countryPopulation) {
		this.countryPopulation = countryPopulation;
	}

	public ArrayList<State> getListOfStates() {
		return listOfStates;
	}

	//generate a wrapper element around XML representation i.e. 
	//generate <stateList> around each <state> element
	@XmlElementWrapper(name = "stateList")
	//sets the name of the entities in collection
	@XmlElement(name = "State")
	public void setListOfStates(ArrayList<State> listOfStates) {
		this.listOfStates = listOfStates;
	}

}
