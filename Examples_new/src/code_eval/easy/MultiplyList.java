package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MultiplyList {

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
		String[] lineElements = line.split("\\|");
		StringBuilder restStr = new StringBuilder();
		
		String[] list1 = lineElements [0].trim().split(" ");
		String[] list2 = lineElements [1].trim().split(" ");
		
		for( int idx =0; idx <list1.length ;idx++) {
			restStr.append(Integer.valueOf(list1[idx])*Integer.valueOf(list2[idx])).append(" ");
		}
		
		
		System.out.println(restStr);
		
		//System.out.println(""+ binaryString);
	}

	}
}
