package jbb_alg_exam.recursion.recursionex;

public class Test {
	public static int f(int n) {
		int i = f(n-1);
		if(i == 0) {
			return 0;
		}
		else {
			System.out.println(i);
			return(i-1);
		}
	}
	
	public static int binomialCoeff(int n, int k)    {
		     if (n == 1 && k == 1) {
		        return 1;
		     }
		     return binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k);
		 }
	
	 public static int f(int a,int b){
		          if (a == b) return a;
		         else return a > b ? f(a-b,b) : f(a,b-a);
		  }
	public static void main(String[] args) {
	//	int h = f(3);
		//binomialCoeff(3,2);
		int f = f(10,15);
		System.out.println("ew:"+f);
		int[] x = new int[4];
		 x[0] = 1;
		 x[1] = 2;
		 x[2] = 3;
		 x[3] = 4;
		 for (int i = x.length - 1; i > 0; i--) {

			 x[i] = x[i] + x[i-1];

			 }
	for (int i = 0; i <x.length ; i++) {
			System.out.println("x:"+x[i]);
		
	}}
}
