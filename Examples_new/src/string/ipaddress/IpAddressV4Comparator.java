package string.ipaddress;

import java.util.Comparator;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class IpAddressV4Comparator implements Comparator<String>{
	
	static Logger logger = LogManager.getLogger(IpAddressV4Comparator.class);
	
	@Override
	public int compare(String ipAdd1, String ipAdd2) {
		if(ipAdd1==null && ipAdd2==null)
			return 0;
		if(ipAdd1==null && ipAdd2!=null)
			return -1;
		if(ipAdd1!=null && ipAdd2==null)
			return 1;
		//check if ipAdd1 and ipAdd2 are valid ipAddresses
		try {
			Utility.normalizeIp(ipAdd1);
			Utility.normalizeIp(ipAdd2);	
		}catch (IllegalArgumentException exc) {
			logger.warn("invalid ipAddress");
			return 0;
		}		
		return toNumeric(ipAdd1).compareTo(toNumeric(ipAdd1));
	}

	private Long toNumeric(String ip) {
        Scanner sc = new Scanner(ip).useDelimiter("\\.");
        
        return 
            (sc.nextLong() << 24) + 
            (sc.nextLong() << 16) + 
            (sc.nextLong() << 8) + 
            (sc.nextLong()); 
    }
	
	private static class  Utility {
		private static String normalizeIp(String ipAdd) {
			return ipAdd;
		}
	}
}
