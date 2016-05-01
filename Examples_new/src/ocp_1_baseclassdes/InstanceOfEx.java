package ocp_1_baseclassdes;

public class InstanceOfEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = null;
		String str2 ="";
		if(str instanceof Object) // NULLCHK
		System.out.println("str is Object");
		else
		System.out.println("str is not Object");
	
		if(str2 instanceof Object) // NULLCHK
			System.out.println("str2 is Object");
			else
			System.out.println("str2 is not Object");
		
		//if (str instanceof java.util.Date) not compile!!
	}

}
