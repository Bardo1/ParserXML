//http://localhost:8080/ParserXML/rest/xmlServices/print/firstName1

package example.java.xml.parser.jersey.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import example.java.xml.parser.jersey.bean.Student;

@Path("/xmlServices")
public class JerseyWSRestServiceGetPost {

	@GET
	@Path("/print/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public Student responseMsg( @PathParam("name") String name ) {	
		Student student = new Student(name, "lastName1",21,1);
		return student;
	}
	
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_XML)
	public Response consumeXML( Student student ) {
		String output = student.toString();
		return Response.status(200).entity(output).build();
	}
	
}