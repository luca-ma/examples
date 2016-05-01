package ocp_5_exam_string_pattern;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.*;

public class DateFormatEx {

	public static void main(String[] args) {
		
		
		Calendar calendar = Calendar.getInstance(Locale.FRANCE);
		Date currDate = calendar.getTime();
		
		DateFormat format = DateFormat.getDateInstance(DateFormat.LONG,Locale.FRANCE);
		
		String format2 = format.format(currDate);
		System.out.println(format2);
	}

}
