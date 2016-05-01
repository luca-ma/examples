package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Word2Digit {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			StringBuffer num = new StringBuffer();
			String[] lineArray = line.split(";");
			if (lineArray.length > 0) {
				for(int idx =0 ;idx <lineArray.length ; idx++ ) {
					String word = lineArray[idx];
					if(word.equals("zero")){
						num.append("0");
					}else if(word.equals("one")){
						num.append("1");
					}else if(word.equals("two")){
						num.append("2");
					}else if(word.equals("three")){
						num.append("3");
					}else if(word.equals("four")){
						num.append("4");
					}else if(word.equals("five")){
						num.append("5");
					}else if(word.equals("six")){
						num.append("6");
					}else if(word.equals("seven")){
						num.append("7");
					}else if(word.equals("eight")){
						num.append("8");
					}else if(word.equals("nine")){
						num.append("9");
					}
				}
				System.out.println(num);
			}
			
		}
	}



}

