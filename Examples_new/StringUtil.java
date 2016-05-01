package util;

import java.util.ArrayList;



public class StringUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str_ini = "pippo ppl";
		String str1 ="TRUE ";
		String str2 ="TRUE";
		System.out.println(str1.trim().equalsIgnoreCase(str2));
		String preStr = "(";
		String suffStr = ")";
		String strMod= SurroundStringWithString (str_ini, preStr, suffStr);
		System.out.println(strMod);
		
//		String a = "***adfasdfadfa***bbbbbb***ccccc";
//		StringBuilder strB = new StringBuilder(a);
//		
//		String[] split = a.split("\\*\\*\\*");
		String a = "1,2,3";
	
		String[] split = a.split("\\*\\*\\*");
		
		ArrayList<String> normStr= new ArrayList<String>();
		for(int idx=0;idx<split.length;idx++) {
			if(split[idx].length()>0) {
				normStr.add("***"+split[idx]);
			}
		}
		int length = split.length;
	}
	
	public static String SurroundStringWithString(String strIni, String prefixStr, String suffixStr) {
		
		StringBuffer stBuf = new StringBuffer(strIni);
		stBuf.append(suffixStr);
		stBuf.insert(0,prefixStr);
		return(stBuf.toString());
		
	}
	
	

}
