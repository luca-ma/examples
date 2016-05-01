package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumOfDigits {

	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			try {
				Integer sumOfDigits = 0;
				StringBuilder numString = new StringBuilder(line.trim());
				for(int idx =0 ; idx <numString.length() ; idx++ ) {
					sumOfDigits+= Integer.valueOf(numString.substring(idx, idx+1));
				}
				System.out.println(""+sumOfDigits);
				
			}catch (NumberFormatException numExc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		}
	}

}
