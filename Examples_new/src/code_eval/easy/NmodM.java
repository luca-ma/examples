package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NmodM {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			String[] lineElements = line.split(",");
			Integer intNum1= Integer.parseInt(lineElements[0],10);
			Integer intNum2= Integer.parseInt(lineElements[1],10);

			if( intNum2>intNum1){
				System.out.println(intNum1);
				continue;
			}
			if( intNum2.equals(intNum1)){
				System.out.println(0);
				continue;
			}
			Integer mult= intNum2;
			Integer mod =0;
			Integer idx =2;
			while(mult <= intNum1){
				mult = intNum2*idx;
				if (mult<=intNum1){
					mod = intNum1- mult;	
				}			
				idx++;
			}
			System.out.println(mod);
			//System.out.println("%:"+intNum1%intNum2);
			
		}

	}

	
	
}
