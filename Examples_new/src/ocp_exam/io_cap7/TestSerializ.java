package ocp_exam.io_cap7;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerializ {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		Ser s = new Ser();
//		
		System.out.println(s.getA() + " " + s.getB()+ " " + s.getC());
		 
		FileOutputStream bos = new FileOutputStream(new File("ser.txt"));
		ObjectOutputStream out = new ObjectOutputStream(bos);
		out.writeObject(s);
		out.close();
		 
		ObjectInputStream in = new ObjectInputStream(
			new FileInputStream(new File("ser.txt")));
		Ser extRead = (Ser) in.readObject();
		in.close();
		 
		System.out.println(extRead.getA() + " " + extRead.getB()+ " " + extRead.getC());
	}

}
