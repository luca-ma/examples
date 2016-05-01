package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DistSub {


	public static StringBuilder spr = null;


	public static String seq ="";
	public static String subSeq="";
	public static Integer numSub =0;


	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;

		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			String[] split = line.split(",");
			seq =split[0];
			subSeq = split[1];

			Boolean ret = false;

			findSubStr(0, 0);
			System.out.println(numSub);
			numSub =0;

		}


	}

	public static void findSubStr(Integer indx1, Integer indx2) {
		Boolean lastCh = false;
		if (indx2.equals(subSeq.length()-1)){
			lastCh = true;
		}
		
		for(int idx = indx1; idx <seq.length(); idx++)
		{
			if (seq.charAt(idx) == subSeq.charAt(indx2)){
				if(lastCh){
					numSub++;
				}else {
					indx2++;
					findSubStr(idx+1,indx2);
					indx2--;
				}
			}
			
		}
		
	}

}

