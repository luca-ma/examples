package chars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ascii {

	public static void main(String args[]) throws IOException{
//		BufferedReader buff = 
//				new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter the char:");
//		String str = buff.readLine();
//		for ( int i = 0; i < str.length(); ++i ){
//			char c = str.charAt(i);
//			int j = (int) c;
//			System.out.println("ASCII OF "+c +" = " + j + ".");
//		}
		
		String convInAScii = convInAScii("a");
		
		System.out.println("ASCII OF "+convInAScii);
		Integer valueOf = Integer.valueOf(convInAScii);
		String binary = Integer.toBinaryString(valueOf);
		System.out.println("Binary value of " + binary);
	}
	
	public static String convInAScii(String plainStr){
		StringBuilder ret = new StringBuilder();
		for ( int i = 0; i < plainStr.length(); ++i ){
			char c = plainStr.charAt(i);
			int j = (int) c;
			ret.append(String.valueOf(j));
		//	System.out.println("ASCII OF "+c +" = " + j + ".");
		}
		System.out.println("ASCII OF "+ plainStr+" = " + ret.toString() + ".");
		return ret.toString();
	}
	
	public static String convInASciiBin(String plainStr){
		StringBuilder ret = new StringBuilder();
		for ( int i = 0; i < plainStr.length(); ++i ){
			char c = plainStr.charAt(i);
			int j = (int) c;
			//ret.append(String.valueOf(j));
			ret.append(Integer.toBinaryString(Integer.valueOf(j)));
			//System.out.println("ASCII OF "+c +" = " + j + ".");
		}
		System.out.println("ASCII OF "+ plainStr+" = " + ret.toString() + ".");
		return ret.toString();
	}
}
