package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class RacingChars {

static Integer prevIdx = -1;
static Character sign = '|';


	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			StringBuilder  outLine = new StringBuilder(line);
			Integer currIdx = findIdx(line);
			if(prevIdx == -1){
				sign = '|';
			}else if (prevIdx==currIdx){
				sign = '|';
			}else if (prevIdx<currIdx){
				sign ='\\';
			}else  if (prevIdx>currIdx){
				sign ='/';
			}
			
			outLine.setCharAt(currIdx, sign);
			prevIdx = currIdx;
		   // System.out.println("string : " + myString);  
			System.out.println(outLine);
			
		}

	}



	public static  Integer findIdx(String str){
		
		if(str.indexOf("C")!=-1){
			return str.indexOf("C");
		}else if (str.indexOf("_")!=-1){
			return str.indexOf("_");
		}else 
			return -1;
		
	}
	
	

}
