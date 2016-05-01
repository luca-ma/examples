package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Filesize {

	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		long filesize = file.length();
        System.out.println(""+filesize);

	}
	
}
