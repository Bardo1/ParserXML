package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Country;

public class DateAdapterMarshalJAXBComplexClass {

	public static void main(String[] args) throws ParseException {
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
}
