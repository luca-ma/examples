package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParseFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(
				new FileReader(
						"D:\\Maderna\\luca\\dropbox\\Dropbox\\Examples_new\\src\\file\\file.txt"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}

	}
}
