package exDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateExamples {
	public static final String HOUR_FILE_FORMAT= "HH/mm/ss";
	public static final String DATE_FILE_FORMAT= "yy/MM/dd";
	
	public static final String GUI_HOUR_FILE_FORMAT= "HH:mm:ss";
	public static final String HOUR_DATE_FORMAT= "yyyyMMddHHmmss";
	public static final String HOUR_DATE_FORMAT_SND= "yyyy-MM-ddHH:mm:ss.SSSSSS";
	public static void main(String[] args) {
		
		SimpleDateFormat hourFormat_file = new SimpleDateFormat(HOUR_FILE_FORMAT);
		SimpleDateFormat daysFormat = new SimpleDateFormat(DATE_FILE_FORMAT);
		SimpleDateFormat hourFormat_gui= new SimpleDateFormat(GUI_HOUR_FILE_FORMAT);
		Date currDate = Calendar.getInstance().getTime();
		
		//StringBuilder nowHour= new StringBuilder( hourFormat.format( currDate ) );
        StringBuilder nowDay= new StringBuilder( daysFormat.format( currDate ) );
 
        //System.out.println( "DEBUG: Today HOur: '" + nowHour + "'");
       // System.out.println( "DEBUG: Today Day: '" + nowDay + "'");

        String dateOnFile = "08/22/44";
        String dateOnGui= "";
        try {
			Date dateOnF = hourFormat_file.parse(dateOnFile);
			dateOnGui = hourFormat_gui.format(dateOnF);
			//System.out.println( "DEBUG: Today Day: '" + nowDay + "'");
		} catch (ParseException e) {
			dateOnGui = dateOnFile;
		}
		
		//new date example
		String dateOnFileN = "20110720131221";
		SimpleDateFormat newFormatter = new SimpleDateFormat(HOUR_DATE_FORMAT);
		try {
			Date parsedDate = newFormatter.parse(dateOnFileN);
			System.out.println( "parsed dateHour:" + parsedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//millisec Date
		String datemillisec = "2010-05-2715:07:19.371724";
		SimpleDateFormat milliFormatter = new SimpleDateFormat(HOUR_DATE_FORMAT_SND);
		try {
			Date parsedDate = milliFormatter.parse(datemillisec);
			System.out.println( "parsed dateHour:" + parsedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String datesec = "dd-MM-yyyy HH:mm:ss";
		SimpleDateFormat dateF = new SimpleDateFormat(datesec);
		//try {
			String parsedDate = dateF.format(System.currentTimeMillis());
			System.out.println( "parsed dateHour:" + parsedDate);
		
        
	}
}
