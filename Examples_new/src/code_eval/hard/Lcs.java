package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Lcs {

	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			try {
				String[] split = line.split(";");
				
				String firstString = split[0];
				String secondString = split[1];
				int currSecStrIdx =0;
				String commSubstr ="";
				String  maxCommSubStr="";
				for(int idx1 =0 ; idx1<firstString.length();idx1++) {
					commSubstr="";
					currSecStrIdx=0;
					for(int idx =idx1 ; idx<firstString.length();idx++) {
						char charAt = firstString.charAt(idx);
						if((secondString.indexOf(charAt)!=-1)&&(secondString.indexOf(charAt)>=currSecStrIdx)) {
							commSubstr+=charAt;
							currSecStrIdx= secondString.indexOf(charAt);
						}
					}
					if(commSubstr.length()>maxCommSubStr.length()) {
						maxCommSubStr =commSubstr;
					}
				}
				
				
				System.out.println(maxCommSubStr);
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	
}
