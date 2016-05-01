package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MultipleOfNum {

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

			Boolean notFound = true;
			Integer multiplier = 2;
			while(notFound)
			{
				intNum2 =multiplier*intNum2;
				if(intNum2>intNum1){
					System.out.println(intNum2);
					break;
				}
				multiplier++;
			}
		}

	}

}
