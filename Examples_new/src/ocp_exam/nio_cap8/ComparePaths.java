package ocp_exam.nio_cap8;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Path p1 = Paths.get("c\\b\\d");
		Path p2 = Paths.get("b\\index.html");
		Path p3 = p1.relativize(p2); 
		System.out.println(p3);

	}

}
