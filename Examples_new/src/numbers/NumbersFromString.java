package numbers;

public class NumbersFromString {

	static String num1 = "1  ";
	static String num2 = "10 ";
	static String num3 = "   ";
	static String num4 = "111";
	
	static String num5 = "1A ";
	public static void main(String[] args) {
		
		String n1 = stringFromNum1 (num1.trim());
		String n2 = stringFromNum1 (num2.trim());
		String n3 = stringFromNum1 (num3.trim());
		String n4 = stringFromNum1 (num4.trim());
		String n5 = stringFromNum1 (num5.trim());
		System.out.println("num 1:"+n1);
		System.out.println("num 2:"+n2);
		System.out.println("num 3:"+n3);
		System.out.println("num 4:"+n4);
		System.out.println("num 5:"+n5);
//		String substring1 = n1.substring(0,n1.length()-1);
//		String substring2 = n1.substring(0,n1.length()-2);
//		//String substring3 = n1.substring(0,n1.length()-3);
//		System.out.println("num exc:"+substring1);
//		System.out.println("num exc:"+substring2);
	}
	
	private static String stringFromNum (String numIni) {
		
		
			
			for(int idx=0; idx<3;idx++) {
				String numres="";
				try {
				numres = numIni.substring(0,numIni.length()-idx);
				System.out.println("num exc:"+numres);
				
				Integer valueOf = Integer.valueOf(numres);
				return numres;
				}catch (NumberFormatException numExc) {
					System.out.println("num exc:"+numres);
				}
			}
		
		return "";
	}
	
	private static String stringFromNum1 (String numIni) {
		
		StringBuilder strB = new StringBuilder(numIni);
		if(strB.length()==0)
			return "";
		//char charAt = strB.charAt(1);
		//Integer valueOf2 = Integer.valueOf(charAt);
		while (strB.length()> 0){
			try {
				Integer valueOf = Integer.valueOf(strB.toString());
				return strB.toString();
			}catch (NumberFormatException numExc) {
				System.out.println("num exc:"+strB);
				strB.deleteCharAt(strB.length()-1);
			}
		}
	
	return "";
}
}
