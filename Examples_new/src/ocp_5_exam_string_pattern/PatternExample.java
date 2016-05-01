package ocp_5_exam_string_pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String regex = "Co?L";
		String instr = "CL";
		Pattern p = Pattern.compile(regex); 
		Matcher m = p.matcher(instr);
		boolean b = false;
		while(b = m.find()) {
			System.out.println(m.start()+" "+m.group());
		}
		String replace = "X";
		String val = m.replaceAll(replace);
		System.out.println(val);

	}

}
