package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;




public class StringPermutation {

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
				strOut = new StringBuilder();
				strSet = new TreeSet<String>();
				permutation(line);
				
				boolean first = true;
				for(String perm :strSet){
					if (first){
						first =false;
					}else {
						strOut.append(",");
					}
					strOut.append(perm);
				}
				
				System.out.println(strOut);
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	
	
	 public  static void permutation(String str) { 
	    permutation("", str); 
	 }

	 private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) strSet.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }

	}


	
}
