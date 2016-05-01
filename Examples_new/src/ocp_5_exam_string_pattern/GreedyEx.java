package ocp_5_exam_string_pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedyEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//EX1 * is greedy : match all as possible
		String regex = "C.*L";
		String instr = "CooLooLCuuLooC";
		Pattern p = Pattern.compile(regex); 
		Matcher m = p.matcher(instr);
		boolean b = false;
		while(b = m.find()) {
			System.out.println(m.start()+" "+m.group());
		}
		
		String regex2 = "C{1,5}L";
		
		Pattern p2 = Pattern.compile(regex); 
		Matcher m2 = p.matcher(instr);
		boolean b2 = false;
		while(b2 = m2.find()) {
			System.out.println(m2.start()+" "+m2.group());
		}

	}

}
