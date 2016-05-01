package ocp_7_io;

import java.util.*; 
public class MyScan { 
public static void main(String[] args) { 
String in = "1 a 10 . 100 1000"; 
Scanner s = new Scanner(in); 
int accum = 0; 
//for(int x = 0; x < 4; x++) { 
while(s.hasNext()){ 
	String next = s.next();
	System.out.println(next);
	//accum += Integer.valueOf(next); 

} 
System.out.println(accum); 
} 
} 