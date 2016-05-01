package string.split;

public class StringSplit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		//OK replace using "." char 
String sep ="SEARCH_TIUDB_RESP:";
		
		String strin ="adaaaaaaaaSEARCH_TIUDB_RESP:cccccccccccc";
		String[] split = strin.split(sep);
		String string = split[0];
		
		String ordId ="001021-0001";
		String[] splitN = ordId.split("-");
		String stringN = split[0];
		
		String ordId2 ="0010210001";
		String[] splitN2 = ordId2.split("-");
		String stringN2 = splitN2[0];
		
		//OK split using "." char 
		String ordId3 ="0010.21.0.001";
		String[] splitN3 = ordId3.split("\\.");
		String stringN3 = splitN3[0];
		
		//KO split using . regex char --> return an empty array
		String ordId4 ="0010210001";
		String[] splitN4 = ordId4.split(".");
		String stringN4 = splitN3[0];
		
		String ordId5 ="0,0,1,0,21";
		System.out.println(""+ordId5.split(",").length);
		
		String strWSpaces = "A a a  b b b  c c c";
		String[] split2 = strWSpaces.split(" ");
		System.out.println(""+split2.length);
	}

}
