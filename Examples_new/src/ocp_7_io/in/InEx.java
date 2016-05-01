package ocp_7_io.in;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InEx {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File fileIn = new File("C:\\Users\\luca\\Dropbox\\test\\in.txt");
	      // creates the file
	     // fileIn.createNewFile();
	      File fileOu = new File("C:\\Users\\luca\\Dropbox\\test\\out.txt");
	      // creates the file
	     // fileOu.createNewFile();
	      // creates a FileWriter Object
	      FileWriter writer = new FileWriter(fileOu); 
	    

	      //Creates a FileReader Object
	      FileReader fr = new FileReader(fileIn); 
		
	int VAL = -1;
	int ch;
	while( (ch = fr.read()) != VAL) {
		writer.write( (char)ch );
		}
	
	writer.flush();
	}
	
}
