package util;

public class ArrayEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] scores = { 1, 2, 3, 4, 5, 6};
		int[] scores2 = { 0, 0, 0, 0, 0, 0};
        System.arraycopy(scores, 2, scores2, 3, 2);
        for(int i :  scores2) System.out.print(i);
  //      System.arraycopy(scores, 2, scores, 3, 2);


	}

}
