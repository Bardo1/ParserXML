package example.java.xml.parser.jaxb.main;

import static java.lang.System.out;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import example.java.xml.parser.jaxb.bean.Exhibition;
import example.java.xml.parser.jaxb.bean.Museum;
import example.java.xml.parser.jaxb.bean.Museums;

public class MuseumJaxBMain {

	public static void main(String[] args) throws ParseException {
		
		new MuseumJaxBMain().marshalMuseum();
		new MuseumJaxBMain().marshalListMuseum();
		new MuseumJaxBMain().marshalComplexTypeMuseum();
		new MuseumJaxBMain().marshalComplexTypeListMuseum();
		
		new MuseumJaxBMain().unmarshalMuseum();

	}
	
	
	private void marshalMuseum() {
		out.println("\n\nMarshal Museum");
		try {
			Museum simpleMuseum = new Museum();
			simpleMuseum.setName("Simple Museum");
			simpleMuseum.setCity("Oviedo, Spain");
			simpleMuseum.setChildrenAllowed(false);

			JAXBContext jaxbContext = JAXBContext.newInstance(Museum.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// set this flag to true to format the output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshal java objects into XML file and console output
			jaxbMarshaller.marshal(simpleMuseum, new File("src/example/java/xml/parser/jaxb/xml/museum-marshal.xml"));
			jaxbMarshaller.marshal(simpleMuseum, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	private void marshalListMuseum() throws ParseException {
		out.println("\n\nMarshal Museum List");
		try {
			Museum simpleMuseum = new Museum();
			simpleMuseum.setName("Simple Museum");
			simpleMuseum.setCity("Oviedo, Spain");

			Museum anotherSimpleMuseum = new Museum();
			anotherSimpleMuseum.setName("Another Simple Museum");
			anotherSimpleMuseum.setCity("Gijon, Spain");

			Museums listOfMuseums = new Museums();
			listOfMuseums.add(simpleMuseum);
			listOfMuseums.add(anotherSimpleMuseum);

			JAXBContext jaxbContext = JAXBContext.newInstance(Museums.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshal java object with list into XML file and console output
			jaxbMarshaller.marshal(listOfMuseums, new File("src/example/java/xml/parser/jaxb/xml/museum-list.xml"));
			jaxbMarshaller.marshal(listOfMuseums, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	private void marshalComplexTypeMuseum() throws ParseException {
		out.println("\n\nMarshal ComplexJavaType Museum");
		try {
			Museum simpleMuseum = new Museum();
			simpleMuseum.setName("Simple Museum");
			simpleMuseum.setCity("Oviedo, Spain");

			simpleMuseum.setChildrenAllowed(false);

			Exhibition exhibition = new Exhibition();
			exhibition.setName("one exhibition");
			// exhibition.setFrom( LocalDate.of( 2014, 01, 01 ) );
			exhibition.setFrom(new SimpleDateFormat("yyyy, MM, dd").parse("1900, 01, 01"));

			simpleMuseum.setPermanent(exhibition);

			JAXBContext jaxbContext = JAXBContext.newInstance(Museum.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// set this flag to true to format the output
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshal java object with complex class in XML file and console output
			jaxbMarshaller.marshal(simpleMuseum,
					new File("src/example/java/xml/parser/jaxb/xml/museum-complex-class.xml"));
			jaxbMarshaller.marshal(simpleMuseum, System.out);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	private void marshalComplexTypeListMuseum() throws ParseException {
		out.println("\n\nMarshal ComplexJavaType with list of Museum");
		try {
			Museum reinaSofia = new Museum();
			reinaSofia.setName("Reina Sofia Museum");
			reinaSofia.setCity("Madrid");
			Exhibition permanent = new Exhibition();
			permanent.setName("Permanent Exhibition - Reina Sofia Museum");
			// permanent.setFrom( LocalDate.of( 1900, Month.JANUARY, 1 ) );
			permanent.setFrom(new SimpleDateFormat("yyyy, MM, dd").parse("1900, 01, 01"));
			// permanent.setTo( LocalDate.of( 2014, Month.DECEMBER, 31 ) );
			permanent.setTo(Calendar.getInstance().getTime());
			List<String> artistsReinaSofia = new ArrayList<String>();
			artistsReinaSofia.add("Picasso");
			artistsReinaSofia.add("Dali");
			artistsReinaSofia.add("Miro");
			permanent.setArtists(artistsReinaSofia);
			reinaSofia.setPermanent(permanent);

			Museum prado = new Museum();
			prado.setName("Prado Museum");
			prado.setCity("Madrid");
			Exhibition permanentPrado = new Exhibition();
			permanentPrado.setName("Permanent Exhibition - Prado Museum");
			// permanentPrado.setFrom( LocalDate.of( 1500, Month.JANUARY, 1 ) );
			permanentPrado.setFrom(new SimpleDateFormat("yyyy, MM, dd").parse("1900, 01, 01"));
			// permanentPrado.setTo( LocalDate.of( 2000, Month.DECEMBER, 31 ) );
			permanentPrado.setTo(Calendar.getInstance().getTime());
			List<String> artistsPrado = new ArrayList<String>();
			artistsPrado.add("Velazquez");
			artistsPrado.add("Goya");
			artistsPrado.add("Zurbaran");
			artistsPrado.add("Tiziano");
			permanentPrado.setArtists(artistsPrado);
			prado.setPermanent(permanentPrado);

			Exhibition special = new Exhibition();
			special.setName("Game of Bowls (1908), by Henri Matisse");
			// special.setFrom( LocalDate.of( 1908, Month.JANUARY, 1 ) );
			special.setFrom(new SimpleDateFormat("yyyy, MM, dd").parse("1900, 01, 01"));
			// special.setTo( LocalDate.of( 1908, Month.DECEMBER, 31 ) );
			special.setTo(Calendar.getInstance().getTime());
			List<String> artistsSpecial = new ArrayList<String>();
			artistsSpecial.add("Mattise");
			special.setArtists(artistsSpecial);
			prado.setSpecial(special);

			Museums museums = new Museums();
			museums.add(prado);
			museums.add(reinaSofia);

			JAXBContext jaxbContext = JAXBContext.newInstance(Museums.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// marshal java objects into XML file and console output
			jaxbMarshaller.marshal(museums, new File("src/example/java/xml/parser/jaxb/xml/museums-marshal.xml"));
			jaxbMarshaller.marshal(museums, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	
	private void unmarshalMuseum() {
		out.println("\n\nUnmarshal Museum");
		try {
			File file = new File("src/example/java/xml/parser/jaxb/xml/museums.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Museums.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Museums museums = (Museums) jaxbUnmarshaller.unmarshal(file);
			out.println(museums);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}
