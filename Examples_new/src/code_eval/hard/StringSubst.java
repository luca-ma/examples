package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class StringSubst {

	static StringBuilder strOut =null;
	static TreeSet<String> strSet =null;
	static ArrayList<Interval> intervals =null;
	static StringSubst inst =null;

	public static void main(String[] args) throws IOException {

		 
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			
			try {
				intervals = new ArrayList<Interval>();
				inst  =new StringSubst();
				String[] split = line.split(";");
				StringBuilder iniStr = new StringBuilder(split[0]);
				String[] substitution = split[1].split(",");
				
				for(int idxSubst =0; idxSubst <=substitution.length-2; idxSubst+=2){
					String searchStr = substitution[idxSubst];
					String replaceStr = substitution[idxSubst+1];
					//int searcIdx = iniStr.indexOf(searchStr);

					replaceAll(iniStr, searchStr, replaceStr);

				}
				
				
					System.out.println(iniStr);
			}catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	public static void replaceAll(StringBuilder builder, String from, String to)
	{
	    int index = builder.indexOf(from);
	    while (index != -1)
	    {
	    	if (!isInIntervals(index)&&(!isInIntervals(index+from.length()-1))){
	    		builder.replace(index, index + from.length(), to);
	  	        addInterval(index, index + to.length()-1);
	  	        index += to.length(); // Move to the end of the replacement
	    	}else {
	    		index++;
	    	}
	         index = builder.indexOf(from, index);
	    }
	}
	
	public static Boolean isInIntervals(Integer startCheckPoint){
		for (Interval interval: intervals){
			if(interval.isInInterval(startCheckPoint)){
				return true;
			}
		}
		return false;
	}
	
	public static void addInterval (Integer startIdx, Integer stopIdx){
		Interval interval = inst.new Interval(startIdx,stopIdx);
		intervals.add(interval);
	}
	
	
	public class Interval  {
		private Integer intervalStart =0;
		private Integer intervalStop =0;
		public Interval(Integer intervalStart, Integer intervalStop) {
			super();
			this.intervalStart = intervalStart;
			this.intervalStop = intervalStop;
		}
		
		public Boolean isInInterval(Integer val){
			if((val>=intervalStart)&&(val<=intervalStop)){
				return true;
			}else {
				return false;
			}
		}
	}
	
	 
}
