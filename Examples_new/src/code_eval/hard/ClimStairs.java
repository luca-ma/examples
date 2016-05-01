package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;




public class ClimStairs {

	static StringBuilder strOut =null;
	static TreeSet<String> resSet =null;
	static ArrayList<String> components = null;
	
	static ArrayList<String> results =null;
	static Integer N =0;

	public static void main(String[] args) throws IOException {

		 
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			
			try {
				//strOut = new StringBuilder();
				Integer valueOf = Integer.valueOf(line);
				int climbStairs = climbStairs(valueOf);
				System.out.println(""+climbStairs);
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	


	 public static int climbStairs(int n) {
	        if(n == 0 || n == 1)
	            return 1;
	        else
	        return climbStairs(n-1) + climbStairs(n-2);
	    }

	
}
