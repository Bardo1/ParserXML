package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.System.out;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import example.java.xml.parser.jaxb.bean.Countries;
import example.java.xml.parser.jaxb.bean.Country;
import example.java.xml.parser.jaxb.bean.Country2;
import example.java.xml.parser.jaxb.bean.State;
import example.java.xml.parser.jaxb.errorHandler.CountryErrorHandler;
import example.java.xml.parser.jaxb.validationEventHandler.CountryValidationEventHandler;

public class CountriesJAXBMain {
	
	public static void main(String[] args) throws PropertyException, JAXBException, SAXException {
		
		new CountriesJAXBMain().marshalCountry();
		new CountriesJAXBMain().marshal_Country();
		
		new CountriesJAXBMain().marshalCountry2JavaToXml();
		new CountriesJAXBMain().unmarshalCountry2XmlToJava();
		
		new CountriesJAXBMain().marshalCountries();
		new CountriesJAXBMain().unmarshalCountries();
		
		new CountriesJAXBMain().validationXsdSchemaCountry();
		new CountriesJAXBMain().validationEventHandlerSchemaCountry();
		new CountriesJAXBMain().validationSchemaErrorHandlerCountry();
		
	}
	
	
	private void marshalCountry(){
		out.println("\n\nMarshal of Country");
		try {
			Country spain = new Country();
			spain.setName("Spain");
			spain.setCapital("Madrid");
			spain.setContinent("Europe");
			spain.setFoundation(LocalDate.of(1469, 10, 19));
			//spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));
			spain.setPopulation(45000000);

			// initialize jaxb marshaler
			JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// set JAXB_FORMATTED_OUTPUT flag to true to format the output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Marshal Java objects in XML (output to file and standard output)
			jaxbMarshaller.marshal(spain, new File("src/example/java/xml/parser/jaxb/xml/country.xml"));
			jaxbMarshaller.marshal(spain, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	private void marshal_Country(){
		out.println("\n\nMarshal of Country...");
		try {
			Country country = new Country();
			country.setName("Spain");
			country.setCapital("Madrid");
			country.setContinent("Europe");

			country.setFoundation(LocalDate.of(1469, 10, 19));
			//country.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));
			//country.setFoundation(Calendar.getInstance().getTime());

			JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshal java objects with complex classes java.time.LocalDate into XML file and console output
			jaxbMarshaller.marshal(country, new File("src/example/java/xml/parser/jaxb/xml/country_adapter.xml"));
			jaxbMarshaller.marshal(country, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	private void marshalCountry2JavaToXml(){
		out.println("\n\nMarshal of Country2");
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
			e.printStackTrace();
		}
	}
	
	
	private void unmarshalCountry2XmlToJava(){
		out.println("\n\nUnmarshal of Country2");
		try {
			// create JAXB context and initializing Marshaller
			JAXBContext jaxbContext = JAXBContext.newInstance(Country2.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			// specify the location and name of xml file to be read
			File XMLfile = new File("src/example/java/xml/parser/jaxb/xml/country2.xml");

			// this will create Java object - country from the XML file
			Country2 countryIndia = (Country2) jaxbUnmarshaller.unmarshal(XMLfile);

			System.out.println("Country Name: " + countryIndia.getCountryName());
			System.out.println("Country Population: " + countryIndia.getCountryPopulation());

			ArrayList<State> listOfStates = countryIndia.getListOfStates();

			int i = 0;
			for (State state : listOfStates) {
				i++;
				System.out.println("State:" + i + " " + state.getStateName());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	
	private void marshalCountries(){
		out.println("\n\nMarshal of Countries");
		try {
			Country spain = new Country();
			spain.setName("Spain");
			spain.setCapital("Madrid");
			spain.setContinent("Europe");

			spain.setFoundation(LocalDate.of(1469, 10, 19));
			//spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));

			Country usa = new Country();
			usa.setName("USA");
			usa.setCapital("Washington");
			usa.setContinent("America");

			usa.setFoundation(LocalDate.of(1776, 7, 4));
			//usa.setFoundation(Calendar.getInstance().getTime());

			Countries countries = new Countries();
			countries.add(spain);
			countries.add(usa);

			JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshaling of java objects in xml file and console output
			jaxbMarshaller.marshal(countries, new File("src/example/java/xml/parser/jaxb/xml/list_countries.xml"));
			jaxbMarshaller.marshal(countries, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	private void unmarshalCountries(){
		out.println("\n\nUnmarshal of Countries");
		try {
			File file = new File("src/example/java/xml/parser/jaxb/xml/countries.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Countries countres = (Countries) jaxbUnmarshaller.unmarshal(file);
			out.println(countres);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	// http://www.w3schools.com/schema/schema_example.asp
	// http://blog.bdoughan.com/2010/12/jaxb-and-marshalunmarshal-schema.html
	private void validationXsdSchemaCountry() throws PropertyException, JAXBException, SAXException {
		out.println("\n\nValidation using Xsd or Schema");
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setContinent("Europe");
		spain.setFoundation(LocalDate.of(1469, 10, 19));
		//spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));
		spain.setPopulation(45000000);

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("src/example/java/xml/parser/jaxb/xml/countries.xsd"));

		JAXBContext jaxbContext = null;
		Marshaller marshaller = null;
		jaxbContext = JAXBContext.newInstance(Country.class);
		marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setSchema(schema);
		marshaller.marshal(spain, System.out);
	}
	
	
	private void validationEventHandlerSchemaCountry() throws PropertyException, JAXBException, SAXException {
		out.println("\n\nXSDs for marshaling of the objects with validation");

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("src/example/java/xml/parser/jaxb/xml/countries_validation.xsd"));

		JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		marshaller.setSchema(schema);
		// the schema uses a validation handler to validate the objects
		marshaller.setEventHandler(new CountryValidationEventHandler());
		
		// validation will fail because continent is mandatory
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setFoundation(LocalDate.of(1469, 10, 19));
		//spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));
		try {
			marshaller.marshal(spain, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		// continent is wrong and validation will fail
		Country australia = new Country();
		australia.setName("Australia");
		australia.setCapital("Camberra");
		australia.setFoundation(LocalDate.of(1788, 01, 26));
		//australia.setFoundation(Calendar.getInstance().getTime());
		australia.setContinent("Australia");
		try {
			marshaller.marshal(australia, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		// finally everything ok
		australia = new Country();
		australia.setName("Australia");
		australia.setCapital("Camberra");
		australia.setFoundation(LocalDate.of(1788, 01, 26));
		//australia.setFoundation(Calendar.getInstance().getTime());
		australia.setContinent("Oceania");
		try {
			marshaller.marshal(australia, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	private void validationSchemaErrorHandlerCountry() throws PropertyException, JAXBException, SAXException {
		out.println("\n\nValidation using XSD and an error handler");
		
		// error will be thrown because continent is mandatory
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setFoundation(LocalDate.of(1469, 10, 19));
		//spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));

		// ok
		Country australia = new Country();
		australia.setName("Australia");
		australia.setCapital("Camberra");
		australia.setFoundation(LocalDate.of(1788, 01, 26));
		//australia.setFoundation(Calendar.getInstance().getTime());
		australia.setContinent("Oceania");

		// schema is created
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("src/example/java/xml/parser/jaxb/xml/countries_validation.xsd"));
		
		// context is created and used to create sources for each country
		JAXBContext jaxbContext;
		JAXBSource sourceSpain = null;
		JAXBSource sourceAustralia = null;
		
		jaxbContext = JAXBContext.newInstance(Country.class);
		sourceSpain = new JAXBSource(jaxbContext, spain);
		sourceAustralia = new JAXBSource(jaxbContext, australia);
		
		// validator is initialized
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new CountryErrorHandler());

		// validator is used
		try {
			validator.validate(sourceSpain);
			out.println("spain has no problems");
		} catch (SAXException | IOException ex) {
			ex.printStackTrace();
			out.println("spain has problems");
		}
		try {
			validator.validate(sourceAustralia);
			out.println("australia has no problems");
		} catch (SAXException | IOException ex) {
			ex.printStackTrace();
			out.println("australia has problems");
		}
	}
	
}
