package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PassTriag {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		ArrayList<Integer[]> lines = new ArrayList<Integer[]>();
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			try {
				String[] split = line.trim().split(" ");
				Integer[] splitN = new Integer[split.length];
				for(int idx=0;idx<split.length;idx++){
					splitN[idx]=Integer.valueOf(split[idx]);
				}
				lines.add(splitN);
				
				
				
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		}
		
		int depth = lines.size()- 2;

        while ( depth >= 0) {
            for (int j = 0; j < depth; j++) {
                lines.get(depth)[j] += Math.max( Integer.valueOf(lines.get(depth+1)[j]), Integer.valueOf(lines.get(depth+1)[j+1]));
            }
            depth += -1;
        }

        lines.get(0)[0] += Math.max(Integer.valueOf(lines.get(1)[0]), Integer.valueOf(lines.get(1)[1]));

            System.out.println(lines.get(0)[0]);
		
		
		
	}
	
}
