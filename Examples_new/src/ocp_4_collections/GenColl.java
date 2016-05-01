package ocp_4_collections;

public class GenColl {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SimpleCounter<Double> doubleCounter = new SimpleCounter<Double>();
		SimpleCounter<Integer> intCounter = null;
		SimpleCounter rawCounter = new SimpleCounter(); // RAW
		System.out.println("SimpleCounter<Double> counter is "
		+ doubleCounter.getCount());
		System.out.println("SimpleCounter<Integer> counter is " + intCounter.getCount());
		System.out.println("SimpleCounter counter is " + rawCounter.getCount());
	}

}
