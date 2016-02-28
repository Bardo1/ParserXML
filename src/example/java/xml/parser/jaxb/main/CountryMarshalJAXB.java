package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Country;

//jaxb marshaling functionalities
public class CountryMarshalJAXB {

	public static void main(String[] args) throws ParseException {
		try {

			// init very simple data to marshal
			Country spain = new Country();
			spain.setName("Spain");
			spain.setCapital("Madrid");
			spain.setContinent("Europe");
			//spain.setFoundation(LocalDate.of(1469, 10, 19));
			spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));

			spain.setPopulation(45000000);

			// init jaxb marshaler
			JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// set this flag to true to format the output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshaling of java objects in xml (output to file and standard
			// output)
			jaxbMarshaller.marshal(spain,
					new File("src/example/java/xml/parser/jaxb/xml/country.xml"));
			jaxbMarshaller.marshal(spain, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}
