package string.split;

public class StringBuilderTrunc {

	private static final Integer max = 10;

	public static void main(String[] args) {
		// Integer max = 10;
		StringBuilder okStr = new StringBuilder("123");

		StringBuilder koStr = new StringBuilder("123456789012");

		System.out.println(koStr);
		System.out.println(koStr.length());

		String substr = koStr.substring(0, max - 1);

		System.out.println(substr);
		System.out.println(substr.length());
	}

}
