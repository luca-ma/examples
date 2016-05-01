package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class NumberPairs {


	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				
				String[] split = line.split(";");
				Integer sum = Integer.valueOf(split[1]);
				
				String[] numbers = split[0].split(",");
				// buid stringBuilder
				ArrayList<Integer> nums =  new ArrayList<Integer> ();
				for(int idx =0; idx < numbers.length;idx++) {
					nums.add(Integer.valueOf(numbers[idx]));
				}
				
				String retStr  = popSumPairs(nums, new StringBuilder(), sum);
				System.out.println(retStr);;


			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
			

		}
	}
	
	public static String popSumPairs (ArrayList<Integer> nums, StringBuilder partialList, Integer sum) {
		if (nums.size()==1) {
			if(partialList.length()==0) {
				return ("NULL");
			}else {
				return partialList.deleteCharAt(partialList.length()-1).toString();
			}
			
		}else {
			Integer firstNum = nums.get(0);
			for(int idx =1; idx <nums.size();idx++) {
				Integer partS = firstNum+ nums.get(idx);
				if(partS.equals(sum)) {
					partialList.append(firstNum).append(",").append(nums.get(idx)).append(";");
				}
			}
			Integer remove = nums.remove(0);
			String retStr = popSumPairs(nums, partialList,sum);
			return retStr;
		}
		
	}


}
