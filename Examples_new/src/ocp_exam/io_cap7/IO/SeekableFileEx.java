package ocp_exam.io_cap7.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SeekableFileEx {

	public static void main(String[] args) throws IOException 
 {
		
		
		String filename = "C:\\Users\\luca\\Dropbox\\test\\in.txt";
		int c =0;
		SeekableByteChannel newByteChannel = Files.newByteChannel(Paths.get(filename));
		ByteBuffer allocate = ByteBuffer.allocate(10);
		while((c =newByteChannel.read(allocate))>0){
			allocate.rewind();
			for(int i=0; i<c;i++){
				System.out.print((char)allocate.get());
			}
		}
		
//		BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
//		//System.out.println(Files.readAllLines((Path) System.in));
//		System.out.println(bufR.readLine());
 }

}
