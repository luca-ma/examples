package ocp_8_nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class SimpleFileVisitor2 extends SimpleFileVisitor<Path>{

	private final PathMatcher matcher;
	private static int count;
	
	public SimpleFileVisitor2(){
		matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
	}

	void check(Path p){
		Path name = p.getFileName();
		if(name != null && matcher.matches(name)){
			count++;
		}
	}
	
	public int getCount(){
		return count;
	}

	public FileVisitResult visitFile(Path p, BasicFileAttributes attr){
		check(p);
		return FileVisitResult.CONTINUE;
	}
	
	public static void main(String[] args) throws IOException {
		SimpleFileVisitor2 mfc = new SimpleFileVisitor2();
		Files.walkFileTree(Paths.get("c:\\users\\luca\\Dropbox\\test"), mfc);
		System.out.println(mfc.getCount());
	}
}
