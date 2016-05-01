package thread.low_level;

public class ThreadLocal_Example implements Runnable{

	String strNoThrSafe = "";
	public ThreadLocal<String>  strThrSafe =new ThreadLocal<String>();
	
	public ThreadLocal_Example() {
		super();
		
	}

	public static void main(String[] args) {
		ThreadLocal_Example run_ex = new ThreadLocal_Example();
		
		Thread thr1 = new Thread(run_ex,"THR_1");
		Thread thr2 = new Thread(run_ex,"THR_2");
		thr1.start();
		thr1.setPriority(2);
		thr1.setDaemon(true);
		thr2.start();
		

	}

	@Override
	public void run() {

		String thrName = Thread.currentThread().getName();
		this.strThrSafe.set(thrName);
		this.strNoThrSafe = thrName;
		try {
			System.out.println("START thread:"+ Thread.currentThread().getName());	
			Thread.sleep(500);
			
			
			

			System.out.println(""+ Thread.currentThread().getName()+ ", noThrSafeInfo: "+this.strNoThrSafe);
			System.out.println(""+ Thread.currentThread().getName()+ ", thrSafeInfo: "+this.strThrSafe.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
