package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class RoadTrip {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		
			
		while ((line = in.readLine()) != null) {
			Map<Integer, String> cityMaps  = new TreeMap<Integer, String>();
			
			try {
								
				StringBuilder outStr = new StringBuilder();
				String[] split = line.split(";");
				
				for(int idx =0; idx <split.length;idx++){
					
					String token = split[idx];
					String[] split2 = token.split(",");
					cityMaps.put(Integer.valueOf(split2[1]), split2[0]);
					
				}
				int diff =0;
				int prev = 0;
				for(Map.Entry<Integer,String> entry : cityMaps.entrySet()) {
					diff = entry.getKey() -prev;
					prev = entry.getKey();
					outStr.append(diff).append(",");
				}
				
				System.out.println(outStr.substring(0,outStr.length()-1));
				
			}catch (NumberFormatException numExc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
		}
	

	
}
