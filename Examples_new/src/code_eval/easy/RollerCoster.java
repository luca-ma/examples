package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RollerCoster {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() == 0) {
				continue;
			}
			boolean upperCase = true;
			StringBuilder str = new StringBuilder();
			for (int idx = 0; idx < line.length(); idx++) {
				if (!Character.isAlphabetic(line.charAt(idx))) {
					str.append(line.charAt(idx));
				} else {
					if (upperCase) {
						str.append(Character.toUpperCase(line.charAt(idx)));
					} else {
						str.append(Character.toLowerCase(line.charAt(idx)));
					}
					upperCase = upperCase ? false : true;
				}
			}

			System.out.println(str);

		}

	}

}
