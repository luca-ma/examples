package util;

import java.util.ArrayList;



public class StrinReplace {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str_ini = SD_DENYTRAP_XML;
		
		String repStr = str_ini.replaceAll("138.132.45.70", "prova");
		String replaceAll = repStr.replaceAll("0341216044", "provaNUm");
		System.out.println(replaceAll);
		
		String fileName1   = "ccme9.xml.gz";
		String fileName2   = "ccme9_old.xml.gz";
		
		System.out.println(fileName1.replaceFirst(".xml", "_old.xml"));
		System.out.println(fileName2.replaceFirst(".xml", "_old.xml"));
		
	}
	
	
	
	private static final String SD_DENYTRAP_XML ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        +"<event xmlns=\"http://xmlns.opennms.org/xsd/event\">"
        +"<dbid xmlns=\"\">184</dbid>"                       
        +"<uei xmlns=\"\">communication/interactiveMedia/MRF/LAN/LANInterfaceFailed</uei>"
        +"<source xmlns=\"\">trapd</source>"
        +"<nodeid xmlns=\"\">8</nodeid>"
        +"<time xmlns=\"\">Tuesday, July 13, 2010 2:11:58 PM GMT</time>"
        +"<host xmlns=\"\">138.132.14.99</host>"
        +"<interface xmlns=\"\">138.132.1.1</interface>"
        +"<snmphost xmlns=\"\">138.132.45.70</snmphost>"
        +" <snmp>"
        +"<id xmlns=\"\">0001</id>"
        +"<version xmlns=\"\">v2</version>"
        +"<specific xmlns=\"\">5</specific>"
        +"<generic xmlns=\"\">6</generic>"
        +"<community xmlns=\"\">public</community>"
        +"<time-stamp xmlns=\"\">0</time-stamp>"
        +"</snmp>"
        +"<parms>"
        	+"<parm>"
        		+"<parmName xmlns=\"\">0001</parmName>"
        		+"<value type=\"OctetString\" encoding=\"text\">1.1.1.1</value>"
        	+"</parm>"
        	+"<parm>"
    		+"<parmName xmlns=\"\">0001<parmName>"
    		+"<value type=\"OctetString\" encoding=\"text\">realm</value>"
    	+"</parm>"+"<parm>"
		+"<parmName xmlns=\"\">0001</parmName>"
		+"<value type=\"OctetString\" encoding=\"text\">sip:0341216044@wifi.apt.telecomitalia.it;tag=as5c546842</value>"
	+"</parm>"
+"</parms>"
+"<descr xmlns=\"\">&lt;p&gt; LAN Connctivity Lost &lt;/p&gt;</descr>"
+"<logmsg notify=\"true\" dest=\"logndisplay\">message Tmp</logmsg>"
+"<severity xmlns=\"\">Critical</severity>"
+"</event>";



}
