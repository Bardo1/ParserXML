//httphowtodoinjava.com
package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;

import example.java.xml.parser.jaxb.bean.Employee;
import example.java.xml.parser.jaxb.bean.EmployeeList;

public class EmployeeListJaxbMarshalUnMarshal {
	static EmployeeList employees = new EmployeeList();

	static {
		employees.setEmployees(new ArrayList<Employee>());

		Employee emp = new Employee();
		emp.setId(1);
		emp.setFirstName("Bill");
		emp.setLastName("Gates");
		emp.setIncome(100.0);

		Employee emp2 = new Employee();
		emp2.setId(2);
		emp2.setFirstName("Steve");
		emp2.setLastName("Job");
		emp2.setIncome(200.0);

		employees.getEmployees().add(emp);
		employees.getEmployees().add(emp2);
	}

	public static void main(String[] args) throws JAXBException {
		marshalingExample();
		System.out.println("************************************************");
		unMarshalingExample();
	}

	private static void unMarshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		EmployeeList emps = (EmployeeList) jaxbUnmarshaller
				.unmarshal(new File("src/example/java/xml/parser/jaxb/xml/employees-list-unmarshaling.xml"));

		for (Employee emp : emps.getEmployees()) {
			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getIncome());
		}
	}

	private static void marshalingExample() throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		jaxbMarshaller.marshal(employees, System.out);
		// need to create the directory manually
		// java.io.FileNotFoundException The system cannot find the path
		// specified
		// When JDK1.6 is specified, unable to fix the below problem
		// The method marshal(Object, Result) in the type Marshaller is not
		// applicable for the arguments (EmployeeList, File)
		// java.lang.ClassCastException: java.io.File cannot be cast to
		// javax.xml.transform.Result
		// jaxbMarshaller.marshal(employees, (Result) new File("abc.xml"));
		// Working fine, when JDK1.7 or above is specified
		jaxbMarshaller.marshal(employees, new File("src/example/java/xml/parser/jaxb/xml/employees-list-marshaling.xml"));
	}
}
