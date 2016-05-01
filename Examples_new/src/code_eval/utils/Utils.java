package code_eval.utils;

public class Utils {

	/**
	 * The Fibonacci series is defined as: F(0) = 0; 
	 * F(1) = 1; F(n) = F(n-1) + F(n-2) when n>1;. Given a positive integer 'n', print out the F(n).
	 */
	public static Integer fibonacci (Integer num) {
		
		if(num==null) {
			return 0;
		}else if(num<0) {
			return 0;
		}else if (num.equals(0)) {
			return 0;
		}else if (num.equals(1)) {
			return 1;
		}else {
			return (fibonacci(num-1)+fibonacci(num-2));
		}
	}
	
	
	
	public static Boolean isPalidrome (StringBuilder str) {
		return (str.equals(str.reverse()));
	}
	/**
	 * True/False if the second string is a rotation of the first
	 * @param s1
	 * @param s2
	 * @return
	 */
	boolean isRotation(String s1,String s2) {
	    return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
	}
	
	public static boolean isPrimeNum(Integer num) {
		   //check if n is a multiple of 2
	    if (num%2==0) return false;
	    //if not, then just check the odds
	    for(int i=3;i*i<=num;i+=2) {
	        if(num%i==0)
	            return false;
	    }
	    return true;
	}
}
