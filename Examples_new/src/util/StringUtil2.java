package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;



public class StringUtil2 {
	private static final String TIME_HOUR_FMT = "yyyyMMdd-HHmmss";
	private static TreeMap <Date, String> bckFileMap = new TreeMap <Date, String>();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str_1 = "backup_SNODO_SBC_20110209-130333.gz";
		String str_2 = "backup_INEM_SBC_20110209-120333.tar.gz";
		String str_3 = "backup_INEM_SBC_20120209-120333.tar.gz";
		
		
		String str = str_1.substring(str_1.lastIndexOf("_")+1,str_1.indexOf("."));
		String str2 = str_2.substring(str_2.lastIndexOf("_")+1,str_2.indexOf("."));
		String str3 = str_3.substring(str_2.lastIndexOf("_")+1,str_2.indexOf("."));
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_HOUR_FMT);
		try {
			Date date1 = simpleDateFormat.parse(str);
			
			Date date2 = simpleDateFormat.parse(str2);
			Date date3 = simpleDateFormat.parse(str3);
			
			bckFileMap.put(date1, str);
			bckFileMap.put(date2, str2);
			bckFileMap.put(date3, str3);
			
			for(Date fileData: bckFileMap.keySet()) {		
				String  fileName = bckFileMap.get(fileData);
				System.out.println("fileName = "+fileName);
			}
			
			if(date1.before(date2)) {
				String pipp = "nul";
			}else {
				String pipp = "nul";
			}
			
			
			String strDate = simpleDateFormat.format(date3);
			System.out.println("strDate = "+strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public static String SurroundStringWithString(String strIni, String prefixStr, String suffixStr) {
		
		StringBuffer stBuf = new StringBuffer(strIni);
		stBuf.append(suffixStr);
		stBuf.insert(0,prefixStr);
		return(stBuf.toString());
		
	}

}
