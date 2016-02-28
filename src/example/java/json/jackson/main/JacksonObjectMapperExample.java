package example.java.json.jackson.main;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

import example.java.json.jackson.model.Address;
import example.java.json.jackson.model.Employee;


public class JacksonObjectMapperExample {

	public static void main(String[] args) throws IOException {
		
		//read json file data to String
		// path for maven project
		//src/main/java/example/java/json/jackson/txt/employee.txt
		// path for simple dynamic web project
		//src/example/java/json/jackson/txt/
		byte[] jsonData = Files.readAllBytes(Paths.get("src/example/java/json/jackson/txt/employee.txt"));
		
		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		//convert json string to object
		Employee emp = objectMapper.readValue(jsonData, Employee.class);
		
		System.out.println("Employee Object\n"+emp);
		
		//convert Object to json string
		Employee emp1 = createEmployee();
		//configure Object mapper for pretty print
		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		
		//writing to console, can write to any output stream such as file
		StringWriter stringEmp = new StringWriter();
		objectMapper.writeValue(stringEmp, emp1);
		System.out.println("Employee JSON is\n"+stringEmp);
		
		
		//converting json to Map
		byte[] mapData = Files.readAllBytes(Paths.get("src/example/java/json/jackson/txt/data.txt"));
		Map<String,String> myMap = new HashMap<String, String>();
		
		myMap = objectMapper.readValue(mapData, HashMap.class);
		System.out.println("Map is: "+myMap);
		//another way
		myMap = objectMapper.readValue(mapData, new TypeReference<HashMap<String,String>>() {});
		System.out.println("Map using TypeReference: "+myMap);
		
		//read JSON like DOM Parser
		JsonNode rootNode = objectMapper.readTree(jsonData);
		JsonNode idNode = rootNode.path("id");
		System.out.println("id = "+idNode.asInt());
		JsonNode phoneNosNode = rootNode.path("phoneNumbers");
		Iterator<JsonNode> elements = phoneNosNode.elements();
		while(elements.hasNext()){
			JsonNode phone = elements.next();
			System.out.println("Phone No = "+phone.asLong());
		}
		
		//update JSON data
		((ObjectNode) rootNode).put("id", 500);
		//add new key value
		((ObjectNode) rootNode).put("test", "test value");
		//remove existing key
		((ObjectNode) rootNode).remove("role");
		((ObjectNode) rootNode).remove("properties");
		objectMapper.writeValue(new File("src/example/java/json/jackson/txt/employee-updated.txt"), rootNode);
		

	}
	
	public static Employee createEmployee() {

		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("David");
		emp.setPermanent(false);
		emp.setPhoneNumbers(new long[] { 123456, 987654 });
		emp.setRole("Manager");

		Address add = new Address();
		add.setCity("Bangalore");
		add.setStreet("BTM 1st Stage");
		add.setZipcode(560100);
		emp.setAddress(add);

		List<String> cities = new ArrayList<String>();
		cities.add("Los Angeles");
		cities.add("New York");
		emp.setCities(cities);

		Map<String, String> props = new HashMap<String, String>();
		props.put("salary", "1000 Rs");
		props.put("age", "28 years");
		emp.setProperties(props);

		return emp;
	}

}

/*
Employee Object
***** Employee Details *****
ID=123
Name=Pankaj
Permanent=true
Role=Manager
Phone Numbers=[123456, 987654]
Address=Albany Dr, San Jose, 95129
Cities=[Los Angeles, New York]
Properties={age=29 years, salary=1000 USD}
*****************************
Employee JSON is
{
  "id" : 100,
  "name" : "David",
  "permanent" : false,
  "address" : {
    "street" : "BTM 1st Stage",
    "city" : "Bangalore",
    "zipcode" : 560100
  },
  "phoneNumbers" : [ 123456, 987654 ],
  "role" : "Manager",
  "cities" : [ "Los Angeles", "New York" ],
  "properties" : {
    "age" : "28 years",
    "salary" : "1000 Rs"
  }
}
Map is: {name=David, role=Manager, city=Los Angeles}
Map using TypeReference: {name=David, role=Manager, city=Los Angeles}
id = 123
Phone No = 123456
Phone No = 987654
*/
