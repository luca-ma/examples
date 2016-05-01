package ocp_exam.threads_cap10;

class ThreadEx {
	public static void main(String args[]) throws InterruptedException {
		Thread sing = new Sing();
		//Thread newThread = new Thread(sing);
		sing.start();
		//Thread.sleep(1000);
		sing.interrupt();
		System.out.println("sing interrupted");
	}
}
class Sing extends Thread{
	public void run() {
		while (!this.isInterrupted()){
			System.out.println("Singing");
			//Thread.currentThread();
			//Thread.sleep(1000);
			System.out.println("is interr:"+isInterrupted());
		}
	
	}
}