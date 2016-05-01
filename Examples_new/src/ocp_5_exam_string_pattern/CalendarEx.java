package ocp_5_exam_string_pattern;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarEx {

	public static void main(String[] args) {
	
		
		Calendar instance = Calendar.getInstance();
		System.out.println(instance.getTime());

		
		Calendar instance2 = Calendar.getInstance(Locale.UK);
		System.out.println(instance2.getTime());
		
		Calendar instance3 = Calendar.getInstance(TimeZone.getDefault());
		System.out.println(instance3.getTime());
		
		Calendar instance4 = Calendar.getInstance(TimeZone.getDefault(),Locale.UK);
		System.out.println(instance4.getTime());
		
	//	instance.roll(field, amount);
	}

}
