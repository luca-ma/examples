package jbb_prog_apt_ex;

public class WhileInPar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int firstArg=7;
		if (args.length > 0) {
		    try {
		        firstArg = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument" + " must be an integer");
		        System.exit(1);
		    }
		}
		
		int a=firstArg;
		int b=10;
		int c =0;
		while(a<b) {
			c+=1;
			a+=1;;
		}
		
		System.out.println("A:"+a);
		System.out.println("B:"+b);
		System.out.println("C:"+c);

	}

}
