package a;

import java.io.FileWriter;
import java.io.IOException;

class B extends A
{
   int i =   Math.round(3.5f);
   public static void main(String[] args) throws IOException
   {
	   FileWriter fw = new FileWriter("text.txt"); // fw.write("hello"); //1 
	   fw.close();
   }
   void print() { System.out.println(i); }
}