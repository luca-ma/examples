package euler_prj;

import java.math.BigInteger;
import java.util.TreeSet;

public class Fibonacci_pb104 {

	public static void main(String[] args) throws InterruptedException {

		TreeSet<Integer> fibSetPre = new TreeSet<Integer>();
		TreeSet<Integer> fibSetPost = new TreeSet<Integer>();
		Boolean foundPre = false;
		Boolean foundPost = false;

		BigInteger fn_2 = BigInteger.valueOf(1);
		BigInteger fn_1 = BigInteger.valueOf(1);
		BigInteger fn;
		Integer k = 3;
		while (true) {

			fn = fn_1.add(fn_2);
			// System.out.println("fib num:" + k + ", val:" + fn);

			String fibNumStr = fn.toString();
			if (fibNumStr.length() > 10) {
				for (int idx = 0; idx < 9; idx++) {
					// char charAt = fibNumStr.charAt(idx);
					String car = fibNumStr.substring(idx, idx + 1);
					if (car.equals("0")) {
						break;
					}
					fibSetPre.add(Integer.parseInt(car));
				}
			}
			if (fibSetPre.size() == 9) {
				System.out.println("fib num pre ok :" + k + ", val:" + fn);
				if (fibNumStr.length() > 10) {
					for (int idx = 0; idx < 9; idx++) {
						// char charAt = fibNumStr.charAt(idx);
						String car = fibNumStr.substring(fibNumStr.length()
								- idx - 1, fibNumStr.length() - idx);
						if (car.equals("0")) {
							break;
						}
						fibSetPost.add(Integer.parseInt(car));
					}
				}
				if (fibSetPost.size() == 9) {
					System.out.println("fib num:" + k + ", val:" + fn);
					break;
				}

			}

			fibSetPost.clear();
			fibSetPre.clear();

			// Thread.sleep(1000);
			fn_2 = fn_1;
			fn_1 = fn;
			k++;
		}

	}
}
