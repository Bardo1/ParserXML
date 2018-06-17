package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import example.java.xml.parser.jaxb.bean.Country;
import example.java.xml.parser.jaxb.errorHandler.CountryErrorHandler;

//XSD usage for validation using an error handler, no marshalling involved here
public class CountryJAXBXSDErrorHandler {

	public static void main(String[] args) throws Exception {
		// error will be thrown because continent is mandatory
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		//spain.setFoundation(LocalDate.of(1469, 10, 19));
		spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));

		// ok
		Country australia = new Country();
		australia.setName("Australia");
		australia.setCapital("Camberra");
		//australia.setFoundation(LocalDate.of(1788, 01, 26));
		australia.setFoundation(Calendar.getInstance().getTime());
		australia.setContinent("Oceania");

		// schema is created
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File(
				"src/example/java/xml/parser/jaxb/xml/countries_validation.xsd"));

		// context is created and used to create sources for each country
		JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
		JAXBSource sourceSpain = new JAXBSource(jaxbContext, spain);
		JAXBSource sourceAustralia = new JAXBSource(jaxbContext, australia);

		// validator is initialized
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new CountryErrorHandler());

		// validator is used
		try {
			validator.validate(sourceSpain);
			System.out.println("spain has no problems");
		} catch (SAXException ex) {
			ex.printStackTrace();
			System.out.println("spain has problems");
		}
		try {
			validator.validate(sourceAustralia);
			System.out.println("australia has no problems");
		} catch (SAXException ex) {
			ex.printStackTrace();
			System.out.println("australia has problems");
		}
	}
}
