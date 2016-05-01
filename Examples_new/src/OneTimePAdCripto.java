import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;


public class OneTimePAdCripto {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		
		String message ="attack at dawn";
		String cipher = "09e1c5f70a65ac519458e7e53f36";

		StringBuilder sb = new StringBuilder();
		String outStr ="";
		int sum =0;int temp=0;char c;
		for(int i = 0; i < message.length(); i++){
			sum = (message.charAt(i)  + cipher.charAt(i));
			if(sum>=155)
				temp = sum -90;
			else
				temp = sum -64;
			c =(char)temp;
			outStr +=c;
		}
		    
		System.out.println(outStr);
		
		String s = "a";
		byte[] b = s.getBytes("US-ASCII");
		System.out.println(b);
	}

}
