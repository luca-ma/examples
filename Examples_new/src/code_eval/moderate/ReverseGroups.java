package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReverseGroups {
	
	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			try {
					String[] tokens = line.trim().split(";");
					Integer groupLen = Integer.valueOf(tokens[1]);
					String[] nums = tokens[0].split(",");
					
					StringBuilder builder = new StringBuilder();

					for (String string : nums) {
//					    if (builder.length() > 0) {
//					        builder.append(" ");
//					    }
					    builder.append(string);
					}
					int idx =0 ;
					StringBuilder retStr = new StringBuilder();
					while(idx < builder.length()){
						int endGropIdx= idx+ groupLen;
						if(endGropIdx<builder.length()){
							retStr.append(new StringBuilder( builder.substring(idx,endGropIdx)).reverse());
						}else {
							retStr.append(builder.substring(idx));
							break;
						}
						idx+=groupLen;
					}
					
				System.out.println(formatStr(retStr));				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		}
	}
	
	public static String formatStr (StringBuilder str) {
		StringBuilder retStr = new StringBuilder();
		for(int idx =0 ; idx<str.length();idx++){
			retStr.append(str.charAt(idx)).append(",");
		}
		return (retStr.deleteCharAt(retStr.length()-1).toString());
	}

}
