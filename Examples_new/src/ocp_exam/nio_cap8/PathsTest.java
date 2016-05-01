package ocp_exam.nio_cap8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		Path link = Paths.get("C:\\Users\\luca\\Dropbox\\test\\incoll");
		Path link2 = Paths.get("C:\\Users\\luca\\Dropbox\\test\\incoll2");
		Files.copy(link,link2);
		//System.out.println(p1);

	}

}
