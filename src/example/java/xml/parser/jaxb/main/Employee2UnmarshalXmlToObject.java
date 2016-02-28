package example.java.xml.parser.jaxb.main;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import example.java.xml.parser.jaxb.bean.Employee2;

public class Employee2UnmarshalXmlToObject {
	public static void main(String[] args) {
		try {
			File file = new File("src/example/java/xml/parser/jaxb/xml/employee2-unmarshal.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Employee2.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Employee2 e = (Employee2) jaxbUnmarshaller.unmarshal(file);
			System.out.println(e.getId() + " " + e.getName() + " " + e.getSalary());

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}
}