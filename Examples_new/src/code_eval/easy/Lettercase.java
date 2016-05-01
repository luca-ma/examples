package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Lettercase {


	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			int numOfUp =0;
			for(int idx=0; idx<line.length();idx++){
				if (Character.isUpperCase(line.charAt(idx))){
					numOfUp++;
				}
			}
			DecimalFormat df = new DecimalFormat("0.00");
			Float percUp = ((float) numOfUp/line.length())*100;

			System.out.println("lowercase: "+df.format(100.00F-percUp)+" uppercase: "+df.format(percUp));
	
		}

	}


}
