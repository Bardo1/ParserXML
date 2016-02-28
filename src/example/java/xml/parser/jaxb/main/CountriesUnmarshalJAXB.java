package example.java.xml.parser.jaxb.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import example.java.xml.parser.jaxb.bean.Countries;

public class CountriesUnmarshalJAXB {
	public static void main(String[] args) {
		try {
			File file = new File("src/example/java/xml/parser/jaxb/xml/countries.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Countries.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Countries countres = (Countries) jaxbUnmarshaller.unmarshal(file);
			System.out.println(countres);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
