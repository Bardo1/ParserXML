// it is necessary to start the server
// directly hitting the below URL in browser does not work
// run as java program
package example.java.xml.parser.jersey.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import example.java.xml.parser.jersey.bean.Student;

public class JerseyWSRestClientMain {

	public static void main(String[] args) {
		try {
			Student student = new Student("firstName2", "lastName2", 22, 2);
			Client client = Client.create();
			// refer to JerseyWSRestServiceGetPost.java
			WebResource webResource = client.resource("http://localhost:8080/ParserXML/rest/xmlServices/send");
			ClientResponse response = webResource.accept("application/xml").post(ClientResponse.class, student);
			if (response.getStatus() != 200) {
				throw new RuntimeException("HTTP error code: " + response.getStatus());
			}
			String output = response.getEntity(String.class);
			System.out.println("Server Response");
			System.out.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
