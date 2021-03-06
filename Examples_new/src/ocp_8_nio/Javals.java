package ocp_8_nio;

import java.io.IOException;
import java.nio.file.*;
class Javals {
	public static void main(String []args) {
		Path currPath = Paths.get(".");
		try (DirectoryStream<Path> javaFiles = Files.newDirectoryStream
		(currPath, "*.java")) {
			for(Path javaFile : javaFiles) {
				System.out.println(javaFile);
			}
		} catch (IOException ioe) {
			System.err.println("IO Error occurred");
			System.exit(-1);
		}
	}
}
