package ocp_exam.io_cap7.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesEx {

	public static void main(String[] args) throws IOException 
 {
		
		
		String filename = "C:\\Users\\luca\\Dropbox\\test\\in.txt";
		String outStr = "C:\\Users\\luca\\Dropbox\\test\\out.txt";

		System.out.println(Files.readAllLines(Paths.get(filename)));
		
		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
		//System.out.println(Files.readAllLines((Path) System.in));
		System.out.println(bufR.readLine());
 }

}
