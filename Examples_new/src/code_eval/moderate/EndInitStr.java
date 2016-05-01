package code_eval.moderate;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class EndInitStr {

		
		public static void main(String[] args) throws IOException {


			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if(line.length()==0) {
					  continue;
				}
				try {
					String[] split = line.split(",");
					String string = split[0];
					String tail = split[1];
					if(string.endsWith(tail)) {
						System.out.println("1");
					}else  {
						System.out.println("0");
					}
					
				}catch (Exception exc) {
					System.out.println("invalid line....skip it!");
					continue;
				}
				
			}
		}
	
	
}

