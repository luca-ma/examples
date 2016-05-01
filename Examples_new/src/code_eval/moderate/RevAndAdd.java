package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RevAndAdd {

	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			try {
				StringBuilder lineStr = new StringBuilder(line.trim());
				Integer numOfInter = 0;
				
				while(!isPalidrome(lineStr)) {
					Integer sum= Integer.valueOf(lineStr.toString())+ Integer.valueOf(lineStr.reverse().toString());
					lineStr = new StringBuilder(String.valueOf(sum));
					numOfInter++;
				}
				
				System.out.println(numOfInter+" "+ lineStr.toString());
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		}
	}
	
	public static Boolean isPalidrome (StringBuilder str) {
		
		return (str.toString().equals(str.reverse().toString()));
	}
	
}
