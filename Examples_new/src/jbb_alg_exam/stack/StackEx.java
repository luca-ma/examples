package jbb_alg_exam.stack;

import java.util.Stack;

public class StackEx {

	public static void foo(Stack s1, Stack s2) {
	    if(s1.size() > 0) {
	        Object o = s1.pop();
	        foo(s1,s2);
	        s1.push(o);
	        s2.push(o);
	    }
	}

	public static void main(String[] args) {
	    Stack s1=new Stack();
	    for(int i=0; i<5; i++)
	        s1.push(i);
	    Stack s2=new Stack();
	    foo(s1,s2);
	    while(s2.size() > 0)
	        System.out.println(s2.pop()+" ");
	}
}
