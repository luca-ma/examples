package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PascalTriangle {
	
	
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			try {
				Integer pascalLev= Integer.valueOf(line.trim());

				TreeMap<Integer,ArrayList<String>> pascalT = new TreeMap<Integer,ArrayList<String>>();
				for(int pascalR=0 ; pascalR<pascalLev;pascalR++) {
					ArrayList<String> linecurrent = new ArrayList<String>();
					if(pascalR==0) {
						linecurrent.add("1");
						pascalT.put(Integer.valueOf(0), linecurrent);
					}else {
						ArrayList<String> previousRow = pascalT.get(pascalR-1);
						for(int idx=0;idx <=previousRow.size() ;idx++ ) {
							if((idx==0)||(idx==previousRow.size())) {
								linecurrent.add("1");
							}else  {
								Integer newVal= Integer.valueOf(previousRow.get(idx-1))+Integer.valueOf(previousRow.get(idx));
								linecurrent.add(String.valueOf(newVal));
							}
						
						}
						
						pascalT.put(pascalR, linecurrent);
					}

				}
				
				System.out.println(printTriangle(pascalT));
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		}
	}


	private static String printTriangle(TreeMap<Integer,ArrayList<String>> pascalT) {
		StringBuilder triaStr = new StringBuilder();
		for(Map.Entry<Integer, ArrayList<String>> entry : pascalT.entrySet()) {
			ArrayList<String> row = entry.getValue();
			for(String val: row) {
				triaStr.append(val).append(" ");
			}
		}
		return (triaStr.deleteCharAt(triaStr.length()-1).toString());
	}
}
