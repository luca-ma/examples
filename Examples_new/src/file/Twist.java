package file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Twist {

	public static void main(String[] args) throws IOException {
		try (FileInputStream in = new FileInputStream("exIn.txt");
				FileOutputStream out = new FileOutputStream("exOut.txt");) {
			int data;
			byte[] byteArr = new byte[3]; // #A
			while ((data = in.read(byteArr)) != -1) { // #B
				// out.write(byteArr, 0, data); // #C
				out.write(byteArr);
			}
		}
	}
}
