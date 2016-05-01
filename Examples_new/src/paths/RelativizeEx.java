package paths;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeEx {

	public static void main(String[] args) {
		
		Path path1 = Paths.get("C:/OCP/8-1.txt");
		System.out.println("path1:"+path1);
		Path path2 = Paths.get("C:", "OCP", "mock", "8-1.txt");
		System.out.println("path2:"+path2);
		System.out.println("path2.relativize(path1):"+path2.relativize(path1));
		Path path3 = path1.resolve(path2.relativize(path1));
		System.out.println(path3);
		System.out.println("path1.resolve(path2):"+path1.resolve(path2));
		
		
		Path pathN1= Paths.get("/A/B/C/D");
		Path pathN2= Paths.get("/A/B/E/F");
		
		System.out.println("pathN1.resolve(pathN2):"+pathN1.resolve(pathN2));
		System.out.println("pathN1.relativize(pathN2):"+pathN1.relativize(pathN2));
		

	}

}
