package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MixCont {

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
		StringBuilder letters = new StringBuilder("");
		StringBuilder number= new StringBuilder("");
		
		for(int idx =0; idx < lineElements.length; idx++) {
			try {
				Integer valueOf = Integer.valueOf(lineElements[idx]);
				number.append(lineElements[idx]).append(",");
			}catch (NumberFormatException nExc) {
				letters.append(lineElements[idx]).append(",");
			}
			
			
		}
		String retStr = "";
		if(letters.length()>0) {
			retStr+=letters.substring(0, letters.length()-1);
		}
		if (number.length()>0 && letters.length()>0) {
			retStr+="|";
		}
		if (number.length()>0) {
			retStr+=number.substring(0, number.length()-1);
		}
		
		System.out.println(retStr);
		
		//System.out.println(""+ binaryString);
	}

	}
}
