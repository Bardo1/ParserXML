package example.java.xml.parser.jaxb.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Museum;

public class MuseumMarshalJaxB {

	public static void main(String[] args) {
		try {
			Museum simpleMuseum = new Museum();
			simpleMuseum.setName("Simple Museum");
			simpleMuseum.setCity("Oviedo, Spain");
			simpleMuseum.setChildrenAllowed(false);

			JAXBContext jaxbContext = JAXBContext.newInstance(Museum.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// set this flag to true to format the output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshal java objects into XML file and console output
			jaxbMarshaller.marshal(simpleMuseum, new File("src/example/java/xml/parser/jaxb/xml/museum-marshal.xml"));
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
</MUSEUM>*/
