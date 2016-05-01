package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx1 {

	public static void main(String[] args) {

		String str = "pippo_ins_1.csv";

		 Pattern patternN = Pattern.compile("\\d+");
	     Matcher matcherN = patternN.matcher(str);
	     matcherN.find();
	     //while(matcherN.find()) {
	        	int start = matcherN.start();
	        	int end = matcherN.end();
	        	System.out.println("match s "+start); 
	        	System.out.println("match e "+end); 
	        	
	        	System.out.println("char "+str.substring(start, end)); 
	       // }

	}

}
