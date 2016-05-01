package thread.low_level.sync_locks;

import java.util.Calendar;

public class ClassWithSync {

	
	public synchronized void  method1(){
		System.out.println(Thread.currentThread().getName()+"_ ENTER method1:"+Calendar.getInstance().getTime());
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"_ EXIT method1:"+Calendar.getInstance().getTime());
	}

	
	public synchronized void  method2(){
		System.out.println(Thread.currentThread().getName()+"_ ENTER method2:"+Calendar.getInstance().getTime());
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"_ EXIT method2:"+Calendar.getInstance().getTime());
	}

}
