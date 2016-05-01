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

public class SimpleFileVisitor1  extends SimpleFileVisitor<Path>{
		private final PathMatcher matcher;
		private static int count;
		
		public SimpleFileVisitor1(){
			matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
			}
		
		void check(Path p){
			if(p != null && matcher.matches(p)){
				count++;
			}
		}
		public int getCount(){
			return count;
			}
		@Override
		public FileVisitResult visitFileFailed(Path p, IOException exc){
			System.out.println("failed");
			exc.printStackTrace();
			return FileVisitResult.CONTINUE;
		}
		
		public FileVisitResult visitFile(Path p, BasicFileAttributes attr){
			check(p);
			return FileVisitResult.CONTINUE;
		}
		
		
			public static void main(String[] args) throws IOException {
				SimpleFileVisitor1 mfc = new SimpleFileVisitor1();
				Files.walkFileTree(Paths.get("c:\\Users\\luca\\Dropbox\\test1"), mfc);
				System.out.println(mfc.getCount());
		}
			}
		