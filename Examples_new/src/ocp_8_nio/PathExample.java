package ocp_8_nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer beginIndex =0;
		Integer endIndex = 2;

		Path wordpadPath = Paths.get("C:\\Program Files\\Windows NT\\Accessories\\wordpad.exe");
		System.out.println(wordpadPath.subpath(beginIndex, endIndex));
		
		
		Path p1 = Paths.get("c:\\personal\\.\\photos\\..\\readme.txt");
		Path p2 = Paths.get("c:\\personal\\index.html");
		Path p3 = p1.relativize(p2);
		System.out.println(p3);
	}

}
