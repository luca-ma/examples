package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Rotation {

	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				String[] split = line.split(",");
				
				String s1 = split[0];
				String s2 = split[1];
				
				if((s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1)) {
					System.out.println("True");
				}else {
					System.out.println("False");
				}
				
				

			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
	}
}