package ocp_exam.io_cap7.IO;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class OpenOptionExample {

	public static void main(String[] args) throws IOException {
		
		
		Path myfile = Paths.get("c:\\Users\\luca\\Dropbox\\test\\test.txt"); 
		try (BufferedWriter br = Files.newBufferedWriter(myfile, Charset.forName("UTF-8"),
		//new OpenOption[] {StandardOpenOption.CREATE});){// sovrascrive il file se già esiste
		//new OpenOption[] {StandardOpenOption.CREATE_NEW});){// solleva exceptionse il file se già esiste
		//new OpenOption[] {StandardOpenOption.WRITE});){// solleva exceptionse il file se non esiste, se esite sovrascrive
		new OpenOption[] {StandardOpenOption.APPEND, StandardOpenOption.WRITE});){		
				br.write("Pa");
		}

	}

}
