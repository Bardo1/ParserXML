package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import example.java.xml.parser.jaxb.bean.Country;

//XSD usage without validation
public class CountryJAXBXSD {

	public static void main(String[] args) throws Exception {
		Country spain = new Country();
		spain.setName("Spain");
		spain.setCapital("Madrid");
		spain.setContinent("Europe");
		//spain.setFoundation(LocalDate.of(1469, 10, 19));
		spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));
		spain.setPopulation(45000000);

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(
				new File("src/example/java/xml/parser/jaxb/xml/countries.xsd"));

		JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);

		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setSchema(schema);
		marshaller.marshal(spain, System.out);

	}

}
// http://www.w3schools.com/schema/schema_example.asp
// http://blog.bdoughan.com/2010/12/jaxb-and-marshalunmarshal-schema.html
