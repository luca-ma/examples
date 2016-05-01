package collection.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 * use java.util.Stack class to
 * create and use a stack structure (LIFO queue)
 * http://www.precisejava.com/javaperf/j2ee/JMS.htm
 */
public class StackImpl {

	

	Stack<Integer> stack;
	String str;
	int num, n;

	public static void main(String[] args){
		StackImpl stack = new StackImpl();
	}
	public StackImpl(){
		try{
			stack = new Stack<Integer>();
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader bf = new BufferedReader(ir);
			System.out.print("Enter number of elements : ");
			str = bf.readLine();
			num = Integer.parseInt(str);
			for(int i = 1; i <= num; i++){
				System.out.print("Enter elements : ");
				str = bf.readLine();
				n = Integer.parseInt(str);
				stack.push(n);
			}
		}catch(IOException e){}
		System.out.print("Retrieved elements from the stack : ");
		while (!stack.empty()){
			System.out.print(stack.pop() + "  ");
		}
	}
}
