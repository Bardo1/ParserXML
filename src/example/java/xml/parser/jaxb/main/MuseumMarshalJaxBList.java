package example.java.xml.parser.jaxb.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Museum;
import example.java.xml.parser.jaxb.bean.Museums;

public class MuseumMarshalJaxBList {

	public static void main(String[] args) {
		try {
			Museum simpleMuseum = new Museum();
			simpleMuseum.setName("Simple Museum");
			simpleMuseum.setCity("Oviedo, Spain");

			Museum anotherSimpleMuseum = new Museum();
			anotherSimpleMuseum.setName("Another Simple Museum");
			anotherSimpleMuseum.setCity("Gijon, Spain");

			Museums listOfMuseums = new Museums();
			listOfMuseums.add(simpleMuseum);
			listOfMuseums.add(anotherSimpleMuseum);

			JAXBContext jaxbContext = JAXBContext.newInstance(Museums.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshal java object with list into XML file and console output
			jaxbMarshaller.marshal(listOfMuseums, new File("src/example/java/xml/parser/jaxb/xml/museum-list.xml"));
			jaxbMarshaller.marshal(listOfMuseums, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}

/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<MUSEUMS>
    <MUSEUM>
        <MUSEUM_NAME>Simple Museum</MUSEUM_NAME>
        <CITY>Oviedo, Spain</CITY>
    </MUSEUM>
    <MUSEUM>
        <MUSEUM_NAME>Another Simple Museum</MUSEUM_NAME>
        <CITY>Gijon, Spain</CITY>
    </MUSEUM>
</MUSEUMS>
*/
