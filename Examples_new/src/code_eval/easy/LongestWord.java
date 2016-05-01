package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

public class LongestWord {

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
		String[] lineElements = line.split(" ");
		TreeMap<Integer,String> numM = new TreeMap<Integer,String>();
		for(String word :lineElements){
			numM.put(word.length(),word);
		}
		
		
		System.out.println(numM.get(numM.lastKey()));
	}

	}
}
