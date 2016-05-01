package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;

public class Pangrams {
	
	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				BitSet bitSet = new BitSet(26);
				for(char ch : line.toLowerCase().toCharArray()) {
						if(Character.isLetter(ch)) {
							bitSet.set(ch - 97);
						}
				}

				if(bitSet.cardinality() == 26) {
					System.out.println("NULL");
				}else {
					StringBuilder outStr =new StringBuilder();
					for(int idx =0; idx <=bitSet.length(); idx++) {
						if(!bitSet.get(idx)) {
							outStr.append(Character.toString ((char) (97+idx)));
						}
					}
					System.out.println(outStr);
				}
				

			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
	}
}
