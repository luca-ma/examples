package math;
/*
 * http://www.geeksforgeeks.org/archives/17401
 * 
 * Write a recursive function that counts how many different 
 * ways you can make change for an amount, given a list of coin denominations. 
 * For example, there are 3 ways to give change for 4 if you have coins with denomiation 1 and 2: 1+1+1+1, 1+1+2, 2+2.


 */
public class CountMath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int i, j;
		    int arr[] = {5,10,20,50,100,200,500};
		    int m = arr.length;
		    System.out.println(count(arr, m, 300));
		  
	
	}
	static int count( int S[], int m, int n )
	{
	    // If n is 0 then there is 1 solution (do not include any coin)
	    if (n == 0)
	        return 1;
	     
	    // If n is less than 0 then no solution exists
	    if (n < 0)
	        return 0;
	 
	    // If there are no coins and n is greater than 0, then no solution exist
	    if (m <=0 && n >= 1)
	        return 0;
	 
	    // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
	    return count( S, m - 1, n ) + count( S, m, n-S[m-1] );
	}

	

}
