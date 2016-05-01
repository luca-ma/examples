package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CompressedSeq {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
	File file = new File(args[0]);
	BufferedReader in = new BufferedReader(new FileReader(file));
	String line;
	while ((line = in.readLine()) != null) {
		if(line.length()==0) {
			continue;
		}
		StringBuilder outStr = new StringBuilder();
		String[] lineElements = line.split(" ");
		Integer count = 0;
		String prevEl = "";
		String currEl = "";
		Boolean firstEl = true;
		//TreeMap<Integer,Integer> numM = new TreeMap<Integer,Integer>();
		for(String num :lineElements){
			if(firstEl) {
				currEl = prevEl = num;
				count++;
				firstEl = false;
			}else if(num.equals(prevEl)) {
				currEl = num;
				count++;
			}else {
				outStr.append(count).append(" ").append(currEl).append(" ");
				count =1;
				prevEl = currEl =num ;
				
			}
		
		}
		outStr.append(count).append(" ").append(currEl).append(" ");
		
		System.out.println(outStr);
		
	}

	}
}
