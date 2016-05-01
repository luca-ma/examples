package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PredTHeNumCopy {

	public static StringBuilder str  =new StringBuilder("0");
	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				
				Integer numIdx = Integer.valueOf(line);
				buildSeq(numIdx);
				System.out.println(str.charAt(numIdx));			

			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
	}
	
	private static void buildSeq(Integer maxLen) {
		   //check if n is a multiple of 2
		if(maxLen<=str.length())
			return;
		while(true) {
			StringBuilder secondPart = new StringBuilder();
			for(int idx=0; idx <str.length();idx++) {
				if(str.charAt(idx)=='0') {
					secondPart.append('1');
				}else if(str.charAt(idx)=='1') {
					secondPart.append('2');
				}else {
					secondPart.append('0');
				}
			}
			str.append(secondPart);
			if(str.length()>=maxLen) {
				return;
			}
		}
	
	    
	}
}