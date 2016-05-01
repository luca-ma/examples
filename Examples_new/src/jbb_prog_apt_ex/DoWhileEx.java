package jbb_prog_apt_ex;

public class DoWhileEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int a=0;
		int b=0;
		do {
			a=a+1;
			b+=a;
		}while(a<=5);
		
		System.out.println("A:"+a);
		System.out.println("B:"+b);

	}

}
