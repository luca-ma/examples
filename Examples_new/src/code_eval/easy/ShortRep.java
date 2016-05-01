package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ShortRep {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
//			String[] lineArray = line.split(" ");
//			if (lineArray.length > 0) {
//				StringBuilder lowercase
//				for(int idx =0 ;idx <lineArray.length ; idx++ ) {
//					String word = lineArray[idx];
//				}
//			}
			System.out.println(line.toLowerCase());
		}
	}



}

