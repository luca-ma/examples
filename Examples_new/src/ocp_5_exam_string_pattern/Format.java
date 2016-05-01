package ocp_5_exam_string_pattern;

import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class Format {
	public static void main(String []args) {
		Formatter formatter = new Formatter();
		Calendar calendar = Calendar.getInstance(Locale.US);
		calendar.set(/* year =*/ 2012, /* month = */ Calendar.FEBRUARY,
				/* date = */ 1);
		
		formatter.format("%tY/%tB/%td", calendar);
		System.out.println(formatter);
	}
}