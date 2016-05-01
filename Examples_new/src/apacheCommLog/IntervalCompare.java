package apacheCommLog;

import java.util.Calendar;

import org.apache.commons.lang.math.LongRange;
import org.apache.commons.lang.math.Range;

public class IntervalCompare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		Calendar intBeginCal = Calendar.getInstance();
		intBeginCal.set(1999, 10, 10);
		Calendar internalBeginDate =intBeginCal;
		
		Calendar intEndCal = Calendar.getInstance();
		intEndCal.set(2003, 10, 10);
		Calendar internalEndDate =intEndCal;
		
		Calendar extBeginCal = Calendar.getInstance();
		extBeginCal.set(2001, 10, 10);
		Calendar externalBeginDate =extBeginCal;
		
		Calendar extEndCal = Calendar.getInstance();
		extEndCal.set(2006, 10, 10);
		Calendar externalEndDate =extEndCal;
		//(instance.set(2010, 10, 10)).;
		//Date externalBeginDate =null;
	

		Range externalRange = new LongRange(externalBeginDate.getTime().getTime(),externalEndDate.getTime().getTime());
		long extRange = externalEndDate.getTime().getTime()-externalBeginDate.getTime().getTime();
		System.out.println("extRange: "+ extRange);
		
		Range internalRange = new LongRange(internalBeginDate.getTime().getTime(),internalEndDate.getTime().getTime());
		long intRange = internalEndDate.getTime().getTime()-internalBeginDate.getTime().getTime();
		System.out.println("intRange: "+ intRange);
		
		if(externalRange.containsRange(internalRange)) {
			System.out.println("extRange contains intRange");
		}else {
			System.out.println("extRange doesn't contain intRange");
		}
		
		if(externalRange.overlapsRange(internalRange)) {
			System.out.println("extRange overlaps intRange");
		}else {
			System.out.println("extRange doesn't overlap intRange");
		}

	}

}
