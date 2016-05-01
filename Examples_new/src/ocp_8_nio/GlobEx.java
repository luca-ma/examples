package ocp_8_nio;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class GlobEx {

	public static void main(String[] args) {
		
		
		PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:[!ab]?");
		Path path = Paths.get("av");
		if(pathMatcher.matches(path)){
			System.out.println("mathch");
		}
	}

}
