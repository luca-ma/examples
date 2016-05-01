package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;



public class PrefixExpr {

	private Deque<String> data = new ArrayDeque<String>();

	public  void push(String element) {
		data.addFirst(element);

	}

	public Boolean isStackEmpty () {
		return data.isEmpty();
	}

	public String pop() {
		return data.removeFirst();
	}

	public String peek() {
		return data.peekFirst();
	}

	public String toString() {
		return data.toString();
	}

	public static void main(String[] args) throws IOException {

		 
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				  continue;
			}
			PrefixExpr stack = new PrefixExpr();
			try {
				String[] split = line.split(" ");
				List<String> asList = Arrays.asList(split);
				Collections.reverse(asList);
				Integer expr =0;
				Boolean firstOp =true;
				for(int idx=0; idx <asList.size();idx++) {
					Character charAt = asList.get(idx).charAt(0);
					if(Character.isDigit(charAt)) {
						stack.push(asList.get(idx));
					}else {//char is an operator
						Integer num1 = Integer.valueOf(stack.pop());
						Integer secNum  = 0;
						if(firstOp) {
							firstOp =false;
							secNum =Integer.valueOf(stack.pop());
						}else {
							secNum =expr;
						}
						if(charAt=='+') {
							expr = (num1+ secNum);
						}else if(charAt=='-') {
							expr = (num1-secNum);
						}else if(charAt=='*') {
							expr = (num1*secNum);
						}else if(charAt=='/') {
							expr = (num1/secNum);
						}
					}
				}
				
				
				
				System.out.println(expr);
				
				
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
		
			
		}
	}
	
}
