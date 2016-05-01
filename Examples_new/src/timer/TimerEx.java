package timer;

import java.util.Timer;
import java.util.TimerTask;



public class TimerEx {

	Timer myTimer; 
	private long startAppl =0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TimerEx inst = new TimerEx(0);
		
	}
	
	public TimerEx(int secDelay) {
		myTimer = new Timer();
		startAppl= System.currentTimeMillis();
		myTimer.schedule(new TimerExTask(), secDelay*1000);

	}

//	@Override
//	public void run() {
//		long delay =System.currentTimeMillis() - startAppl ;
//		System.out.println(" after:"+delay);
//		
//	}
	
	class TimerExTask extends TimerTask {
        public void run() {
        	long delay =System.currentTimeMillis() - startAppl ;
        	System.out.println(" after:"+delay);
            myTimer.cancel(); //Terminate the timer thread
        }
    }

	
	

}



