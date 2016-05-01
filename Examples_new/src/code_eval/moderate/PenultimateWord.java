package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PenultimateWord {
	
	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			try {
					String[] tokens = line.trim().split(" ");
							
				System.out.println(tokens[tokens.length-2]);				
				
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
