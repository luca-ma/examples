package ocp_11_exam.concurrency.executors.cookbook_ex1;

import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	private Date initDate;
	private String name;
	CountDownLatch latch;
	public Task(String name,CountDownLatch latch){
		this.latch= latch;
		initDate=new Date();
		this.name=name;
		}
	
	@Override
	public void run() {
//		System.out.printf("%s: Task %s: Created on: %s\n",Thread.
//				currentThread().getName(),name,initDate);
		System.out.printf("%s: Task %s: Started on: %s\n",Thread.
				currentThread().getName(),name,new Date());
		System.out.println("");
		try {
			long duration =1000;
			//Thread.sleep(duration);
			//Long duration=(long)(Math.random()*10);
			System.out.printf("%s: Task %s: Doing a task during %d seconds\n",Thread.currentThread().getName(),name,duration);
			TimeUnit.MILLISECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%s: Task %s: Finished on: %s\n",Thread.
				currentThread().getName(),name,new Date());
		System.out.println("");
		
		this.latch.countDown();
		System.out.printf("latch  count:"+ this.latch.getCount());
		System.out.println("");

		

			
		
	}

}
