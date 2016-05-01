package ocp_5_exam_string_pattern;

public class StringTokenizerEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.StringTokenizer st = new java.util.StringTokenizer("a aa aaa", "x", true);
		while (st.hasMoreTokens()) { 
			System.out.println(st.nextToken());
			}
	}

}
