package concurrent.intro;


/**
 * example of unthread safe simple program
 * value++ is not a single operation (but three operation in one) !!!!!!!!!!!
 * two different  thread can retry same value!!
 * @author luca
 *
 */
@NotThreadSafe
public class UsafeSequence {

	
	private int value;
	
	public int getNext() {
		return value++;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
