package jbb_alg_exam.recursion.recursionex;

public class RecursionEx1 {

	
		   public static void main( String []args ) {        
		    g( 5 );
		     h( 5 );     
		   }
		     
		   private static void g(int n) {
		     if(n == 0) return;
		     System.out.print(  n + " ");
		     h( n-1 );
		   }
		
		  private static void h(int n) {
		     if(n == 0) return;
		     g( n-1 );
		    System.out.print( n + " ");
		   }


}
