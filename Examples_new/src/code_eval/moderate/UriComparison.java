package code_eval.moderate;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
public class UriComparison {

		
		public static void main(String[] args) throws IOException {


			File file = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file));
			String line;
			while ((line = in.readLine()) != null) {
				if(line.length()==0) {
					  continue;
				}
				try {
					String[] split = line.split(";");
					String str1 = split[0];
					str1 = str1.replaceAll("~", "%7E");
					String str2 = split[1];
					str2 = str2.replaceAll("~", "%7E");
					URL ur1 = new URL(str1);
					URL ur2 = new URL(str2);
					
					if(ur1.equals(ur2)){
						System.out.println("True");
					}else  {
						System.out.println("False");
					}
					
				}catch (Exception exc) {
					exc.printStackTrace();
					System.out.println("invalid line....skip it!");
					continue;
				}
				
			}
		}
	
	
}

