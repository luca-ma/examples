package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NiceAngles {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() == 0) {
				continue;
			}
			StringBuffer resStr = new StringBuffer();

			resStr.append(line.substring(0, line.indexOf('.') + 1));

			String strMinSec = "0." + line.substring(line.indexOf('.') + 1);
			Double min = 60.0 * Double.valueOf(strMinSec);
			String minStr = String.valueOf(min);
			String minStrN = minStr.substring(0, minStr.indexOf('.'));
			String sec = "0." + minStr.substring(minStr.indexOf('.') + 1);
			Double secD = 60.0 * Double.valueOf(sec);
			String secStr = String.valueOf(secD);
			String secStrN = secStr.substring(0, secStr.indexOf('.'));

			if (Integer.valueOf(minStrN) < 10) {
				minStrN = "0" + minStrN;
			}
			if (Integer.valueOf(secStrN) < 10) {
				secStrN = "0" + secStrN;
			}
			resStr.append(minStrN).append('\'').append(secStrN).append("\"");
			// System.out.println(line);
			System.out.println(resStr);

		}

	}
}
