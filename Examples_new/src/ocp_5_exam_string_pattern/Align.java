package ocp_5_exam_string_pattern;

import java.text.*;
import java.util.Locale;
public class Align {
	public static void main(String[] args) throws ParseException {
		String[] sa = {"111,234", "222.5678"};
		NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
		nf.setMaximumFractionDigits(3);
		for(String s: sa) 
			System.out.println(nf.parse(s));
	}
}
