package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FollInt {
	
	public static int [][] nums =null;
	public static int row =0;
	public static int size = 0;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	    	
	    	
	    	Integer num = Integer.valueOf(line);
	    	
	    			//find min sum path
	    			System.out.println(""+minPathSum(num));
	    		
	    		}
	    		
	    	}


	
	public static int minPathSum(Integer num) {
        Boolean fnd = false;
        Integer newN = num;
        while(!fnd){
        	newN++;
        	ArrayList<Character> strNew =buildS(newN);
        	ArrayList<Character> strN = buildS(num);
        	Collections.sort(strNew);
        	Collections.sort(strN);
        	
        	if(strN.equals(strNew)){
        		return newN;
        	}
        	
        }
		
        return num;
    }

	public static ArrayList<Character> buildS (Integer num){
		String str = String.valueOf(num);
		ArrayList<Character> set = new ArrayList<Character>();
		for (int idx =0;idx < str.length();idx++){
			char charAt = str.charAt(idx);
			if(charAt!='0'){
				set.add(charAt);
			}
		}
		return set;
	}
}
