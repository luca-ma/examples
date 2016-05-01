package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DecNums {


	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}

			System.out.println(numDecod(line));
		}

	}


	public static int numDecod(String str) {
		ArrayList<Integer> sols = new ArrayList<Integer>();
		if(str.length() != 0)
			recursion(str, sols);
		return sols.size();
	}

	private static void recursion(String s, ArrayList<Integer> solutions) {
		if(s.length() == 0){
			solutions.add(1);
		} else {
			int value = Character.getNumericValue(s.charAt(0));
			if(value > 0 && value <= 9) {
				recursion(s.substring(1), solutions);
			}

			if(s.length() >= 2) {
				int value1 = Character.getNumericValue(s.charAt(0));
				int value2 = Character.getNumericValue(s.charAt(1));
				if(value1 == 1 && value2 >= 0 && value2 <= 9) {
					recursion(s.substring(2), solutions);
				} else if(value1 == 2 && value2 >= 0 && value2 <= 6) {
					recursion(s.substring(2), solutions);
				}
			}
		}
	}
}
