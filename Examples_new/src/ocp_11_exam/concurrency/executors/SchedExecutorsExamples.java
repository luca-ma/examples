package ocp_11_exam.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class SchedExecutorsExamples {

	public static void main(String[] args) throws InterruptedException {

		//Job job = new Job("baseJob");

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		//long initime = System.currentTimeMillis();
		executor.scheduleAtFixedRate(new Job("scheduledJOB1"), 0,1, TimeUnit.SECONDS);

		//executor.schedule(new Job("oneShJOB"), 0, TimeUnit.SECONDS);
		//long entdime = System.currentTimeMillis();
		
		executor.scheduleAtFixedRate(new Job("scheduledJOB2"), 0,1, TimeUnit.SECONDS);
		//System.out.println("Time: "+(entdime-initime));
		Thread.sleep(5000);
		//executor.shutdown();
	//	executor.
		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Job("scheduledJOB3"), 0,1, TimeUnit.SECONDS);
	}

}
