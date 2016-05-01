package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Path p1 = Paths.get("c:\\code\\java\\PathTest.java"); 
	//	p1.getRoot()  is c:\  ((For Unix based environments, the root is usually / ). p1.getName(0)  is code p1.getName(1)  is java p1.getName(2)  is PathTest.java
		System.out.println(p1.getRoot().toString());
		System.out.println(p1.getName(0).toString());

	}

}
