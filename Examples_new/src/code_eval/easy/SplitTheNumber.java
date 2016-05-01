package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SplitTheNumber {

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
		String[] lineElements = line.split(" ");
		String numStr = lineElements[0];
		String pattern = lineElements[1];
		String op ="";
		Integer res;
		
		if(pattern.indexOf("+")!=-1){
			String num0 = numStr.substring(0,pattern.indexOf("+"));
			String num1 = numStr.substring(pattern.indexOf("+"));
			res = Integer.valueOf(num0)+Integer.valueOf(num1);
		}else if(pattern.indexOf("-")!=-1){
			String num0 = numStr.substring(0,pattern.indexOf("-"));
			String num1 = numStr.substring(pattern.indexOf("-"));
			res = Integer.valueOf(num0)-Integer.valueOf(num1);
		}else {
			res =Integer.valueOf(pattern); 
		}
		
		System.out.println(res);
		
		//System.out.println(""+ binaryString);
	}

	}
}
