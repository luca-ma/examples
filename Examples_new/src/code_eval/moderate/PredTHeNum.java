package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class PredTHeNum {

	public static StringBuilder str  =new StringBuilder("0");
	public static BigInteger two = BigInteger.valueOf(Long.parseLong("2"));
	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				
				BigInteger numIdx = BigInteger.valueOf(Long.parseLong(line));
				//System.out.println("------------");
				//System.out.println(numIdx);
				//System.out.println(findMax2Power(numIdx).intValue());
				Integer count= 0;
				while(numIdx.signum()>0) {
					numIdx = numIdx.subtract(findMax2Power(numIdx));
					count++;
				}
				
				//System.out.println(findMax2Power(numIdx).intValue());
				//System.out.println(count);
				Integer rem = count%3;
				if(rem.equals(0)) {
					System.out.println("0");
				}else if (rem.equals(1)) {
					System.out.println("1");
				}else if (rem.equals(2)) {
					System.out.println("2");
				}

			}catch (Exception exc) {
				//System.out.println("invalid line....skip it!");
				exc.printStackTrace();
				continue;
			}
		}
	}
	
	private static BigInteger findMax2Power(BigInteger maxLen) {
		if(maxLen.signum()==0)
			return BigInteger.ZERO;
		Integer maxPow =0;
		
		while(true){
			//Double pow = Math.pow(2,Double.valueOf(maxPow));
			BigInteger pow = two.pow(maxPow);
			if(pow.equals(maxLen))
				return pow;
			if(pow.compareTo(maxLen)>0)
			{
				return (two.pow(--maxPow));
			}
			maxPow++;
		}

	}
}