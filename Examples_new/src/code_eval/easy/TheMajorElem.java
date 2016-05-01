package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;


public class TheMajorElem {


	private static String[] split;

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			
			split = line.split(",");
			TreeMap <Integer,Integer> mapNumOcc = new TreeMap<Integer,Integer>();
			for(int idx =0; idx <split.length;idx++){
				
				String num = split[idx];
				Integer occNum = mapNumOcc.get(Integer.valueOf(num));
				if(occNum!=null){
					mapNumOcc.put(Integer.valueOf(num), ++occNum);
				}else {
					mapNumOcc.put(Integer.valueOf(num), Integer.valueOf(1));
				}				
			}
			
			int len = split.length /2;
			Integer valFnd = 0;
			Boolean found = false;
			//find el
			for(Map.Entry<Integer,Integer> entry : mapNumOcc.entrySet()) {
				if (entry.getValue()>=len){
					found = true;
					valFnd = entry.getKey();
					break;
				}
			}
			
			if (found){
				System.out.println(valFnd);
			}else {
				System.out.println("None");
			}
		    
			
			
		}
		
		

	}



	
}
