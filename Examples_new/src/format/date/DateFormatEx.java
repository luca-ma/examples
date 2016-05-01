package format.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("zzzz", Locale.ITALY);
		System.out.println(sdf.format(new Date()));
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy", Locale.US);
		System.out.println(sdf1.format(new Date()));
		SimpleDateFormat sdf2 = new SimpleDateFormat("mm/yyyy", Locale.US);
		System.out.println(sdf2.format(new Date()));
		
		SimpleDateFormat sdf3 = new SimpleDateFormat("mm/YYYY", Locale.US);
		System.out.println(sdf3.format(new Date()));
	}

}
