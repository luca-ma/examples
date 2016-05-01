package test.ulixe;

public class TestInt {

	/**
	 * test ulixe 20 
	 * Spuntare l’affermazione corretta
	 * 
	 * che cosa restituisce (a==b)?
A. Errore di compilazione
B. Runtime Exception
C. True
D. False
	 */
	public static void main(String[] args) {
		Integer a = new Integer(2);
		Integer b = new Integer(2);

		if(a==b) {
			System.out.println("a==b");
		}else {
			System.out.println("a!=b");
		}
		System.out.println(a==b);
	}

}
