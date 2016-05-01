package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SubStrEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String TIME_HOUR_FMT = "yyyyMMdd-HHmmss";
		String prova ="HHHOOOOOTT";
		StringBuilder strB = new StringBuilder("HHHOOOOOTT");
		
		String res = prova.substring(0,3);
		strB.delete(0,3);
		strB.delete(0,5);

		
		String num ="02.22222.22";
		String subStr = num.substring(0,num.length()-2);
		
		String fileNameIniComplete = "ccme11.xml.gz";
		Date fileDate = Calendar.getInstance().getTime();
		StringBuilder fileIni = new StringBuilder(fileNameIniComplete);
		
		String fileNamePartIni= fileNameIniComplete.substring(0, fileNameIniComplete.indexOf("."));
		String fileNamePartEnd= fileNameIniComplete.substring(fileNameIniComplete.indexOf("."));
		
		String newFileNameSuffix = "_"+new SimpleDateFormat(TIME_HOUR_FMT).format(fileDate);
		
		fileIni.insert(fileNameIniComplete.indexOf("."),newFileNameSuffix);
		String fileNameEndComplete = fileNamePartIni+ newFileNameSuffix+fileNamePartEnd;
		System.out.println(""+fileNameEndComplete);
		
		System.out.println(""+fileIni);
		
		String numN ="02.22222.2z";
		String subStrN = numN.substring(numN.length()-1);
		System.out.println(""+subStrN);
	}

}
