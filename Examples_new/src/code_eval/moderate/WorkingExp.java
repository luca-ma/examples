package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;


public class WorkingExp {
	public static SimpleDateFormat formatter = new SimpleDateFormat("MMM yyyy",Locale.ENGLISH);
   

	public static void main(String[] args) throws IOException, ParseException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		 
		while ((line = in.readLine()) != null) {
			
				List<Interval> intervalList = new ArrayList<Interval>();
				List<Interval> mergedInt = new ArrayList<Interval>();
			    String[] split = line.split(";");
			    for(String el:split) {
			    	intervalList.add(new Interval (formatter.parse(el.trim().split("-")[0]),formatter.parse(el.trim().split("-")[1])));
			    }
				
			    mergedInt.add(intervalList.get(0));
			    Boolean first = true;
			    for(Interval interval : intervalList) {
			    	if(first) {
			    		first = false;
			    		continue;
			    	}
			    	if(overlappedInterval(interval,mergedInt.get(0))) {
			    		mergedInt.set(0,mergeInterval(interval, mergedInt.get(0)));
			    	}else {
			    		mergedInt.add(interval);
			    	}
			    }
			    Integer duration=0;
			    for(Interval interval: mergedInt) {
			    	duration+= interval.getDurationMonths();
			    }
				System.out.println(duration/12);


			
		}
	}
	
	public static Boolean overlappedInterval (Interval I1 , Interval I2) {
		if((I2.iniDate.compareTo(I1.endDate)>0)||(I1.iniDate.compareTo(I2.endDate))>0) {
			return false;
		}else {
			return true;
		}
	}
	
	public static Interval mergeInterval(Interval I1 , Interval I2) {
		Date iniMerged;
		Date endMerged;
		
		if((I1.iniDate.compareTo(I2.iniDate)<=0)) {
			iniMerged =I1.iniDate;
		}else {
			iniMerged =I2.iniDate;
		}
		if((I2.endDate.compareTo(I1.endDate)>=0)) {
			endMerged =I2.endDate;
		}else {
			endMerged =I1.endDate;
		}
		return new Interval (iniMerged,endMerged);
	}
	
	
}

 class Interval {
	
	 Date iniDate;
	 Date endDate;
	 Interval(Date iniDate, Date endDate){
		 this.iniDate = iniDate;
		 this.endDate = endDate;
	 }
	 
	 public Integer getDurationMonths() {
		 
		 Calendar startCalendar = new GregorianCalendar();
		 startCalendar.setTime(iniDate);
		 Calendar endCalendar = new GregorianCalendar();
		 endCalendar.setTime(endDate);

		 int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
		 int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
		 return diffMonth;
	 }
	 public Integer getDurationY() {
		 return getDurationMonths()/12;
	 }
	 
	 
}
