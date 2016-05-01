package jbb_prog_apt_ex;

public class RecursionExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RecursionExample recEx = new RecursionExample();
		recEx.myMethod(10);

	}
	
	public void myMethod(int x) {
		           if(x != 0) { 
		                System.out.println(x);
		                x = x - 1;
		                myMethod(x);
		          } else {
		               System.out.println("Done!");
		          }
	}

}
