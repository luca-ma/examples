package test.ulixe;

/**
 * ulixe java test 13 
 * 
 * Spuntare l’output generato
A. X		--> no xche vien sollevata exc
B. Y		
C. YZ		--> si exception + finally
D. Il prorgamma termina con una eccezione di tipo DivideByZeroException
 */
public class Test1 {

	public static void main(String[] args) {


		int i,j=1;

		try {

			i=j/(j-1);

			System.out.print("X");

		}

		catch (Exception e) {

			System.out.print("Y");

		}

		finally {

			System.out.print("Z");

		}

}
 }
