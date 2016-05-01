package util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpAddUtil {

	
	public static Boolean isValidIp(String ipAdd) {
		
		try {
			
			InetAddress.getByName(ipAdd);
			return true;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
