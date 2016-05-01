package ocabook.cap1.b;

public class StringCl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "12345678903";

		System.out.println(str.charAt(2));
		System.out.println(str.indexOf("3", 4));
		System.out.println(str.replace("2", ""));
		System.out.println(str.lastIndexOf("3"));
		System.out.println(str.split("3").length);
		for (String el : str.split("3")) {
			System.out.println(el);
		}

		// System.out.println(str.repl("3").length);

	}

}
