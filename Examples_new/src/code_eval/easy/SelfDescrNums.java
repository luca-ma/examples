package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Challenge Description:

A number is a self-describing number when (assuming digit positions are labeled 0 to N-1), the digit in each position is equal to the number of times that that digit appears in the number.
Input sample:

The first argument is the pathname to a file which contains test data, one test case per line. Each line contains a positive integer. Each line is in the format: N i.e. a positive integer eg.

2020
22
1210
 * @author luca
 *
 */
public class SelfDescrNums {
	
	public static void main(String[] args) throws IOException {

	File file = new File(args[0]);
	BufferedReader in = new BufferedReader(new FileReader(file));
	String line;
	while ((line = in.readLine()) != null) {
		try {
			if(line.length()==0)
			{
				System.out.println("invalid line....skip it!");
				continue;
			}
			Map<Integer, Integer> buildOccurenceMap = buildOccurenceMap (line);
			if (isSelfDescNum(buildOccurenceMap, line)){
				System.out.println(""+1);
			}else {
				System.out.println(""+0);
			}
			
		}catch (Exception exc) {
			//exc.printStackTrace();
			System.out.println("invalid line....skip it!");
			continue;
		}
		
	}
	}
	
	private static Map<Integer,Integer> buildOccurenceMap (String numStr){
		Map<Integer,Integer> occMap = new TreeMap <Integer,Integer> ();
		
		StringBuilder numString = new StringBuilder(numStr.trim());
		for(int idx =0 ; idx <numString.length() ; idx++ ) {
			Integer occurence = occMap.get(Integer.valueOf(numString.substring(idx, idx+1)));
			if (occurence==null){
				occMap.put(Integer.valueOf(numString.substring(idx, idx+1)),Integer.valueOf(1));
			}else {
				occurence++;
				occMap.put(Integer.valueOf(numString.substring(idx, idx+1)),occurence);
			}
		}
		
		return occMap;
	}
	
	private static Boolean isSelfDescNum (Map<Integer,Integer> numMap, String num){
		
		StringBuilder numString = new StringBuilder(num.trim());
		for(int idx =0 ; idx <numString.length() ; idx++ ) {
				Integer digit = Integer.valueOf(numString.substring(idx, idx+1));
				if(numMap.get(idx)==null){
					if (digit.equals(0)){
						continue;
					}else {
						return false;
					}
				}
							
				if (! numMap.get(idx).equals(digit)){
					return false;
				}
		
		}
		return true;
		
	}
	


}
