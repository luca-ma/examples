package thread.low_level.sync_locks;

import java.util.Calendar;

public class ClassWithLocks {

	Object lock1 = new Object();
	Integer lock2 =0;
	
	public  void  method1(){
		synchronized (lock1) {


			System.out.println(Thread.currentThread().getName()+"_ ENTER method1"+Calendar.getInstance().getTime());
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"_ EXIT method1"+Calendar.getInstance().getTime());

		}
	}

	
	public  void  method2(){
		
		synchronized(lock2){
			System.out.println(Thread.currentThread().getName()+"_ ENTER method2"+Calendar.getInstance().getTime());
			try {
				Thread.currentThread().sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"_ EXIT method2"+Calendar.getInstance().getTime());
		}
		
		
	}

	}
