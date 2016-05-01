package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class StringSearching {

	static StringBuilder strOut =null;
	static TreeSet<String> strSet =null;

	public static void main(String[] args) throws IOException {

		 
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			
			try {
				boolean perfectMatch =true;
				String[] split = line.split(",");
				String str1 = split[0];
				String str2 = split[1];
				if(str2.contains("\\*")){
					perfectMatch =true;
					StringBuilder str2M =new StringBuilder();
					for(int idx=0; idx<str2.length(); idx++){
						if(str2.charAt(idx)!='\\'){
							str2M.append(str2.charAt(idx));
						}
					}
					str2=str2M.toString();
				}else if (str2.contains("*")){
					perfectMatch=false;
				}
				
				if(perfectMatch){
					System.out.println(str1.contains(str2));
				}else {
					//str2.replaceAll("\\*", "\\.\\*");
					StringBuilder str2M =new StringBuilder();
					str2M.append(".*");
					for(int idx=0; idx<str2.length(); idx++){
						if(str2.charAt(idx)=='*'){
							str2M.append(".");
						}
						str2M.append(str2.charAt(idx));
					}
					str2M.append(".*");
					Pattern p = Pattern.compile(str2M.toString());
					Matcher m = p.matcher(str1);
					System.out.println(m.matches());
				}
				
			
				
				
			}catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	
	
	 
}
