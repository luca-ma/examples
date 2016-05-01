package jbb_alg_exam.recursion.maxcomdiv;

public class MaxComDiv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println (gcd(4, 16) );//4
		System.out.println (gcd(16, 4));//4
		System.out.println (gcd(15, 60));//15
		System.out.println (gcd(15, 65));//5
		System.out.println (gcd(1052, 52));//4
		
		

	}
	
	public static int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}

}
