package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HexadecimalToDecimal {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
	File file = new File(args[0]);
	BufferedReader in = new BufferedReader(new FileReader(file));
	String line;
	while ((line = in.readLine()) != null) {
		if(line.length()==0) {
			continue;
		}
		int i= Integer.parseInt(line.trim(),16);
		System.out.println(""+ i);
	}

	}
	
}
