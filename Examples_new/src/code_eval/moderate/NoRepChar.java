package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

public class NoRepChar {


	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				StringBuilder lineStr =  new StringBuilder (line.trim());
				Character retChar= null;
				Set<Integer> duplicatedPos = new TreeSet<Integer>();
				
				for(int indx =0; indx < lineStr.length(); indx++) {

					char currentChar = lineStr.charAt(indx);
					if(duplicatedPos.contains(indx)) {
						continue;
					}
					int pos = lineStr.indexOf(String.valueOf(currentChar), indx+1);
					if(pos ==-1) {
						retChar =currentChar;
						break;
					}else {
						duplicatedPos.add(pos);
					}
				}
				
				System.out.println(retChar);


			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}

		}
	}


}
