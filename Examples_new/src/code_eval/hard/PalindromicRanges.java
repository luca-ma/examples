package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;





public class PalindromicRanges {

	

	public static void main(String[] args) throws IOException {

		 
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			
			try {
						
				
				String[] split = line.split(" ");
				
				Integer startNum = Integer.valueOf(split[0]);
				Integer endNum = Integer.valueOf(split[1]);
				
				Integer cntPal = 0;
				Integer evenPal =0;
				Integer totEvenPal = 0;
				
		        for (int numIdx = startNum; numIdx <= endNum; numIdx++) {
		            for (int j = numIdx; j <= endNum; j++) {
		                for (int k = numIdx; k <= j; k++) {
		                   // System.out.print(k + " ");
		                    if(isPalindrome(k)){
		                    	cntPal++;
		                    }	                        
		                }
		                 if (cntPal % 2 == 0){
		                	evenPal++;
		                }
		                    
		                cntPal = 0;
		            }
		            totEvenPal += evenPal;
		            evenPal = 0;
		        }
		        System.out.println(totEvenPal);
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	

	 

	 private static Boolean isPalindrome(Integer num){
		 return Integer.toString(num).equals(reverse(Integer.toString(num)));
	 }
	  
	 private static String reverse(String str){
		 StringBuilder strB = new StringBuilder(str);
		 return strB.reverse().toString();
		
	 }

}
