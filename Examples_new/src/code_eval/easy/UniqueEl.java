package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * You are given a sorted list of numbers with duplicates. Print out the sorted list with duplicates removed.
Input sample:

File containing a list of sorted integers, comma delimited, one per line. e.g.

1,1,1,2,2,3,3,4,4
2,3,4,5,5

Output sample:

Print out the sorted list with duplicates removed, one per line
e.g.

1,2,3,4
2,3,4,5
 * @author luca
 *
 */
public class UniqueEl {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			try {
				String[] numbers = line.split(",");
				Set<Integer> numSet = new TreeSet<Integer>();
				for(int idx =0 ; idx <numbers.length ; idx++ ) {
					numSet.add(Integer.valueOf(numbers[idx]));
				}
				System.out.println(formatLine(numSet));
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		}
	}
	
	private static String formatLine (Set<Integer> numbers) {
		StringBuilder result = new StringBuilder();
		for(Integer num :numbers) {
			result.append(num).append(",");
		}
		result.deleteCharAt(result.length()-1);
		return result.toString();
	}
	
}
