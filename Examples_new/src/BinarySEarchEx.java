
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BinarySEarchEx {
	
	static String[] sa = { "a", "aa", "ab", "b" };
	static {
		Arrays.sort(sa);
	}
	
	public static void main(String[] args){
		
		String search = ""; 
		if(args.length != 0) search = args[0];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//  read the username from the command-line; need to use try/catch with the
	      //  readLine() method
	      try {
	    	  search = br.readLine();
	      } catch (IOException ioe) {
	         System.out.println("IO error trying to read your name!");
	         System.exit(1);
	      }

		
		System.out.println(Arrays.binarySearch(sa, search));
		
	} 
	
}