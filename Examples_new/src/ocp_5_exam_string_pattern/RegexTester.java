package ocp_5_exam_string_pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String regex ="";
		String inStr= "";
		while (true){
		
	    // ===== In Java 5, Java.util,Scanner is used for this purpose.
	    Scanner in = new Scanner(System.in);
	    System.out.print("Please enter  REGEX:");
	    regex = in.nextLine();      
	    System.out.println("You entered regex : " + regex);
		
	    
	    // ===== In Java 5, Java.util,Scanner is used for this purpose.
	    in = new Scanner(System.in);
	    System.out.print("Please enter STRING:");
	    inStr = in.nextLine();      
	    System.out.println("You entered STRING : " + regex);

	
		Pattern p = Pattern.compile(regex); 
		Matcher m = p.matcher(inStr);
		boolean b = false;
		while(b = m.find()) {
			System.out.println(m.start()+" "+m.group());
		}
		String replace = "X";
		String val = m.replaceAll(replace);
		System.out.println(val);
		}

	}

}
