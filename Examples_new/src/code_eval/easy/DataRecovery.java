package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class DataRecovery {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			
				
			    String[] numbers= line.split(";")[1].split(" ");
			    String[] words= line.split(";")[0].split(" ");
			    String[] modNum = line.split(";")[1].split(" ");;
			   Integer lostNumber = getLostNumber(modNum);
				System.out.println(lostNumber);
				TreeMap<Integer, String> wordsOrdered = new TreeMap<Integer, String>();
			    
				for(int idx =0 ; idx < numbers.length; idx++) {
					wordsOrdered.put(Integer.valueOf(numbers[idx]), words[idx]);
				}
				wordsOrdered.put(lostNumber, words[words.length-1]);
				
				StringBuilder outStr = new StringBuilder();

				for (Map.Entry<Integer, String> entry : wordsOrdered.entrySet()){
						outStr.append(entry.getValue()).append(" ");
						
				}
				
				System.out.println(outStr);


			
		}
	}
	
	public static Integer getLostNumber (String[] numbers) {
		
		Integer prevNum = null;
		Integer maxNum = 0;
		TreeSet<Integer> ordNumSet = new TreeSet<Integer> ();
		for(String num : numbers) {
			ordNumSet.add(Integer.valueOf(num));
		}
		for (Integer num :ordNumSet) {
			if(prevNum!=null) {
				if (!num.equals(prevNum+1)){
					return prevNum+1;
				}
			}
			if(num> maxNum) {
				maxNum= num;
			}
			prevNum  = num;
					
		}
		return maxNum+1;
		
	}
}
