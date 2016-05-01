package design_patterns.gof.creational.strategy.esgof_book;

public class StrategyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MyArray m = new MyArray( 10 );
		m.setValue( 1 , 6 );
		m.setValue( 0 , 8 );
		m.setValue( 4 , 1 );
		m.setValue( 9 , 7 );
		System.out.println("This is the array in ’standard’ format");
		m.setDisplayFormat( new StandardFormat() );
		m.display();
		System.out.println("This is the array in ’math’ format:");
		m.setDisplayFormat( new MathFormat() );
		m.display();


	}

}
