package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SimpleCalculator {

	
	
	  public static void main(String[] args) throws IOException {
		  SimpleCalculator stackPars = new SimpleCalculator();
		  
		  File file = new File(args[0]);
		  BufferedReader in = new BufferedReader(new FileReader(file));
		  String line;
		
		  while ((line = in.readLine()) != null) {
			  if(line.length()==0) {
				  continue;
			  }
			  	  double evaluate = evaluate(line);
			  	double fractionalPart = evaluate % 1;
			  	if(fractionalPart==0){
			  		System.out.println(String.format("%.0f", evaluate ));
			  	}else {
			  		System.out.println(String.format("%.5f", evaluate ));
			  	}
				  
			 
		  }

	    
	  }
	
	  
	  public static double evaluate(String s)  
	   // Precondition: The string is a fully parenthesized arithmetic expression
	   // formed from non-negative numbers, parentheses, and the four operations
	   // +, -, *, and /.
	   // Postcondition: The string has been evaluated and the value returned.
	   // Exceptions: Can throw an NumberFormatException if the expression contains
	   // characters other than digits, operations, parentheses and whitespace.
	   // Can throw IllegalArgumentException if the input line is an
	   // illegal expression, such as unbalanced parentheses or a division by zero.
	   {
	      Scanner input = new Scanner(s);      
	      LinkedList<Double> numbers = new LinkedList<Double>( );
	      LinkedList<Character> operations = new LinkedList<Character>( );
	      String next;
	      char first;
	     
	      while (input.hasNext( ))
	      {
	     if (input.hasNext(UNSIGNED_DOUBLE))
	     {
	        next = input.findInLine(UNSIGNED_DOUBLE);
	        numbers.addFirst(new Double(next));
	     }
	     else
	     {
	        next = input.findInLine(CHARACTER);
	        first = next.charAt(0);
	     
	        switch (first)
	        {
	        case '+': // Addition
	        case '-': // Subtraction
	        case '*': // Multiplication
	        case '/': // Division
	        case '^': // power
	        	if(input.findInLine(CHARACTER).charAt(0) == '-'){
	        		operations.addFirst('&');
	        	}else {
	        		operations.addFirst(first);
	        	}
	           
	           break;
	        case ')': // Right parenthesis
	           evaluateStackTops(numbers, operations);
	           break;
	        case '(': // Left parenthesis
	           break;
	        default : // Illegal character
	           throw new IllegalArgumentException("Illegal character");
	        }
	     }
	      }
	      if (numbers.size( ) != 1){
	    	  evaluateStackTops(numbers, operations);
	      }
	        // throw new IllegalArgumentException("Illegal input expression");
	      return numbers.pop( );
	   }
	  
	  
	   public static void evaluateStackTops(LinkedList<Double> numbers, LinkedList<Character> operations)    
	   // Precondition: The top of the operations stack contains +, -, *, or /, and
	   // the numbers stack contains at least two numbers.
	   // Postcondition: The top two numbers have been popped from the numbers stack, and the
	   // top operation has been popped from the operations stack. The two numbers have been
	   // combined using the operation (with the second number popped as the left operand).
	   // The result of the operation has then been pushed back onto the numbers stack.
	   // Exceptions: Throws an IllegalArgumentException if the stacks are illegal or if the
	   // operation results in a division by zero.
	   {
	      double operand1, operand2;
	     
	      // Check that the stacks have enough items, and get the two operands.
	      if ((numbers.size( ) < 2) || (operations.isEmpty( )))
	         throw new IllegalArgumentException("Illegal expression");       
	      
	     
	      while(operations.size()>0) {
	    	  
	    	  int idx2Remove = (operations.size() -1) -getIdxOperator(operations);
	    	  
	    	  operand1 = numbers.remove(idx2Remove+1);
	    	  operand2 = numbers.remove(idx2Remove );
	    	  
	      // Carry out an action based on the operation on the top of the stack.
	      switch (operations.remove(idx2Remove))
	      {
	         case '+': numbers.add(idx2Remove,operand1 + operand2);
	                   break;
	         case '-': numbers.add(idx2Remove, operand1 - operand2);
	                   break;
	         case '*': numbers.add(idx2Remove, operand1 * operand2);
	                   break;
	         case '/': // Note: A division by zero results in POSTIVE_INFINITY or
	               // NEGATIVE_INFINITY.
	                   numbers.add(idx2Remove,operand1 / operand2);
	                   break;
	         case '^': // power
	        	 		numbers.add(idx2Remove,Math.pow(operand1 ,operand2));
	        	 		break;
	         case '&': // power
     	 		numbers.add(idx2Remove,Math.pow(operand1 ,-operand2));
     	 		break;
	         default : throw new IllegalArgumentException("Illegal operation");
	      }
	      }
	   }
	   public static final Pattern CHARACTER =
			     Pattern.compile("\\S.*?"); 
			   public static final Pattern UNSIGNED_DOUBLE =
			     Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
			   
	   private static int getIdxOperator(Deque<Character> inOperations){
		   Deque<Character> operations = new LinkedList<Character> (inOperations);
		   int retIdx =0;
		   int maxPrio = 10;
		   int currIdx=0;
		   while(operations.size()>0) {
			   int currPrio = getPrio(operations.removeLast());
      			   if(currPrio>maxPrio){
      				   maxPrio = currPrio;
      				   retIdx  = currIdx;
      					   }
      			   currIdx++;
		   }
		   return retIdx;
		   
	   }
			   
	   private static int getPrio(Character ch){
		   switch (ch)
		      {
		         case '+': 
		         case '-': 
		        	 return 20;
		         case '*': 
		         case '/': 
		        	 return 30;
		         case '^': 
		        	 return 40;
		         default: return 20;
		      }
	   }

}
