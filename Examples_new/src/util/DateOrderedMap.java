package util;

import java.util.Calendar;
import java.util.TreeMap;


public class DateOrderedMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		TreeMap<Long, MyCl> myMap3 = new TreeMap<Long, MyCl> ();
		
		Calendar calInst1 = Calendar.getInstance();
		calInst1.set(2010, 11, 11);
		MyCl myObj1 = new MyCl("2010",calInst1.getTime());
		myMap3.put(calInst1.getTimeInMillis(), myObj1);
		
		
		Calendar calInst2 = Calendar.getInstance();
		calInst2.set(2009, 11, 11);
		MyCl myObj2 = new MyCl("2009",calInst2.getTime());
		myMap3.put(calInst2.getTimeInMillis(), myObj2);
		
		Calendar calInst3 = Calendar.getInstance();
		calInst3.set(2001, 11, 11);
		MyCl myObj3 = new MyCl("2001",calInst3.getTime());
		myMap3.put(calInst3.getTimeInMillis(), myObj3);
		int index =0;
		for(Long timestamp :myMap3.keySet()) {
			System.out.println(" date "+index+", key time stamp:"+timestamp+", value: "+ ((MyCl)myMap3.get(timestamp)).getName()+", "+((MyCl)myMap3.get(timestamp)).getDate());
			index++;
		}
	}
	
	
	

}
