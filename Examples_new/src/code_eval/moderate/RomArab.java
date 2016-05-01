package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RomArab {

	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() == 0) {
				continue;
			}
			if (line.startsWith("#")) {
				continue;
			}
			try {
				int idx = 0;
				Integer sum = 0;
				// Integer romNumPrev = 0;
				boolean lastVal = false;
				while (idx < line.length()) {
					if (idx == line.length() - 2) {
						lastVal = true;
					}
					char arabChar = line.charAt(idx);
					// System.out.println(arabChar);
					Integer arabNum = new Integer(String.valueOf(arabChar));
					// System.out.println(arabNum);
					idx++;
					char romChar = line.charAt(idx);
					// System.out.println(romChar);
					Integer romNum = getRomanNum(romChar);
					// System.out.println(romNum);

					Integer result = arabNum * romNum;
					// System.out.println(result);
					if (lastVal) {
						sum += result;
					} else {
						char arabCharNew = line.charAt(idx + 1);
						// System.out.println(arabChar);
						Integer arabNumNew = new Integer(
								String.valueOf(arabCharNew));
						// System.out.println(arabNum);

						char romCharNew = line.charAt(idx + 2);
						// System.out.println(romChar);
						Integer romNumNew = getRomanNum(romCharNew);
						// System.out.println(romNum);

						if (romNum < romNumNew) {
							sum -= result;
						} else {
							sum += result;
						}
					}
					idx++;

				}

				System.out.println(sum);

			} catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}

		}
	}

	/*
	 * I-->1; V-->5, X-->10, L-->50, C-->100, D-->500, or M-->1000.
	 */
	public static int getRomanNum(char romChar) {

		if (romChar == 'I') {
			return 1;
		} else if (romChar == 'V') {
			return 5;
		} else if (romChar == 'X') {
			return 10;
		} else if (romChar == 'L') {
			return 50;
		} else if (romChar == 'C') {
			return 100;
		} else if (romChar == 'D') {
			return 500;
		} else if (romChar == 'M') {
			return 1000;
		} else {
			System.out.println("not fuound num");
		}
		return 0;
	}

}
