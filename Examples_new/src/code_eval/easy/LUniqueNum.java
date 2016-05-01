package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class LUniqueNum {
	
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;

		while ((line = in.readLine()) != null) {
			try {
				if(line.length()==0){
					continue;
				}
				String[] nums = line.split(" ");
				TreeMap <Integer,Integer> numM  = new TreeMap <Integer,Integer> ();
				
				for(int idx =0;idx<nums.length;idx++){
					Integer num = Integer.valueOf(nums[idx]);
					Integer occ = numM.get(num);
					if(occ==null){
						numM.put(num,1);
					}else {
						numM.put(num,++occ);
					}
					
				}
				Integer lowestN  =0;
				
				for (Map.Entry<Integer, Integer>entry :  numM.entrySet()){
					if(entry.getValue().equals(1)){
						lowestN =entry.getKey();
						break;
					}
				}
				
				if (!lowestN.equals(0)){
					for(int idx =0;idx<nums.length;idx++){
						if(nums[idx].equals(lowestN.toString())){
							idx++;
							System.out.println(""+idx);
							break;
						}
					}
				}else 				
					System.out.println("0");
			
				
			}catch (Exception exc) {
				System.out.println("invalid line");
				continue;
			}
		}

	}

}
