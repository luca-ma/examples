package ocp_exam.io_cap7.IO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamEx {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		String s = "hello";
		byte i = 100; 
		FileOutputStream fos = new FileOutputStream("data.bin");
		DataOutputStream dos = new DataOutputStream(fos);
		
		//WRITE s to file 
		dos.writeUTF(s);
		//WRITE i to file         
		dos.writeByte(i);
		
		dos.flush(); 
		dos.close();
		fos.close();  
		DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"));
		
		//READ s from file  
		System.out.println(dis.readUTF());
		
		//READ i from file
		System.out.println(dis.readByte());

	}

}
