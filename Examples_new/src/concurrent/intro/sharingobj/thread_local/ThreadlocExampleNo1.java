package concurrent.intro.sharingobj.thread_local;

public class ThreadlocExampleNo1 {

	  public static void main(String[] args)
	    {
	
		  final ThreadLocal perThreadCounter = new ThreadLocal();
		  Thread t1 = new Thread() {
		    public void run() {
		      perThreadCounter.set(new Integer(0));
		      while (true) {
		        Integer prevCount = (Integer) perThreadCounter.get();
		        perThreadCounter.set(new Integer(prevCount.intValue() + 1));
		        System.out.println("prevCOunt thr1:"+prevCount);
		        if (prevCount>10) {
		        	break;
		        }
		      }
		    }
		  };
		  Thread t2 = new Thread() {
		    public void run() {
		      perThreadCounter.set(new Integer(0));
		      while (true) {
		        Integer prevCount = (Integer) perThreadCounter.get();
		        perThreadCounter.set(new Integer(prevCount.intValue() + 1));
		        System.out.println("prevCOunt thr2:"+prevCount);
		        if (prevCount>10) {
		        	break;
		        }
		      }
		    }
		  };
		  t1.start();
		  t2.start();
		  
	    }
}
