package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ArabToNumeral {


	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			Integer arNum = Integer.valueOf(line);
			if (arNum < 1 || arNum > 3999)
		        continue;
		    String res = "";
		    while (arNum >= 1000) {
		    	res += "M";
		    	arNum -= 1000;        }
		    while (arNum >= 900) {
		        res += "CM";
		        arNum-= 900;
		    }
		    while (arNum >= 500) {
		        res += "D";
		        arNum-= 500;
		    }
		    while (arNum >= 400) {
		        res += "CD";
		        arNum -= 400;
		    }
		    while (arNum >= 100) {
		    	res += "C";
		    	arNum -= 100;
		    }
		    while (arNum >= 90) {
		    	res += "XC";
		        arNum -= 90;
		    }
		    while (arNum >= 50) {
		        res += "L";
		        arNum -= 50;
		    }
		    while (arNum >= 40) {
		        res += "XL";
		        arNum -= 40;
		    }
		    while (arNum >= 10) {
		        res += "X";
		        arNum -= 10;
		    }
		    while (arNum >= 9) {
		        res += "IX";
		        arNum -= 9;
		    }
		    while (arNum >= 5) {
		        res += "V";
		        arNum -= 5;
		    }
		    while (arNum >= 4) {
		        res += "IV";
		        arNum -= 4;
		    }
		    while (arNum >= 1) {
		        res += "I";
		        arNum -= 1;
		    }    
		    System.out.println(res);
			
			
		}

	}



	
}
