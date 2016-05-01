package string;

public class StringLimit {

	public static void main(String[] args) {
		int len = 100;
		String strIniStr ="Broadsoft generic error - VPBX_ERROR_MESSAGE: [Warning 4404] Could not authorize service(s).  Please verify that the service(s) is available to be authorized and is in sufficient quantities.  The service(s) not authorized are: basic.";
		StringBuilder strIni = new StringBuilder(strIniStr);
		StringBuilder strOut = new StringBuilder();
		if(strIni.toString().endsWith(".")) {
			strIni.deleteCharAt(strIni.length()-1);
		}
		if (strIni.length()>len) {
			strOut= strIni.delete(strIni.lastIndexOf("."),strIni.length());
			if(strOut.length()>len) {
				strOut.delete(len-1,strIni.length());//failed;
			}
		}
	System.out.println(""+strOut);
	System.out.println(""+strOut.length());
	}
		
		
	
}
