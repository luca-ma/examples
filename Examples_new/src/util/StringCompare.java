package util;

public class StringCompare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String a1 = new String( "a");
		
		String a2 =new String ("a");
		
		if(a1==a2) {
			System.out.println("a1==a2");
		}else {
			System.out.println("a1!=a2");
		}
		if(a1.equals(a2)) {
			System.out.println("a1.equals (a2)");
		}else {
			System.out.println("!a1.equals (a2)");
		}

	}

}
