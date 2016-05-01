package jbb_alg_exam.recursion.recursionex;

public class REcursExec {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(calculate(1, 1));

	}
	 public static int calculate(int b,int a){
		         if(a < 0) 
		                    return a + b;
		          return calculate(a, a + b);
		      }   
	}
