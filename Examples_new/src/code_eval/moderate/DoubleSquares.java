package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DoubleSquares {

	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				
				Integer num = Integer.valueOf(line);
				
				if((num.equals(0))||(num.equals(1) )){
					System.out.println(1);
					continue;
				}
					
				//Integer secNum = Integer.valueOf(split[1]);
				Integer numOfPrimes =0;
				int sqr =0;
				for(int idx=0; idx <num; idx++){
					if (idx*idx>num){
						break;
					}
					int sqrt1 = idx*idx;
					for(int idx2=0; idx2 <idx; idx2++){
						if (idx2*idx2>num){
							break;
						}
						sqr= idx*idx + idx2*idx2;
						if(sqr==num){
							numOfPrimes++;
						}
					}
				}
				
				System.out.println(numOfPrimes);
				

			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
	}
	
	private static boolean isPrimeNum(Integer num) {
		   //check if n is a multiple of 2
		if(num.equals(2)) return true;
	    if (num%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=num;i+=2) {
	        if(num%i==0)
	            return false;
	    }
	    return true;
	}
}