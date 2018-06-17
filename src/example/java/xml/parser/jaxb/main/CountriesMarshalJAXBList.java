package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Countries;
import example.java.xml.parser.jaxb.bean.Country;

public class CountriesMarshalJAXBList {

	public static void main(String[] args) throws ParseException {
		try {
			Country spain = new Country();
			spain.setName("Spain");
			spain.setCapital("Madrid");
			spain.setContinent("Europe");

			//spain.setFoundation(LocalDate.of(1469, 10, 19));
			spain.setFoundation(new SimpleDateFormat("yyyy, MM, dd").parse("1469, 10, 20"));

			Country usa = new Country();
			usa.setName("USA");
			usa.setCapital("Washington");
			usa.setContinent("America");

			//usa.setFoundation(LocalDate.of(1776, 7, 4));
			usa.setFoundation(Calendar.getInstance().getTime());

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
}
