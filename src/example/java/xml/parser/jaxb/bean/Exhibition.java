package example.java.xml.parser.jaxb.bean;

//import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import example.java.xml.parser.jaxb.adapter.DateAdapter;

//defines root element of XML file and name to be used in the XML 
//using XmlRootElement or XmlElement annotation
@XmlRootElement(name = "EXHIBITION")
//optional; define order of elements in XML file
@XmlType(propOrder = { "name", "artists", "from", "to" })
public class Exhibition {
	String name;
	//LocalDate from;
	//LocalDate to;
	Date from;
	Date to;
	List<String> artists;

	public String getName() {
		return name;
	}

	@XmlElement(name = "NAME")
	public void setName(String name) {
		this.name = name;
	}

	//public LocalDate getFrom() {
	public Date getFrom() {
		return from;
	}

	// indicates DateAdapter class to manage Complex Type field
	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement(name = "FROM")
	//public void setFrom(LocalDate from) {
	public void setFrom(Date from) {
		this.from = from;
	}

	//public LocalDate getTo() {
	public Date getTo() {
		return to;
	}

	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement(name = "TO")
	//public void setTo(LocalDate to) {
	public void setTo(Date to) {
		this.to = to;
	}

	public List<String> getArtists() {
		return artists;
	}

	@XmlElement(name = "ARTIST")
	public void setArtists(List<String> artists) {
		this.artists = artists;
	}

	@Override
	public String toString() {
		return getName() + "\n";
	}
}
