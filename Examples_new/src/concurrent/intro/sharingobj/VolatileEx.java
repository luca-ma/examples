package concurrent.intro.sharingobj;

public class VolatileEx {

	
	/**
	 * CountingSheep--> example of synchronization using volatile variables
	 * <p/>
	 * Counting sheep
	 *
	 * @author Brian Goetz and Tim Peierls
	 */
	
	    volatile boolean asleep;

	    void tryToSleep() {
	        while (!asleep)
	            countSomeSheep();
	    }

	    void countSomeSheep() {
	        // One, two, three...
	    }
	

}
