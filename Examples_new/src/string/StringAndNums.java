package string;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAndNums {

	
	public static void main(String[] args) {
	
		String distr ="districtNr2";
		String distr2 = "districtNr21";
		String distrko1 = "dis21trictNr";
		String distrko2 = "21trictNr";
		
		Pattern pattern = Pattern.compile("\\d+$");
		
		Matcher matcher = pattern.matcher(distr2);

		
		if(matcher.find()) {
	        	  String substringWithMatch1 = distr2.substring(matcher.start(),matcher.end());
	              System.out.println("match:"+substringWithMatch1);        
	        }
	}
}
