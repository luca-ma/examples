package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidEmail {
	
	
	//public static final String regex = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
	public static final String regex = "[a-z0-9]+@[a-z0-9]+\\.[a-z]+";
	
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}

			Pattern p = Pattern.compile(regex);
			if(p.matcher(line.trim()).matches()) {
				System.out.println("true");
			}else  {
				System.out.println("false");
			}

		}

	}
}
