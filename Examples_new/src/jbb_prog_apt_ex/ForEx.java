package jbb_prog_apt_ex;

public class ForEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x=0;
		int I= 123;
		int J=132;
		boolean P =false;
		
		for(int A =I; A<=J; A++) {
			P=true;
			for(int B =2; B<A; B++) {
			if (A % B == 0) {
	               P = false;
	           }
			}
			if( P ) {
		           x+=A;
		       } 
			
		}
		
		System.out.println("X:"+x);
		//System.out.println("B:"+b);
		

	}

}
