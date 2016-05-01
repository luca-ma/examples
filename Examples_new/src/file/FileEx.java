package file;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("check pp :"+checkFile(Paths.get("pp")));
		System.out.println("check prova:"+checkFile(Paths.get("prova")));
	}

	public static int checkFile(Path path) {
		if (Files.exists(path))
			return 1;
		else {
			if (Files.notExists(path))
				return 2;
			else
				return 3;
		}
	}

}
