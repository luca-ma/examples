package ocp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AA implements Interface1 {

	int version =2;
	
	public static void main(String[] args) throws FileNotFoundException {
		AA inst = new AA();
		System.out.println(inst.version);
		System.out.println((((Interface1)inst)).version);
		
		Scanner sc = new Scanner(new File("aa"), ",");
	}
}
