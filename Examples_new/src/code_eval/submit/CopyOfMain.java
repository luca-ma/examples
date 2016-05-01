package code_eval.submit;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class CopyOfMain {

    private Deque<Integer> data = new ArrayDeque<Integer>();

	  public void push(Integer element) {
	    data.addFirst(element);

	  }
	  
	  public Boolean isStackEmpty () {
		  return data.isEmpty();
	  }

	  public Integer pop() {
	    return data.removeFirst();
	  }

	  public Integer peek() {
	    return data.peekFirst();
	  }

	  public String toString() {
	    return data.toString();
	  }

	  public static void main(String[] args) throws IOException {
		  CopyOfMain stack = new CopyOfMain();
		  
		  File file = new File(args[0]);
		  BufferedReader in = new BufferedReader(new FileReader(file));
		  String line;
		
		  while ((line = in.readLine()) != null) {
			  if(line.length()==0) {
				  continue;
			  }
		 String[] nums = line.split(" ");
		 for (int idx = 0; idx < nums.length; idx++) {
			stack.push(Integer.valueOf(nums[idx]));
		 }
		Boolean skipPrint = false;
		StringBuilder strLine = new StringBuilder();
		while(!stack.isStackEmpty()) {
			 if(!skipPrint) {
				strLine.append(stack.pop()).append(" ");
				skipPrint=true;
			 }else {
				 stack.pop();
				 skipPrint=false;
			}
		 }
		System.out.println(strLine.deleteCharAt(strLine.length()-1));
	    
	  }
	}
}
