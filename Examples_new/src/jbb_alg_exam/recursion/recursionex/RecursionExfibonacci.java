package jbb_alg_exam.recursion.recursionex;

public class RecursionExfibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int num =4;
			int fib = RecursionExfibonacci.fib(num);
			System.out.println("num: "+num+", fib:"+fib);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	static int fib(int n) throws Exception{
		int result;
		if(n<0){
			throw new Exception("out of domain");
		}else if(n<2){
			result = n;
		}else{
			result = fib(n-2) + fib(n-1);
		}
		return result;
	}

}
