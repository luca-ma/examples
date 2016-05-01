package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StringCapitalize {

	
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;

		while ((line = in.readLine()) != null) {
			try {
				String[] word = line.split(" ");
				
				StringBuilder capStr =new StringBuilder();
				for(int idx =0; idx <word.length; idx++) {
					if(idx>0) {
						capStr.append(" ");
					}
					capStr.append(capitalizeWord(word[idx]));
				}
				
				System.out.println(capStr);
			}catch (Exception exc) {
				System.out.println("invalid line");
				continue;
			}
		}

	}

	private static String capitalizeWord(String word){
	    if(word.length() == 0)
	        return word;
	    return word.substring(0, 1).toUpperCase() + word.substring(1);
	}
	
}
