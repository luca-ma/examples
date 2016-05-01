package jbb_alg_exam.array.primenums;
/**
 * http://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
 * http://www.dti.unimi.it/citrini/MD/SitoG-M/algoritmi.htm
 * http://knowledgeblackbelt.com/#ExamResult/19176530
 * @author luca
 *
 */
public class SimpleAlg {

	
	public static void main(String[] args) {
	

	}
	
	
	/**
	 * check all nums < n...
	 * complexity O(n-1)
	 */
	static boolean  isPrime1(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	/**
	 * Consider that if 2 divides some integer n, 
	 * then (n/2) divides n as well. 
	 * This tells us we don’t have to try out all integers from 2 to n
	 * 
	 * complexity O(n/2-1)
	 * @param number
	 * @return
	 */
	static boolean isPrimeNumber(long number) {
	    for (long i = 2; i < number/2; i++)
	        if (number % i == 0)
	            return false;
	    return true;
	}
	
	/**
	 * With some more efficient coding, we notice that you really only 
	 * have to go up to the square root of n, because if you list out all of the factors of a number, 
	 * the square root will always be in the middle 
	 * 
	 * complexity O(sqrt(number))
	 * @param number
	 * @return
	 */
	
	public boolean isPrimeNumberSqrt(long number) {
	    for (long i = 2; i <= Math.sqrt(number); i++)
	        if (number % i == 0)
	            return false;
	    return true;
	}

	/**
	 * Finally, we know 2 is the “oddest” prime – it happens to be the only even prime number. 
	 * Because of this, we need only check 2 separately, then traverse odd numbers up to the square root of n.
	 
	 *complexity O(sqrt(number)/2)
	 */
	
	public boolean isPrimeNumberSqrt2(long number) {
	    if(number % 2 == 0)
	        return false;
	    for (long i = 3; i <= Math.sqrt(number); i+=2)
	        if (number % i == 0)
	            return false;
	    return true;
	}
}
