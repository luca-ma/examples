package ocp_5_exam_string_pattern;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParseEx {

	public static void main(String[] args) throws ParseException {
		
		double amount = 123456.789; 
		Locale fr = new Locale("it", "IT"); 
		NumberFormat formatter = NumberFormat.getInstance(fr); 
		String s = formatter.format(amount) ; 
		formatter = NumberFormat.getInstance(); 
		Number amount2 = formatter.parse(s); 
		System.out.println( amount + " " + amount2 );
		
	}

	}


