package ocp_exam.io_cap7.IO;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWEx {

	public static void main(String[] args) throws IOException 
 {
		
		
		String filename = "C:\\Users\\luca\\Dropbox\\test\\in.txt";
		String outStr = "C:\\Users\\luca\\Dropbox\\test\\out.txt";
		
		PrintWriter pw = new PrintWriter(outStr);
		pw.printf("prova %s", "pw");
		pw.close();
	
		FileWriter fw = new FileWriter(outStr);
		fw.printf("prova %s", "pw");
		fw.close();
 
 }

}
