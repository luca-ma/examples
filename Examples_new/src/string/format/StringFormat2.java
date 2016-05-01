package string.format;

import java.util.Locale;

public class StringFormat2 {

	public static void main(String[] args) {

		
		//System.out.printf("%,(d", 99887766);
		
		
//		Locale.setDefault(Locale.ITALY);
//		System.out.printf("%(,d", -99887766);
//		Locale.setDefault(Locale.US);
//		System.out.printf("%(,d", -99887766);
		
		int width = 20;
	    String s = "level";
	    
	    int padSize = width - s.length();
	    int padStart = s.length() + padSize / 2;

	    s = String.format("%" + padStart + "s", s);
	   // s = String.format("%-" + width  + "s", s);
	    
	    System.out.println(s.length());
	    //assertEquals("       level        ", s);
	    System.out.println("|"+s+"|");
	    System.out.println(s.indexOf("l"));
	    System.out.println(s.lastIndexOf("l"));

	}

}
