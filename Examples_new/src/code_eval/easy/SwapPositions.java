package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwapPositions {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	
	File file = new File(args[0]);
	BufferedReader in = new BufferedReader(new FileReader(file));
	String line;
	while ((line = in.readLine()) != null) {
		if(line.length()==0) {
			continue;
		}
		System.out.println(line);
		String[] lineElements = line.split(":");
		
		String nums = lineElements[0].trim();
		String pos = lineElements[1].trim();
		String[] couples = pos.split(",");
		Map<Integer,Integer> swapMap = new HashMap<Integer,Integer>();
		for(int idx =0; idx < couples.length; idx++) {
			String[] split = couples[idx].trim().split("-");
			swapMap.put(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
		}
		List<Integer> numList = new ArrayList<Integer>();
		String[] numArray = nums.split(" ");
		for(int idx =0; idx < numArray.length; idx++) {
			numList.add(Integer.valueOf(numArray[idx]));
		}
		
		for(Map.Entry<Integer, Integer> entry : swapMap.entrySet()) {
			Integer tmpVal = numList.get(entry.getKey());
			numList.set(entry.getKey(),numList.get(entry.getValue()));
			numList.set(entry.getValue(),tmpVal);
		}
		
		
		StringBuffer outL = new StringBuffer();
		for(Integer num :numList) {
			outL.append(num).append(" ");
		}
		System.out.println(outL);
		
		//System.out.println(""+ binaryString);
	}

	}
}
