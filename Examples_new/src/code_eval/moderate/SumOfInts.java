package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SumOfInts {


	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				
				String[] numbers = line.split(",");
				ArrayList<Integer> numList = new ArrayList<Integer>();
				for(int idx=0; idx<numbers.length;idx++){
					numList.add(Integer.valueOf(numbers[idx].trim()));
				}
				Integer max =0;
				
				for(int numOfSetEls =0;numOfSetEls<=numbers.length;numOfSetEls++){
				int sum =0;
					for(int idx =0; idx+numOfSetEls<numbers.length; idx++){
						sum=0;
						for(int indSum =0; indSum<=numOfSetEls;indSum++){
							sum+=numList.get(idx+indSum);
						}
						if (sum>max){
							max =sum;
						}
					}
					
				}
					
				
				System.out.println(max);


			}catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("invalid line....skip it!");
				continue;
			}
			
			

		}
	}
	
	


}
