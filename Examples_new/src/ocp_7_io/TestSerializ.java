package ocp_7_io;

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
		
		
		Extend ext = new Extend();
//		ext.setId(123);
//		//ext.setNome("ABC");
//		ext.setName("aa");
//		ext.setStatParam("AAAA");
//		
//		System.out.println(ext.getId() + " " + ext.getName()+ " " + ext.getStatParam());
//		 
//		FileOutputStream bos = new FileOutputStream(new File("ser.txt"));
//		ObjectOutputStream out = new ObjectOutputStream(bos);
//		out.writeObject(ext);
//		out.close();
		 
		ObjectInputStream in = new ObjectInputStream(
			new FileInputStream(new File("ser.txt")));
		Extend extRead = (Extend) in.readObject();
		in.close();
		 
		System.out.println(extRead.getId() + " " + extRead.getName()+ " " + extRead.getStatParam());

	}

}
