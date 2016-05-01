package num;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddInitLeadinZeros {
	public static final String HOUR_FILE_FORMAT= "HH/mm/ss";
	public static final String DATE_FILE_FORMAT= "yy/MM/dd";
	
	public static void main(String[] args) {
		
		Integer num = new Integer(10);
		String numStr = formatInt (num,4);
		System.out.println( "num to  str:" + num);
		
		num = 1222;
		numStr = formatInt (num,4);
		System.out.println( "num to  str:" + num);
		
		num = 12222;
		if(String.valueOf(num).length()>4) {
			System.out.println( "WARN EXCEED size");
		}
		numStr = formatInt (num,4);
		System.out.println( "num to  str:" + num);
	}
	
	public static String formatInt(int n, int digits) {
	    /*
	          we create a format :
	           %% : %  the first % is to escape the second %
	           0  : 0  zero character
	           %d :    how many '0' we want (specified by digits)
	           d  : d  the number to format

	    */
	    String format = String.format("%%0%dd", digits);
	    return String.format(format, n);

	  }

}
