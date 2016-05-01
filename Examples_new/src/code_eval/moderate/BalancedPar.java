package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BalancedPar {

	private Deque<Character> data = new ArrayDeque<Character>();
	private static List<Character> openPars = Arrays.asList('(','[','{');
	private static List<Character> closedPars = Arrays.asList(')',']','}');

	  public  void push(Character element) {
	    data.addFirst(element);

	  }
	  
	  public Boolean isStackEmpty () {
		  return data.isEmpty();
	  }

	  public Character pop() {
	    return data.removeFirst();
	  }

	  public Character peek() {
	    return data.peekFirst();
	  }

	  public String toString() {
	    return data.toString();
	  }

	  public static void main(String[] args) throws IOException {
		  BalancedPar stackPars = new BalancedPar();
		  
		  File file = new File(args[0]);
		  BufferedReader in = new BufferedReader(new FileReader(file));
		  String line;
		
		  while ((line = in.readLine()) != null) {
			  if(line.length()==0) {
				  continue;
			  }
			  Boolean found =true;
			  for (int idx = 0; idx < line.length(); idx++) {
				  Character curChar = line.charAt(idx);
				  if(openPars.contains(curChar)) {
					  stackPars.push(curChar);
				  }else if (closedPars.contains(curChar)) {
					  Character currStackPar = stackPars.peek();
					  if(correctClosingChar(curChar, currStackPar)) {
						  Character pop = stackPars.pop();
					  }else {
						  found = false;
						//  System.out.println("False");
						  break;
					  }

				  }else {
					  System.out.println("invalid char:"+curChar);
					  break;
				  }
				  
			  }
			  if(found) {
				  System.out.println("True");
			  }else {
				  System.out.println("False");
			  }
			  

		  }

	    
	  }
	
	  
	  private static Boolean correctClosingChar (Character closPar, Character openPar) {
		 if(closedPars.indexOf(closPar)==openPars.indexOf(openPar)) {
			 return true;
		 }else {
			 return false;
		 }
	  }
}
