package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;




public class TelWords {

	static Map<String,String> numToLetters = new TreeMap<String,String>();
	static Set<String> lettersList = new TreeSet<String>();
	
	static StringBuilder strOut = null;
	static String line= null;
	

	public static void main(String[] args) throws IOException {

		 
		numToLetters.put("0","0");
		numToLetters.put("1","1");
		numToLetters.put("2","abc");
		numToLetters.put("3","def");
		numToLetters.put("4","ghi");
		numToLetters.put("5","jkl");
		numToLetters.put("6","mno");
		numToLetters.put("7","pqrs");
		numToLetters.put("8","tuv");
		numToLetters.put("9","wxyz");

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			
			try {
				strOut = new StringBuilder();
				buildLetter("",0);

				Boolean first =true;
				for(String letter:lettersList){
					if (first)
							first = false;
					else
						    strOut.append(",");
					strOut.append(letter);
				}
				
				
				System.out.println(strOut);
				
				
			}catch (Exception exc) {
				exc.printStackTrace();
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	


	public  static void buildLetter (String inLetter , Integer idx){
		
		if (idx>=line.length()){
			lettersList.add(inLetter);
			return;
		}
		
		String strChar = String.valueOf(line.charAt(idx));
		String strings = numToLetters.get(strChar);
		for(int idx2 =0; idx2<strings.length();idx2++){
			String letToAdd = String.valueOf(strings.charAt(idx2));
			buildLetter(inLetter+letToAdd, idx+1);
		}
		
	}
	
	
}
