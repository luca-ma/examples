package jbb_prog_apt_ex;

public class WhileEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		int k=0;
		int l =10;
		int n =10;
		while(k<6) {
			n+=2;
			do {
				if(n==8) {
					l=0;
				}
				n--;
				l-=n;
				
			}while(l<=0);
			k+=2;
			l=4;;
		}
		
		System.out.println("N:"+n);

		

	}

}
