package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class FlaviousJos {


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
				
				Integer numOfPeople = Integer.valueOf(numbers[0]);
				Integer numOfSkips= Integer.valueOf(numbers[1]);
				//build Initial Map	
				TreeMap<Integer,Boolean> people = new TreeMap<Integer, Boolean>();
				for(int idx =0; idx< numOfPeople;idx++){
					people.put(idx, false);
				}
				StringBuilder outLine = new StringBuilder();
				int curridx =-1;
				while(!isEndedPeople(people)){
			//	while(people.size() >0 ){	
					int idxPart =0 ;
					while(idxPart<numOfSkips){
						if(curridx<numOfPeople-1 ){
							curridx = curridx + 1;
						}else {
							curridx = 0;
						}
						
						if(!people.get(curridx)){
							idxPart++;	
						}
							
						
					}
//					if(curridx+ numOfSkips<numOfPeople){
//						curridx = curridx + numOfSkips;
//					}else {
//						curridx = numOfSkips - (numOfPeople   - curridx);
//					}
					people.put(curridx , true);
					outLine.append(curridx).append(" ");
			//		System.out.println(outLine);
					//people.remove(curridx-1);
					
				}
			
				System.out.println(outLine.deleteCharAt(outLine.length()-1));


			}catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("invalid line....skip it!");
				continue;
			}
			
			

		}
	}
	
	
	private static Boolean isEndedPeople (TreeMap<Integer,Boolean> people){
		
				
		for(Map.Entry<Integer, Boolean> entry: people.entrySet()){
			if (!entry.getValue()){
				return false;
			}
		}
		return true;
	}

}
