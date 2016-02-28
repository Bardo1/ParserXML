package example.java.xml.parser.jaxb.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import example.java.xml.parser.jaxb.bean.Museums;

public class MuseumsUnMarshalJAXB {
	public static void main(String[] args) {
		try {
			File file = new File("src/example/java/xml/parser/jaxb/xml/museums.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Museums.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Museums museums = (Museums) jaxbUnmarshaller.unmarshal(file);
			System.out.println(museums);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}

/*Name: Prado Museum
City: Madrid
Permanent Exhibition - Prado Museum
Game of Bowls (1908), by Henri Matisse

Name: Reina Sofia Museum
City: Madrid
ATTENTION! Children are not allowed in this museum
Permanent Exhibition - Reina Sofia Museum

Name: British Museum
City: London
Permanent Exhibition - British Museum

Name: MOMA
City: New York
Permanent Exhibition - MOMA

Name: Louvre Museum
City: Paris
Permanent Exhibition - Louvre Museum
*/