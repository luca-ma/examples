package ocp_exam.string_regex_cap5;

public class StrFormatEx {

	enum Color {

		RED("yellow"),
		YELLOW("blue"),
		BLUE("red");
		String color;

		Color(String c) {
			this.color = color;
		}
	}

	Integer qty = 991177;

	public static void main(String[] args) {

		StrFormatEx strFormat = new StrFormatEx();
		System.out.printf("I want: [%-+5d]] bottles of %s color",
				strFormat.qty, Color.RED);
	}
}
