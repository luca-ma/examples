package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class JugglWithZeros {

	    public static void main (String[] args) throws IOException {
	    
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	        String[] linetoken = line.split(" ");
	        StringBuilder lineRes= new StringBuilder("");
	        if (linetoken.length > 0) {
	            //Process line of input Here
	        	for(int idx=0;idx<linetoken.length-1;idx+=2){
	        		if(linetoken[idx].equals("0")){
	        			lineRes.append(linetoken[idx+1]);
	        		}else {
	        			lineRes.append(stringOfSize(linetoken[idx+1].length(), '1'));
	        		}
	        	}
	        }
	        System.out.println(Integer.parseInt(lineRes.toString(), 2)); 
	    }
	  }
	    
	    public static String stringOfSize(int size, char ch)
	    {
	        final char[] array = new char[size];
	        Arrays.fill(array, ch);
	        return new String(array);
	    }
	
}
