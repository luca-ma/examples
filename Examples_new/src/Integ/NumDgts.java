package Integ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumDgts {

	
	public static void main(String[] args) {
	    Integer[] digits = getDigits(12345);
	    System.out.println(Arrays.toString(digits));
	}

	public static Integer[] getDigits(int num) {
	    List<Integer> digits = new ArrayList<Integer>();
	    collectDigits(num, digits);
	    return digits.toArray(new Integer[]{});
	}
	private static void collectDigits(int num, List<Integer> digits) {
	    if(num / 10 > 0) {
	        collectDigits(num / 10, digits);
	    }
	    digits.add(num % 10);
	}

}
