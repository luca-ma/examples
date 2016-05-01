package ocp_exam.string_pattern_cap5;

public class StringTokenizerEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.StringTokenizer st = new java.util.StringTokenizer("a aa aaa", "x", false);
		while (st.hasMoreTokens()) { 
			System.out.println(st.nextToken());
			}
	}

}
