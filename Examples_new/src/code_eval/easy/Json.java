package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Json {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			try {
				Integer ret = 0;
				
				String[] split = line.split(":");
				for(int idx=0;idx<split.length;idx++){
					String tok = split[idx];
					if(tok.contains("label")){
						String num = tok.split(",")[0].trim();
						ret+=Integer.valueOf(num);
					}
				}
				System.out.println(""+ret);
			}catch (NumberFormatException numExc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
		}
	
	
	
}
