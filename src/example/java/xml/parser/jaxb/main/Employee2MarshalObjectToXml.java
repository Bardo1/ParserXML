package example.java.xml.parser.jaxb.main;

import java.io.FileOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Employee2;

public class Employee2MarshalObjectToXml {
	public static void main(String[] args) throws Exception {
		JAXBContext contextObj = JAXBContext.newInstance(Employee2.class);

		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		Employee2 emp1 = new Employee2(1, "Vimal Jaiswal", 50000);

		marshallerObj.marshal(emp1, new FileOutputStream("src/example/java/xml/parser/jaxb/xml/employee2-marshal.xml"));

	}
}