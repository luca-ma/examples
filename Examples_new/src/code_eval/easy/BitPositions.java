package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BitPositions {

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
		String[] lineElements = line.split(",");
		Integer intNum= Integer.parseInt(lineElements[0],10);
		Integer pos1 = Integer.valueOf(lineElements[1]);
		Integer pos2 = Integer.valueOf(lineElements[2]);
		String binaryString = (new StringBuilder(Integer.toBinaryString(intNum))).reverse().toString();
		if(binaryString.charAt(pos1-1)==binaryString.charAt(pos2-1)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		//System.out.println(""+ binaryString);
	}

	}
}
