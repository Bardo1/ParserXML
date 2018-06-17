package example.java.xml.parser.jaxb.adapter;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

//adapts the Date/LocalDate objects by implementing the XmlAdapter interface for marshal and unmarshal
public class DateLocalAdapter extends XmlAdapter<String, LocalDate> {
	// Overrides the unmarshal method of the class XmlAdapter in order to parse a date string of the type Date/LocalDate object
	@Override
	public LocalDate unmarshal(String date) throws Exception {
		return LocalDate.parse(date);
	}

	// Overrides the marshal method of the class XmlAdapter in order to convert the date object to an String
	@Override
	public String marshal(LocalDate date) throws Exception {
		return date.toString();
	}
}
