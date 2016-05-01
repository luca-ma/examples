package ocp_5_exam_string_pattern;

public class SplitExample {

	public static void main(String[] args) throws Exception{
		String str = "Small Smaller Smallest";
		String[] not = str.split("\\s"); 
		System.out.println(not.length);
		}
	
}
