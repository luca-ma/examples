package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FindWriter {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			try {
				
				String[] split = line.split("\\|");
				String string = split[0];
				String[] nums = split[1].split(" ");
				StringBuilder outStr  = new StringBuilder();
				for(int idx =1; idx <nums.length;idx++){
					
					outStr.append(string.charAt(Integer.valueOf(nums[idx])-1));
				}
				System.out.println(outStr);
				
			}catch (NumberFormatException numExc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
		}
	

	
}
