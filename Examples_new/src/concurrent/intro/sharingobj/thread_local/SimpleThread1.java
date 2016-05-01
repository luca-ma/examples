package concurrent.intro.sharingobj.thread_local;

public class SimpleThread1 extends Thread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 new SimpleThread1("Jamaica").start();
	        new SimpleThread1("Fiji").start();

	}
	
	    public SimpleThread1(String str) {
		super(str);
	    }
	    public void run() {
		for (int i = 0; i < 10; i++) {
		    System.out.println(i + " " + getName());
	            try {
			sleep((int)(Math.random() * 1000));
		    } catch (InterruptedException e) {}
		}
		System.out.println("DONE! " + getName());
	    }
	

}
