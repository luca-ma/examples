package chars;

import java.util.Arrays;


public class CharUtils {
	public static void main(String[] args) {
		

		char[] chars = new char[7];
		Arrays.fill(chars, 'F');
		String buildStr =String.valueOf(chars);
		  System.out.println( "str :"+ buildStr);
	}
}
