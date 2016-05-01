package random;

import java.util.Random;

public class RandomSimple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		calcResolult(123412);

	}
	
	private static void calcResolult(int m) {
		String res="";
		Random rdm = null;
		rdm= new Random(441287210);
		for(int k=0;k<10;k++) {
			res=res+(rdm.nextInt(10)+" ");
		}			
		System.out.println(res);
		String res2="";
		rdm= new Random(-6732303926L);
		for(int k=0;k<10;k++) {
			res2=res2+(rdm.nextInt(10)+" ");	
		}
		System.out.println(res2);
			
	}

}
