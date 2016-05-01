package test.ulixe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;

public class BuffReader {

	/**
	 * /**
 * test ulixe java 8
 * 
 * dei seguenti statement sono un utilizzo corretto di BufferedReader

Spuntare le risposte corrette
A. BufferedReader bufferedReader = new BufferedReader("file.txt "); //NO
B. BufferedReader bufferedReader = new BufferedReader(			//OK
new FileReader(new File("file.txt"))
);
C. BufferedReader bufferedReader = new BufferedReader(  //NO REader classe astratta
new Reader(new File("file.txt"))
);
D. BufferedReader bufferedReader = new LineNumberReader(	//OK
new FileReader("file.txt ")
);
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		 BufferedReader bufferedReader1 = new BufferedReader(new FileReader(new File("file.txt")));
		BufferedReader bufferedReader = new LineNumberReader(new FileReader("file.txt "));
	}

}
