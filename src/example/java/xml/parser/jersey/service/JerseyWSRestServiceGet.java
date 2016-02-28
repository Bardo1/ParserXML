//http://localhost:8080/ParserXML/rest/jerseyWSRestServiceGet/webservice?value=REST
//http://localhost:8080/ParserXML/rest/jerseyWSRestServiceGet/webservice
package example.java.xml.parser.jersey.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/jerseyWSRestServiceGet")
public class JerseyWSRestServiceGet {

	@GET
	@Path("/{parameter}")
	public Response responseMsg(@PathParam("parameter") String parameter,
			@DefaultValue("DefaultValue") @QueryParam("value") String value) {
		String output = "parameter:value " + parameter + ":" + value;
		return Response.status(200).entity(output).build();
	}
}
