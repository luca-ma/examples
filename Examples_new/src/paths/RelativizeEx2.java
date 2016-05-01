package paths;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class RelativizeEx2 {

	public static void main(String[] args) {
		
		Path path1 = new File("/home/oracle").toPath();
		Path path2 = FileSystems.getDefault().getPath("/home/java/../hello.txt");
		System.out.println("path1:   "+path1);
		System.out.println("path2:   "+path2);
		System.out.println("");
		System.out.println("path1.resolve(path2):   "+path1.resolve(path2));
		System.out.println("path2.resolve(path1):   "+path2.resolve(path1));
		System.out.println("");
		
		System.out.println("path1.relativize(path2):"+path1.relativize(path2));
		System.out.println("path2.relativize(path1):"+path2.relativize(path1));
		System.out.println("");
		
		System.out.println("path2.normalize():"+path2.normalize());
		System.out.println("path1.normalize():"+path1.normalize());
		

	}

}
