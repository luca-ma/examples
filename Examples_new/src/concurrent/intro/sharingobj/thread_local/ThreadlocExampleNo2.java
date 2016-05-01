package concurrent.intro.sharingobj.thread_local;

public class ThreadlocExampleNo2 {

	private static Integer globalCounter =0;
	private ThreadLocal<Integer> localCounter = new ThreadLocal<Integer>(); 
	  public static void main(String[] args)
	    {
	
		 
		  ThreadlocExampleNo2  x = new ThreadlocExampleNo2();
		  x.localCounter.set(0);
		  SimpleThread  t1 = x.new  SimpleThread("prova1");
		 // ThreadlocExampleNo2  y = new ThreadlocExampleNo2();
		 // y.localCounter.set(0);
		  SimpleThread  t2 = x.new  SimpleThread("prova2");
		 
		  Thread thr1 = new Thread(t1);
		  Thread thr2 = new Thread(t2);
          thr1.start();
		  thr2.start();
		
		  
	    }
	  
	  public class SimpleThread implements Runnable{

		
		//private ThreadLocal<Integer> localCounter = new ThreadLocal<Integer>(); 
		private ThreadLocal<String> thrName = new ThreadLocal<String>(); 
		  private String threadName;
		
		public SimpleThread(String name) {
			this.threadName=name;
			//this.localCounter.set(0);
		}
		@Override
		public void run() {
			while (true) {
				try  {
					Integer prevCount = (Integer) localCounter.get();
					 localCounter.set(new Integer(prevCount.intValue() + 1));
				
				
				 synchronized (globalCounter) {
					 globalCounter++;
				}
			     System.out.println("localCounter: "+Thread.currentThread().getName()+":"+localCounter.get()+", thread name:"+thrName.get());
			     System.out.println("globalCounter: "+Thread.currentThread().getName()+":"+globalCounter);
			     if (prevCount>5) {
			        	break;
			     }
				}catch (NullPointerException nExc) {
					 System.out.println("localCounter: first ITer ");
					 thrName.set(this.threadName);
					 localCounter.set(0);
				}
			}
			 
			
		}
		  
	  }
}
