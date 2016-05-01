package jbb_alg_exam.recursion.recursionex;

public class RecursionEx2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RecursionEx2.f(4);

	}
	public static int f(int s){

		if(s != 0){
			System.out.print(f(s-1));
		}
		return s;
	}

}
