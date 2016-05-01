package ocp_7_io;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccEx {

	public static void main(String[] args) throws IOException {
		
		
		RandomAccessFile raf = new RandomAccessFile("C:\\Users\\luca\\Dropbox\\test\\out.txt", "rw"); 
		//raf.seek( raf.length() ); 
		raf.writeChars("FINAL TEXT");

	}

}
