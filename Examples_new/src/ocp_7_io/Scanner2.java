package ocp_7_io;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Scanner2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String text = "10,a,11,12,12,a,b";
		//Set<String> words = new TreeSet<>();
		
		try ( Scanner tokenizingScanner = new Scanner(text) ) {
			tokenizingScanner.useDelimiter(",");
			while(tokenizingScanner.hasNext()) {
			String word = tokenizingScanner.next();
			System.out.println(word);
			}
			}
			

	}

}
