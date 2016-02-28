package example.java.xml.parser.jaxb.validationEventHandler;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

// Implementation of the interface {@link ValidationEventHandler}
public class CountryValidationEventHandler implements ValidationEventHandler {

	@Override
	public boolean handleEvent(ValidationEvent event) {
		System.out.println("Error catched!!");
		System.out.println("event.getSeverity():  " + event.getSeverity());
		System.out.println("event:  " + event.getMessage());
		System.out.println("event.getLinkedException():  " + event.getLinkedException());
		// the locator contains much more information like line, column, etc.
		System.out.println("event.getLocator().getObject():  " + event.getLocator().getObject());
		return false;
	}

}
