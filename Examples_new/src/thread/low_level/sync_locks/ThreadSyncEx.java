package thread.low_level.sync_locks;


public class ThreadSyncEx implements Runnable{
	
	Boolean cond = true;
	ClassWithSync clWithSync = null;

	public ThreadSyncEx(boolean b, ClassWithSync clWithSync ) {
		this.clWithSync = clWithSync;
		this.cond  = b;
	}

	public static void main(String[] args) {
		
		ClassWithSync clWithSync = new ClassWithSync();
		ThreadSyncEx inst1 = new ThreadSyncEx(true, clWithSync);
		ThreadSyncEx inst2 = new ThreadSyncEx(false, clWithSync);
		Thread thr1 = new Thread(inst1, "1");
		Thread thr2 = new Thread(inst2, "2");
		thr1.start();
		thr2.start();

	}

	@Override
	public void run() {
		
		if (cond){
			clWithSync.method1();
		}else {
			clWithSync.method2();
		}
		
	}

}
