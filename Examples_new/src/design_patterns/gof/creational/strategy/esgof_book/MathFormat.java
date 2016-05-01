package design_patterns.gof.creational.strategy.esgof_book;

public class MathFormat implements ArrayDisplayFormat {
	public void printData( int[] arr ) {
		for(int i=0; i < arr.length ; i++ )
			System.out.println( "Arr[ " + i + " ] = " + arr[i] );
	}
}
