package exDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDFormatter {

	public static void main(String[] args) throws ParseException {


        final String dateFormat = "yyyy-MM-dd HH:mm:ssX";
        final String date = "2015-07-01 16:05:29+1200";
        SimpleDateFormat parser = new SimpleDateFormat(dateFormat);
        Date dt = parser.parse(date);
        System.out.println(dt.toString());


	}

}
