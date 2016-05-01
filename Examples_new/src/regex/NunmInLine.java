package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NunmInLine {

	public static String PATTERN_NUM_ATBEGINNINF_OF_LINE ="^\\d+";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String inString = "12 ";
		Pattern pattern = Pattern.compile(PATTERN_NUM_ATBEGINNINF_OF_LINE);
		Matcher matcher = pattern.matcher(inString);

		if (matcher.find()){
		//String retStr =inString.substring(matcher.start(),matcher.end()));
			String retStr =matcher.group();
		} else {
		    // return empty string and log a message
		} 
	}

}
