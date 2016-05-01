package euler_prj;

import java.math.BigInteger;

public class Fibonacci2 {

	public static void main(String[] args) {

		BigInteger fn2 = BigInteger.valueOf(1);
		BigInteger fn1 = BigInteger.valueOf(1);
		BigInteger fn;

		BigInteger tailcut = BigInteger.valueOf(1000000000);

		int n = 2;
		Boolean found = false;

		while (!found) {
			n++;

			fn = fn1.add(fn2);
			long tail = (fn.remainder(tailcut)).longValue();
			if (isPandigital(tail)) {
				int digits = 1 + (int) Math.log10(fn.longValue());
				if (digits > 9) {
					// long head = (long) (fn / BigInteger.Pow(10, digits - 9));
					// long head = (fn.divide(BigInteger.valueOf(10).pow(
					// digits - 9))).longValue();

					long head = Long.valueOf(fn.toString().substring(0, 10));
					System.out.println("tail, k:" + n);

					if (n == 329468) {
						System.out.println("num, :" + fn.toString());
						System.out.println("head, :" + head);
					}
					if (isPandigital(head)) {
						found = true;
						System.out.println("fnd, k:" + n);
					}
				}
			}

			fn2 = fn1;
			fn1 = fn;
		}

	}

	private static Boolean isPandigital(long n) {
		int digits = 0;
		int count = 0;
		int tmp;

		while (n > 0) {
			tmp = digits;
			digits = digits | 1 << (int) ((n % 10) - 1);
			if (tmp == digits) {
				return false;
			}

			count++;
			n /= 10;
		}
		return digits == (1 << count) - 1;
	}

}
