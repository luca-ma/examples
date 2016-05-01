package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class W2Digit {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.startsWith("#"))
			continue;
			Integer period =0;
			for(int idx =1;idx<line.length();idx++){
				StringBuilder strO = new StringBuilder();
				String prefix = line.substring(0, line.length()-idx);
				String suffix = line.substring(line.length()-idx);
				//System.out.println("prefix:"+prefix);
			//System.out.println("suffix:"+suffix);
				strO.append(suffix).append(prefix);
				if(strO.toString().equals(line)){
					period =idx;
					break;
				}
					
			}
//			String[] lineArray = line.split(" ");
//			if (lineArray.length > 0) {
//				StringBuilder lowercase
//				for(int idx =0 ;idx <lineArray.length ; idx++ ) {
//					String word = lineArray[idx];
//				}
//			}
			System.out.println(period);
		}
	}



}

