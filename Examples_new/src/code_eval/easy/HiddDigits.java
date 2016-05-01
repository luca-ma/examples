package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HiddDigits {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		
		
		while ((line = in.readLine()) != null) {
			StringBuffer outNum = new StringBuffer();	
			try {			
				for(int idx=0 ; idx< line.length();idx++){
				
					char charAt = line.charAt (idx);
					if( Character.isDigit(charAt)){
						outNum.append(charAt);
					}else if (Character.isLowerCase(charAt)){
						int num = (int)charAt;
						Integer diff = num - 97;
						if(num<=105)
							outNum.append(diff);
					}
					//System.out.println("char Num: " + charAt);
				}
				
			}catch (NumberFormatException numExc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			if(outNum.length()>0)
				System.out.println(outNum);
			else 
				System.out.println("NONE");
		}
		}
	
	
}
