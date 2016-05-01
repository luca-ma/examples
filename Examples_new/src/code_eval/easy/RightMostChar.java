package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RightMostChar {

	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;

		while ((line = in.readLine()) != null) {
			try {
				String[] lineArray = line.split(",");
				String str = lineArray[0];
				String ch = lineArray[1];
				System.out.println(""+str.lastIndexOf(ch));
			}catch (Exception exc) {
				System.out.println("invalid line");
				continue;
			}
		}

	}
	
}
