package concurrent.intro;


/*
 * The code does not acquire a lock on t before calling t.wait(), so it throws an IllegalThreadStateException.
Only the method is synchronized, but it's not synchronized
on t so the exception will be thrown. If the wait were placed inside a synchronized(t) block,
 then the answer would have been "It prints XY with a 1-second delay between X and Y"

 */
public class InvalidThread  extends Thread {
		   public static synchronized void main(String[] args)
		       throws InterruptedException {
		     Thread t = new Thread();
		     t.start();
		     System.out.print("X");
		     t.wait(1000);
		     System.out.print("Y");
		  }
		 }
