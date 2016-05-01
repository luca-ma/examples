package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;


public class HappyNumber {
	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			try {			
				if (line.trim().length()==0){
					continue;
				}
				if (line.trim().equals("1")){
					System.out.println("1");
					continue;
				}
				
				StringBuilder numString = new StringBuilder(line.trim());
				Boolean notFinished =true;
				HashSet<Long> cycle = new HashSet<Long>();
				while (notFinished && cycle.add (Long.valueOf(numString.toString()))){
					Integer sumOfSquares =0;
					for(int idx =0 ; idx <numString.length() ; idx++ ) {
						Integer digit = Integer.valueOf(numString.substring(idx, idx+1));
						sumOfSquares += digit*digit;
					}
					StringBuilder newNumStr = new StringBuilder (String.valueOf(sumOfSquares));
					if(newNumStr.toString().equals("1")){
						//System.out.println("1");
						notFinished=false;
						//					}else if ((newNumStr.toString().contains("1"))){
						//						System.out.println("0");
						//						notFinished=false;
					}
						numString=newNumStr;
					
				}
				if(numString.toString().equals("1")){
					System.out.println("1");
				}else {
					System.out.println("0");
				}
				
			}catch (Exception exc) {
				System.out.println("invalid line");
				continue;
			}

			
		}


	}

}
