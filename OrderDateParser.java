package projTryouts;

import static java.lang.System.out;

import java.sql.Timestamp;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class OrderDateParser {

	private String originalDateString;
	private static final int dateStringSize = 6;

	public OrderDateParser(String s) {
		formatDateString(s);
	}

	public void formatDateString(String originalDateString) {

		ArrayList<String> dateStringList = new ArrayList<String>();

		for (int i = 0; i < originalDateString.length(); ++i) {
			char c = originalDateString.charAt(i);
			dateStringList.add(Character.toString(c));
		}

		dateStringList.add(2, "/"); // insert separator after 2digits day
		dateStringList.add(5, "/"); // insert separator after 2digits month

		String cleanDateString = "";

		Iterator<String> itr = dateStringList.iterator();
		while (itr.hasNext()) {
			cleanDateString += itr.next();
		}

		Format formatter = new SimpleDateFormat("MM/dd/YY");
		Date dt1 = new Date(cleanDateString);	
		
		String dateString = formatter.format(dt1);
		this.originalDateString = dateString;
	}

	public String getParsedDate() {

		return this.originalDateString;
	}
	
	public Timestamp getTimeStamp() throws ParseException{
		
		Date cal = new GregorianCalendar().getTime();
		
		LocalTime adt = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS);
		Date ds = new Date(getParsedDate());
		
		Timestamp ts = new Timestamp(ds.getTime());
//		ts.setHours(adt.getHour());
//		ts.setMinutes(adt.getMinute());
//		ts.setSeconds(adt.getSecond());
		
		ts.setHours(cal.getHours());
		ts.setMinutes(cal.getMinutes());
		ts.setSeconds(cal.getSeconds());


		
		
//		SimpleDateFormat f = new SimpleDateFormat(("MM/dd/YY hh:mm:ss"));
//		f.format(getParsedDate());
//		
//		//long s = f.parse(ts.getTime());
		

		
		return ts;
		
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		OrderDateParser p = new OrderDateParser("122417");
		out.println(p.getParsedDate());
		out.println(new Date(p.getParsedDate()).getTime());
		
		out.println(p.getParsedDate());
		try {
			out.println(p.getTimeStamp());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		LocalTime adt = ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS);
//		
//		Date ds = new Date(p.getAccurateDate());
//		
//		Timestamp ts = new Timestamp(ds.getTime());
//		
//		out.println("orgin: " + ds.getDate());
//		
//		ts.setHours(adt.getHour());
//		ts.setMinutes(adt.getMinute());
//		ts.setSeconds(adt.getSecond());
////		
//		out.println(ts);
		
//		 out.println(new SimpleDateFormat("MM/dd/YY hh:mm:ss").format(ts) );
		
		//out.println(ZonedDateTime.now().toLocalTime().truncatedTo(ChronoUnit.SECONDS));
		//Timestamp s = new Timestamp(System.currentTimeMillis());
		
	}

}
