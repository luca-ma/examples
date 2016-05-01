package ocp_exam.threads_cap10;

class InterruptThr {
	public static void main(String args[]) {
		Thread sing = new Sing();
		Thread newThread = new Thread(sing);
		newThread.start();
	}
}
class Sing extends Thread{
	public void run() {
		System.out.println("Singing");
	}
}