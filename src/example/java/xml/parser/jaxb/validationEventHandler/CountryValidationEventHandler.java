package example.java.xml.parser.jaxb.validationEventHandler;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class CountryValidationEventHandler implements ValidationEventHandler {

	@Override
	public boolean handleEvent(ValidationEvent event) {
		System.out.println("Error catched!!");
		System.out.println("event.getSeverity():  " + event.getSeverity());
		System.out.println("event.getMessage():  " + event.getMessage());
		System.out.println("event.getLinkedException():  " + event.getLinkedException());
		// locator contains information like Object, line, column, etc.
		System.out.println("event.getLocator().getLineNumber():  " + event.getLocator().getLineNumber());
		return false;
	}

}
