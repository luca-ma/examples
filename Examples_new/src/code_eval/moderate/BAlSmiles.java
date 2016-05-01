package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BAlSmiles {

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
		  BAlSmiles stackPars = new BAlSmiles();
		  
		  File file = new File(args[0]);
		  BufferedReader in = new BufferedReader(new FileReader(file));
		  String line;
		
		  while ((line = in.readLine()) != null) {
			  if(line.length()==0) {
				  continue;
			  }
			  stackPars = new BAlSmiles();
			  Boolean found =true;
			  Boolean skipNextPar=false;
			  for (int idx = 0; idx < line.length(); idx++) {
				  Character curChar = line.charAt(idx);
				 // Character nexChar = line.charAt(idx);
				 if(skipNextPar) {
					 skipNextPar =false;
					 continue;
				 }
				  if((curChar.equals(':'))&&(idx!=line.length()-1)) {
					  if(line.charAt(idx+1)=='(') {
						  skipNextPar =true;
					  }
					  if(line.charAt(idx+1)==')') {
						  if((stackPars.isStackEmpty())||(stackPars.isStackEmpty()&&!stackPars.peek().equals('('))) {
							  skipNextPar =true;
						  }
					  }
				  }
					  
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
					//  System.out.println("invalid char:"+curChar);
					//  break;
				  }
				  
			  }
			  if(found) {
				  if(stackPars.isStackEmpty()) {
					  System.out.println("YES");
				  }else  {
					  System.out.println("NO");
				  }

			  }else {
				  System.out.println("NO");
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
