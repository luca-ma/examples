package thread.low_level.sync_locks;


public class ThreadSyncWithLocksEx implements Runnable{
	
	Boolean cond = true;
	ClassWithLocks clWithLocks= null;

	public ThreadSyncWithLocksEx(boolean b, ClassWithLocks clWithLocks ) {
		this.clWithLocks = clWithLocks;
		this.cond  = b;
	}

	public static void main(String[] args) {
		
		ClassWithLocks clWithLocks= new ClassWithLocks();
		ThreadSyncWithLocksEx inst1 = new ThreadSyncWithLocksEx(true, clWithLocks);
		ThreadSyncWithLocksEx inst2 = new ThreadSyncWithLocksEx(false, clWithLocks);
		Thread thr1 = new Thread(inst1, "1");
		Thread thr2 = new Thread(inst2, "2");
		thr1.start();
		thr2.start();

	}

	@Override
	public void run() {
		
		if (cond){
			clWithLocks.method1();
		}else {
			clWithLocks.method2();
		}
		
	}

}
