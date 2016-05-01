package ocp_5_exam_string_pattern;

public class FormatExample {

	public static void main(String[] args) {
		
		System.out.printf("\"%-5c\"", 'c');
		System.out.println();
		System.out.printf("\"%+07d\"",  100);
		System.out.println();
		System.out.printf("\"$%(,2.2f\"", -1222.2);
		System.out.println();
		System.out.printf("\"%c\"", new Character('d'));
		System.out.println();
		System.out.printf("%s", new Object());
		System.out.println();
		System.out.println();
		System.out.printf("\"%-+6d4\"",  100);
		System.out.println();
		System.out.printf("\"%(d+10\"",  -200);
		System.out.println();
		System.out.printf("\"$%.3f\"",  -23.20);
	}

}
