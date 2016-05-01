package ocp_exam.io_cap7.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileEx {

	public static void main(String[] args) throws IOException {
		
		String filename = "C:\\Users\\luca\\Dropbox\\test\\in.txt";
		String outStr = "C:\\Users\\luca\\Dropbox\\test\\out.txt";
		FileInputStream in = new FileInputStream(filename);
		
		FileOutputStream out = new FileOutputStream(outStr);
		
		int read = 0;
		while((read = in.read())!=-1){
			out.write(read);
		}
		

	}

}
