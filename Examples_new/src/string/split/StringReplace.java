package string.split;

public class StringReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String ordId3 ="0010.21.0.001";
		String splitN3 = ordId3.replaceFirst("\\.","");
		
		//KO split using . regex char --> return an empty array
		String ordId4 ="00102.10.001";
		String splitN4 = ordId4.replaceFirst(".","");
		System.out.println("replaceFirst with .:"+splitN4);
		
		String ordId5 =".0.2.20102.10.001";
		String splitN5 = ordId5.replaceFirst(".","");
		String splitN6 = ordId5.replaceFirst("\\.","");
		System.out.println("replaceFirst with .:"+splitN5);
		System.out.println("replaceFirst with \\.:"+splitN6);
	}

}
