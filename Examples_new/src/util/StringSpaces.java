package util;

import java.util.ArrayList;



public class StringSpaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str_ini = " pippo ppl ";
		String resiProbeName = "GTWM TP3 Module";
		String normalStr = "asfasdf ";
		
		String cronExpr = "0 00 0/1 * * ?";
		
		if(str_ini.indexOf(" ")!=-1) {
			System.out.println(str_ini);
			System.out.println(str_ini.trim());
			System.out.println(str_ini.trim().replace(" ", "_"));
		}
		
		if(resiProbeName.indexOf(" ")!=-1) {
			System.out.println(resiProbeName);
			System.out.println(resiProbeName.trim());
			System.out.println(resiProbeName.trim().replace(" ", "_"));
		}
		if(normalStr.indexOf(" ")!=-1) {
			System.out.println(normalStr);
			System.out.println(normalStr.trim());
			System.out.println(normalStr.trim().replace(" ", "_"));
		}
		int indexOf = cronExpr.indexOf("/");
		if(indexOf!=-1) {
			String substring = cronExpr.substring(indexOf+1,indexOf+2);
			System.out.println(substring);
			Integer.valueOf(substring);
		}
			

	}
	
	
	
	

}
