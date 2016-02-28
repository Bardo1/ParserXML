package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Country2;
import example.java.xml.parser.jaxb.bean.State;

public class Country2JAXBJavaToXml {
	public static void main(String[] args) {

		// creating country object
		Country2 countryIndia = new Country2();
		countryIndia.setCountryName("India");
		countryIndia.setCountryPopulation(5000000);

		// Creating listOfStates
		ArrayList<State> stateList = new ArrayList<State>();
		State mpState = new State("Madhya Pradesh", 1000000);
		stateList.add(mpState);
		State maharastraState = new State("Maharastra", 2000000);
		stateList.add(maharastraState);

		countryIndia.setListOfStates(stateList);

		try {

			// create JAXB context and initializing Marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(Country2.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// for getting nice formatted output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			// specify the location and name of xml file to be created
			File XMLfile = new File("src/example/java/xml/parser/jaxb/xml/country2.xml");

			// Writing to XML file
			jaxbMarshaller.marshal(countryIndia, XMLfile);
			// Writing to console
			jaxbMarshaller.marshal(countryIndia, System.out);

		} catch (JAXBException e) {
			// some exception occured
			e.printStackTrace();
		}

	}
}
