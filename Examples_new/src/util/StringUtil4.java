package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class StringUtil4 {
	private static final String TIME_HOUR_FMT = "yyMMddHHmmss";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "Morosi.110216125311.txt";
		
		String[] fileToken = fileName.split("\\.");
		if(fileToken.length!=3) {
			System.out.println("invalid");
		}else {
			if (fileToken[0].equals("Morosi")) {				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_HOUR_FMT);
				try{
					Date date = simpleDateFormat.parse(fileToken[1]);	
					if(!fileToken[2].equals("txt") ){
						System.out.println("invalid fileName suffix:"+fileToken[2]);
						
					}else {
						System.out.println("OK valid fileName:"+fileName);
						
					}
				}catch (ParseException parseExc) {
					System.out.println("invalid fileName dateHour:"+fileToken[1]);
					
				}
			}else {
				System.out.println("invalid fileName prefix:"+fileToken[0]);
			}
		}
		
	}
	
	
}
