package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
		Pattern pattern = Pattern.compile("[a-z,A-Z]?\\d*(/[a-z,A-Z]?)?\\d*");
        Matcher matcher = pattern.matcher("c012345");
        
        boolean find = matcher.find();
        System.out.println("OK:"+find);
        
        //String sipUriGen = "\"0733200332@wifi.apt.telecomitalia.it\" <sip:0733200332@wifi.apt.telecomitalia.it>;tag=ce7f746a-ff77-e111-80a2-001a646807a0";
        String sipUriModGen = "qqqqqqqqqqqqsip:0733200332@aaaaaaaaaaaaasip:111@aawifi.apt.telecomitalia.it>;tag=ce7f746a-ff77-e111-80a2-001a646807a0";
        
        //find a SipUri
        Pattern pattern2 = Pattern.compile("sip:[^:]*@");
        Matcher matcher2 = pattern2.matcher(sipUriModGen);
       int matchNum=1;
        while(matcher2.find()) {
        	  String substringWithMatch1 = sipUriModGen.substring(matcher2.start(),matcher2.end());
              System.out.println("match"+matchNum+++": "+substringWithMatch1.substring(4, substringWithMatch1.length()-1));        
        }
        
           
	}

}
