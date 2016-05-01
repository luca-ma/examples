package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
You are given two sorted list of numbers(ascending order). The lists themselves are comma delimited and the two lists are semicolon delimited. Print out the intersection of these two sets.
Input sample:

File containing two lists of ascending order sorted integers, comma delimited, one per line. e.g.

1,2,3,4;4,5,6
7,8,9;8,9,10,11,12

Output sample:

Print out the ascending order sorted intersection of the two lists, one per line
e.g.

4
8,9 
*/

public class SetIntersection {
	

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			try {
				String[] numLists = line.split(";");
					Set<String> numSetInter = new TreeSet<String>();
				String[] numList0 = numLists[0].split(",");
				String[] numList1 = numLists[1].split(","); 
				for(int idx0 =0 ; idx0 <numList0.length ; idx0++ ) {
					for(int idx1 =0 ; idx1 <numList1.length ; idx1++ ) {
						if (numList0[idx0].equals(numList1[idx1])){
							numSetInter.add(numList0[idx0]);
						}
							
					}
					
				}
				System.out.println(formatLine(numSetInter));
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		}
	}
	
	private static String formatLine (Set<String> el) {
		StringBuilder result = new StringBuilder();
		for(String num :el) {
			result.append(num).append(",");
		}
		result.deleteCharAt(result.length()-1);
		return result.toString();
	}
	

}
