package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Exhibition;
import example.java.xml.parser.jaxb.bean.Museum;

public class MuseumMarshalJaxBComplexJavaType {

	public static void main(String[] args) throws ParseException {
		try {
			Museum simpleMuseum = new Museum();
			simpleMuseum.setName("Simple Museum");
			simpleMuseum.setCity("Oviedo, Spain");

			simpleMuseum.setChildrenAllowed(false);

			Exhibition exhibition = new Exhibition();
			exhibition.setName("one exhibition");
			// exhibition.setFrom( LocalDate.of( 2014, 01, 01 ) );
			exhibition.setFrom(new SimpleDateFormat("yyyy, MM, dd").parse("1900, 01, 01"));

			simpleMuseum.setPermanent(exhibition);

			JAXBContext jaxbContext = JAXBContext.newInstance(Museum.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// set this flag to true to format the output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshal java object with complex class in XML file and console output
			jaxbMarshaller.marshal(simpleMuseum,
					new File("src/example/java/xml/parser/jaxb/xml/museum-complex-class.xml"));
			jaxbMarshaller.marshal(simpleMuseum, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}

/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<MUSEUM children_allowed="false">
    <MUSEUM_NAME>Simple Museum</MUSEUM_NAME>
    <CITY>Oviedo, Spain</CITY>
    <PERMANENT_EXHIBITION>
        <NAME>one exhibition</NAME>
        <FROM>Mon Jan 01 00:00:00 IST 1900</FROM>
    </PERMANENT_EXHIBITION>
</MUSEUM>
*/
