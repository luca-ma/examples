package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;


public class FindASquare {

	public static TreeSet<Integer> ascSet = new  TreeSet<Integer>();
	public static TreeSet<Integer> ordSet = new  TreeSet<Integer>();
	
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				Boolean square = false;
				
				String[] couples = line.split(", ");
				ascSet.clear();
				ordSet.clear();
				for(int idx =0; idx < couples.length; idx++) {
					//System.out.println(couples[idx]);
					String nums = couples[idx].substring(1,couples[idx].length()-1);
					//System.out.println(nums);
					String[] numCouple = nums.split(",");
					Integer asc = Integer.valueOf(numCouple[0]);
					Integer ord = Integer.valueOf(numCouple[1]);
					ascSet.add(asc);
					ordSet.add(ord);
				}
				if((ascSet.size()==2)&&(ordSet.size()==2)) {
					Integer side1 = ascSet.last()-ascSet.first();
					Integer side2 = ordSet.last()-ordSet.first();
					if(side1.equals(side2)) {
						square = true;
					}
				} 
				
//				Integer sum = Integer.valueOf(split[1]);
//				
//				String[] numbers = split[0].split(",");
//				// buid stringBuilder
//				ArrayList<Integer> nums =  new ArrayList<Integer> ();
//				for(int idx =0; idx < numbers.length;idx++) {
//					nums.add(Integer.valueOf(numbers[idx]));
//				}
				
				System.out.println(square);;


			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
			

		}
	}
	


}
