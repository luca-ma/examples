package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;




public class StringListNoOk {

	static StringBuilder strOut =null;
	static TreeSet<String> strSet =null;
	static ArrayList<String> results =null;

	public static void main(String[] args) throws IOException {

		 
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			
			try {
				strOut = new StringBuilder();
				strSet = new TreeSet<String>();
				String[] split = line.split(",");
				ArrayList<String> results = new ArrayList<String>();
				ArrayList<String> components = new ArrayList<String>();
				for(int idx=0;idx<split[1].length();idx++){
					components.add(split[1].substring(idx,idx+1));
				}
				String string = split[1];
				int n = Integer.valueOf(split[0]);

				int size = components.size();
				
				 process (string, new String());
				
				
				
				for(String comb: results){
					strSet.add(comb);
				}
				
				//System.out.println(strSet);
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	

	 public static void process(String result, String string)
	 {
	     if(string.length() == 0)
	     {
	         System.out.println(result);
	     }else{
	         for(int i = 0; i < string.length(); i++)
	         {
	             String newResult = new String(result+string.charAt(i));
	             String newString = new String(string.substring(0,i) + string.substring(i+1, string.length()));
	             process(newResult, newString);
	         }
	     }
	 }


	
}
