package ocp_exam.nio_cap8;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Path p1 = Paths.get("c:\\b\\d");
		Path p2 = Paths.get("c:\\e\\..\\b\\d");
		Path p3 = Paths.get("c:\\B\\d");
		
		boolean equals = p1.equals(p2);
		System.out.println(equals);
		
		int compareTo = p1.compareTo(p2);
		System.out.println(compareTo);
		
		boolean equals2 = p1.equals(p3);
		System.out.println(equals2);
		
		int compareTo2 = p1.compareTo(p3);
		System.out.println(compareTo2);
	}

}
