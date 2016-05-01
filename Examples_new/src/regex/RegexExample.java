package regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			
//		Pattern pattern = Pattern.compile("[a-z,A-Z]?\\d*(/[a-z,A-Z]?)?\\d*");
//        Matcher matcher = pattern.matcher("c012345");
//        
//        boolean find = matcher.find();
//        System.out.println("OK:"+find);
//        
//        //String sipUriGen = "\"0733200332@wifi.apt.telecomitalia.it\" <sip:0733200332@wifi.apt.telecomitalia.it>;tag=ce7f746a-ff77-e111-80a2-001a646807a0";
//        String sipUriModGen = "qqqqqqqqqqqqsip:0733200332@aaaaaaaaaaaaasip:111@aawifi.apt.telecomitalia.it>;tag=ce7f746a-ff77-e111-80a2-001a646807a0";
//        
//        //find a SipUri
//        Pattern pattern2 = Pattern.compile("sip:[^:]*@");
//        Matcher matcher2 = pattern2.matcher(sipUriModGen);
//       int matchNum=1;
//        while(matcher2.find()) {
//        	  String substringWithMatch1 = sipUriModGen.substring(matcher2.start(),matcher2.end());
//              System.out.println("match"+matchNum+++": "+substringWithMatch1.substring(4, substringWithMatch1.length()-1));        
//        }
//        
        
        Pattern patternN = Pattern.compile("[|]");
        Matcher matcherN = patternN.matcher("|  ORIGIN DOMAIN  |  DEST DOMAIN  | ROUTING TYPE | TRANSLATION TYPE |");
        List<Integer>lenColumns = new ArrayList<Integer>();
        Integer prev =0;
        Integer curr = 1;
        while(matcherN.find()) {
        	int start = matcherN.start();
        	System.out.println("match"+start);  
        	if  (start>0){
        		int val = start - prev -1;
        		//System.out.println("add "+val); 
        		lenColumns.add(val);
        	}
        	
        	prev = matcherN.start();
        	
        }
        for(Integer colLen :lenColumns){
        	System.out.println("colLen : "+colLen);
        }
	}

}
