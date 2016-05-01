package util;

public class SipUtValidate {
	
	public static final String sipUri1 = "<sip:0341216044@wifi.apt.telecomitalia.it>;tag=as5c546842";
	
		/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		String[] split = sipUri1.split("@");
		String[] split2 = split[0].split(":");
		
		System.out.println("NUm:"+split2[1]);

	}

}
