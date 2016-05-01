package thread.low_level;

import java.util.concurrent.atomic.AtomicInteger;


public class ThreadLocEx2 implements Runnable{

	
	Integer countNoSafe = 0;
	public ThreadLocal<Integer>  countSafe =new ThreadLocal<Integer>(){
        @Override public Integer initialValue() {
            return 0;
        }
    };
	static volatile Integer  sharedCountSafe = 0;
	static Integer  sharedCountNoSafe = 0;
	static AtomicInteger sharedAtomic = new AtomicInteger(0);
	public static void main(String[] args) {
		
		ThreadLocEx2 thr = new ThreadLocEx2();
		Thread thr1 = new Thread(thr);
		Thread thr2 = new Thread(thr);
		thr1.start();
		thr2.start();
		
		try {
			thr1.join();
			thr2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" sharCount no safe:"+sharedCountNoSafe);
		System.out.println(Thread.currentThread().getName()+" sharCount SAFE :"+sharedCountSafe);
		System.out.println(Thread.currentThread().getName()+" shared atomic int:"+sharedAtomic);
		
	}
	@Override
	public void run() {
		for(int idx =0 ; idx <5;idx++){
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			countNoSafe++;
			countSafe.set(countSafe.get()+1);
			sharedCountSafe++;
			sharedCountNoSafe++;
			sharedAtomic.incrementAndGet();

		}
		System.out.println(Thread.currentThread().getName()+" no sharCount no safe:"+countNoSafe);
		System.out.println(Thread.currentThread().getName()+" no sharCount SAFE :"+countSafe.get());
	}

}
