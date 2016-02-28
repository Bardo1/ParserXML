package example.java.json.parser.jaxb.main;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import example.java.json.parser.jaxb.bean.Employee;

public class UnmarshallerMoxy {

	// Unmarshaller JSON to POJO using EclipseLink MOXy
	public static void main(String[] args) throws JAXBException {

		// Create a JaxBContext
		JAXBContext jc = JAXBContext.newInstance(Employee.class);

		// Create the Unmarshaller Object using the JaxB Context
		Unmarshaller unmarshaller = jc.createUnmarshaller();

		// Set the Unmarshaller media type to JSON or XML
		unmarshaller.setProperty(UnmarshallerProperties.MEDIA_TYPE, "application/json");

		// Set it to true if you need to include the JSON root element in the
		// JSON input
		unmarshaller.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, true);

		// Create the StreamSource by creating StringReader using the JSON input
		StreamSource json = new StreamSource(
				new StringReader("{\"employee\":{\"id\":1,\"name\":\"Ashraf\",\"skills\":[\"java\",\"sql\"]}}"));

		// Getting the employee pojo again from the json
		Employee employee = unmarshaller.unmarshal(json, Employee.class).getValue();

		// Print the employee data to console
		System.out.println("Employee Id: " + employee.getId());
		System.out.println("\nEmployee Name: " + employee.getName());
		System.out.println("\nEmployee Skills: " + StringUtils.join(employee.getSkills(), ','));
	}

}
