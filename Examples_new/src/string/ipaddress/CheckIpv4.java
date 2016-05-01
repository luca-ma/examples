package string.ipaddress;

import org.apache.commons.validator.routines.InetAddressValidator;

public class CheckIpv4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InetAddressValidator validator = InetAddressValidator.getInstance();
		boolean valid = validator.isValid("10.10.1.1");
		valid = validator.isValid("300.10.1.1");
		System.out.println(valid);
	}

}
