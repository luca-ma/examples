package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class ArrayAbs {

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
				for(int idx =0 ; idx<firstString.length();idx++) {
					char charAt = firstString.charAt(idx);
					if((secondString.indexOf(charAt)!=-1)&&(secondString.indexOf(charAt)>currSecStrIdx)) {
						commSubstr+=charAt;
						currSecStrIdx= secondString.indexOf(charAt);
					}
				}
				
				
				System.out.println(commSubstr);
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		}
	}
	
}
