package ocp_5_exam_string_pattern;

public class StringFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		boolean b = true;
		int i1 =100;
		int i2 = -200;
		double d = -23.20;
		char ch = 'm';
		String str ="hello";
		
		System.out.printf("\"%-+5d4\"", i1);
		System.out.println("");
		System.out.printf("\"%(d+10\"", i2);
		System.out.println("");
		System.out.printf("\"$%.2f\"", d);
		System.out.println("");
		System.out.printf("\"%s world\"", str);
		System.out.println("");
		System.out.printf("\"%2$c + %1$d\"", i1, ch);
		

	}

}
