package ocp_8_nio;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class FileCopyEx {

	public static void main(String[] args) throws IOException {
		
		Path path = Paths.get("C:\\users\\luca\\Dropbox\\test1.txt");
		Path path1 = Paths.get("C:\\users\\luca\\Dropbox\\test\\text2.txt");
		Path path2 = Paths.get("c:\\users\\luca\\Dropbox\\test\\text1.txt");
		
		System.out.println(Files.isDirectory(path));
		//Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);
	//	Files.copy(path1, path2,StandardCopyOption.ATOMIC_MOVE);
		//Files.isDirectory(path);
		BufferedWriter br = Files.newBufferedWriter(path, Charset.forName("UTF-8"), 
				new OpenOption[] {StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING});
	}

}
