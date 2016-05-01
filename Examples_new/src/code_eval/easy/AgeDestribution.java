package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class AgeDestribution {


	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			String res = "";
			Integer arNum = Integer.valueOf(line);
			if(arNum<0||arNum>100){
				res ="This program is for humans";
			}else if (arNum>=0 && arNum<=2) {
		    	res = "Home";
			}else if (arNum>=3 && arNum<=4) {
		    	res = "Preschool";
		     }else if (arNum>=5 && arNum<=11) {
			    	res = "Elementary school";
			 }else if (arNum>=12 && arNum<=14) {
			    	res = "Middle school";
			 }else if (arNum>=15 && arNum<=18) {
			    	res = "High school";
			 }else if (arNum>=15 && arNum<=18) {
			    	res = "High school";
			 }else if (arNum>=19 && arNum<=22) {
			    	res = "College";
			 }else if (arNum>=23 && arNum<=65) {
			    	res = "Work";
			 }else if (arNum>=66 && arNum<=100) {
			    	res = "Retirement";
			 }
			
		 
		    System.out.println(res);
			
			
		}

	}



	
}
