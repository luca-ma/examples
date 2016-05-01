package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FizzBuzz {
	
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;

		while ((line = in.readLine()) != null) {
			try {
				if(line.length()==0){
					continue;
				}
				String[] lineArray = line.split(" ");
				Integer div1 = Integer.valueOf(lineArray[0]);
				Integer div2 = Integer.valueOf(lineArray[1]);
				Integer max = Integer.valueOf(lineArray[2]);
				StringBuilder lineStr = new StringBuilder();
				for(int idx =1; idx <=max ; idx++ ){
					if((idx%div1==0)&&(idx%div2==0)){
						lineStr.append("FB");
					}else if((idx%div1==0)){
						lineStr.append("F");
					}else if((idx%div2==0)){
						lineStr.append("B");
					}else {
						lineStr.append(String.valueOf(idx));
					}
					lineStr.append(" ");
				}
				System.out.println(""+lineStr.deleteCharAt(lineStr.length()-1));
			}catch (Exception exc) {
				System.out.println("invalid line");
				continue;
			}
		}

	}

}
