package file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class FileMultilineStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File fileNorm = new File("./file.txt");

		String lines = "attr1=val1, attra=val2;\n" +
		// String Line2 =
				"attr3=val3, attra=val3;\n";
		String.format(lines);

		try {
			// Create file
			FileWriter fstream = new FileWriter(fileNorm);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(lines);
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}

}
