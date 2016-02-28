package example.java.xml.parser.jaxb.main;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import example.java.xml.parser.jaxb.bean.Exhibition;
import example.java.xml.parser.jaxb.bean.Museum;
import example.java.xml.parser.jaxb.bean.Museums;

public class MuseumsMarshalJaxB {

	public static void main(String[] args) throws ParseException {
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
}

/*<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<MUSEUMS>
    <MUSEUM>
        <MUSEUM_NAME>Prado Museum</MUSEUM_NAME>
        <CITY>Madrid</CITY>
        <PERMANENT_EXHIBITION>
            <NAME>Permanent Exhibition - Prado Museum</NAME>
            <ARTIST>Velazquez</ARTIST>
            <ARTIST>Goya</ARTIST>
            <ARTIST>Zurbaran</ARTIST>
            <ARTIST>Tiziano</ARTIST>
            <FROM>Mon Jan 01 00:00:00 IST 1900</FROM>
            <TO>Sun Oct 11 23:01:56 IST 2015</TO>
        </PERMANENT_EXHIBITION>
        <SPECIAL_EXHIBITION>
            <NAME>Game of Bowls (1908), by Henri Matisse</NAME>
            <ARTIST>Mattise</ARTIST>
            <FROM>Mon Jan 01 00:00:00 IST 1900</FROM>
            <TO>Sun Oct 11 23:01:56 IST 2015</TO>
        </SPECIAL_EXHIBITION>
    </MUSEUM>
    <MUSEUM>
        <MUSEUM_NAME>Reina Sofia Museum</MUSEUM_NAME>
        <CITY>Madrid</CITY>
        <PERMANENT_EXHIBITION>
            <NAME>Permanent Exhibition - Reina Sofia Museum</NAME>
            <ARTIST>Picasso</ARTIST>
            <ARTIST>Dali</ARTIST>
            <ARTIST>Miro</ARTIST>
            <FROM>Mon Jan 01 00:00:00 IST 1900</FROM>
            <TO>Sun Oct 11 23:01:56 IST 2015</TO>
        </PERMANENT_EXHIBITION>
    </MUSEUM>
</MUSEUMS>
*/
