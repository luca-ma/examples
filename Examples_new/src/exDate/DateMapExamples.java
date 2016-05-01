package exDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class DateMapExamples {
	public static final String HOUR_FILE_FORMAT= "HH/mm/ss";
	public static final String DATE_FILE_FORMAT= "yy/MM/dd";
	
	
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
			cal.set(Calendar.YEAR, 2001);
			Date date01 = cal.getTime();
			cal.set(Calendar.YEAR, 2002);
			Date date02 = cal.getTime();
			cal.set(Calendar.YEAR, 2003);
			Date date03 = cal.getTime();
			
			TreeMap<Date,String> dateMap = new TreeMap<Date,String> ();
			dateMap.put(date01, "date1");
			dateMap.put(date02, "date2");
			dateMap.put(date03, "date3");
		
			Date firstKey = dateMap.firstKey();
			Date lastKey = dateMap.lastKey();
			
			Date lowerKey = dateMap.lowerKey(lastKey);
			String last1 = dateMap.get(lowerKey);
			
	
	}
}
