package ocp_exam.nio_cap8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopyLink {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Path p1 = Paths.get("C:\\Users\\luca\\Dropbox\\test\\out.txt");
		Files.delete(p1);
		System.out.println(p1);

	}

}
