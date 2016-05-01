package concurrent.intro;

import net.jcip.annotations.GuardedBy;


/**
 * example of unthread safe simple program
 * value++ is not a single operation (but three operation in one) !!!!!!!!!!!
 * two different  thread can retry same value!!
 * --> NOW is thread safe cause method is synchronized
 * @author luca
 *
 */
//@ThreadSafe
public class UsafeSequenceLocked {

	
	@GuardedBy ("this")
	private int value;
	
	public synchronized int getNext() {
		return value++;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
