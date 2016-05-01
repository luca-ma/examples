package string;

public class StrEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// BigInteger num = BigInteger.valueOf(123456789123456L);

		// String head = num.toString().substring(0, 10);

		String alias = "user_0_it@unicredit.it";
		String country = alias.substring(alias.lastIndexOf(".") + 1);
		System.out.println(country);
	}

}
