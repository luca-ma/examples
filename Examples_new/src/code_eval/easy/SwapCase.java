package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SwapCase {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		File file = new File(args[0]);
		BufferedReader in;
		
			in = new BufferedReader(new FileReader(file));
		
		String line;
		while ((line = in.readLine()) != null) {
			try {			
				if (line.trim().length()==0){
					continue;
				}
				
				StringBuilder strREBuilder = new StringBuilder();
				for(int idx =0 ; idx < line.length();idx++){
					if (Character.isLowerCase(line.charAt(idx))) 
						strREBuilder.append(Character.toUpperCase(line.charAt(idx)));
					else if (Character.isUpperCase(line.charAt(idx)))
						strREBuilder.append(Character.toLowerCase(line.charAt(idx)));
					else 
						strREBuilder.append(line.charAt(idx));
				}
				System.out.println(strREBuilder);
		
			
			}catch (Exception exc) {
				System.out.println("invalid line");
				continue;
			}
	}
		
	}
}
