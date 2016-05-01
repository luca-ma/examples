package ocp_7_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SErialEx implements Serializable{

	String str = "AA";
	transient String  str2 = "AA";
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		SErialEx obj = new SErialEx();
		obj.str="str";obj.str2="str2";
		
		FileOutputStream bos = new FileOutputStream(new File("ser.txt"));
		ObjectOutputStream out = new ObjectOutputStream(bos);
		out.writeObject(obj);
		out.close();
		 
		ObjectInputStream in = new ObjectInputStream(
			new FileInputStream(new File("ser.txt")));
		SErialEx extRead = (SErialEx) in.readObject();
		in.close();
		 
		System.out.println(extRead.str + " " + extRead.str2);

		

	}

}
