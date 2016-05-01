package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumOfIntegers {

	/**
	 * Print out the sum of integers read from a file.
	 * 
	 * The first argument to the program will be a text file containing a positive integer, one per line. e.g.

5
12

NOTE: For solutions in JavaScript, assume that there are 7 lines of input

Output sample:

Print out the sum of all the integers read from the file.
e.g.

17
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		Integer sum = 0;
		while ((line = in.readLine()) != null) {
			try {
				sum+= Integer.valueOf(line);
			}catch (NumberFormatException numExc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
		System.out.println(""+sum);
	}

	
}
