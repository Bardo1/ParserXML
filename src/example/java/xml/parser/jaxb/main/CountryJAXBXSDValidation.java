package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
import java.util.Calendar;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import example.java.xml.parser.jaxb.bean.Country;
import example.java.xml.parser.jaxb.validationEventHandler.CountryValidationEventHandler;

// XSDs for marshaling with validation of the objects involved
public class CountryJAXBXSDValidation {

	public static void main(String[] args) throws Exception {
		// validation will fail because continent is mandatory
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		//spain.setFoundation(LocalDate.of(1469, 10, 19));
		spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File(
				"src/example/java/xml/parser/jaxb/xml/countries_validation.xsd"));

		JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setSchema(schema);
		// the schema uses a validation handler for validate the objects
		marshaller.setEventHandler(new CountryValidationEventHandler());
		try {
			marshaller.marshal(spain, System.out);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		// continent is wrong and validation will fail
		Country australia = new Country();
		australia.setName("Australia");
		australia.setCapital("Camberra");
		//australia.setFoundation(LocalDate.of(1788, 01, 26));
		australia.setFoundation(Calendar.getInstance().getTime());
		australia.setContinent("Australia");

		try {
			marshaller.marshal(australia, System.out);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

		// finally everything ok
		australia = new Country();
		australia.setName("Australia");
		australia.setCapital("Camberra");
		//australia.setFoundation(LocalDate.of(1788, 01, 26));
		australia.setFoundation(Calendar.getInstance().getTime());
		australia.setContinent("Oceania");

		try {
			marshaller.marshal(australia, System.out);
		} catch (JAXBException ex) {
			ex.printStackTrace();
		}

	}

}
