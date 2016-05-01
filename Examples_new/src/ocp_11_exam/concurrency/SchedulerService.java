package ocp_11_exam.concurrency;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class SchedulerService implements Runnable{

	int i =0;
	public static void main(String[] args) {
		
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		final ScheduledFuture<?> sf = scheduler.scheduleAtFixedRate(new SchedulerService(), 1, 2, TimeUnit.SECONDS);
		scheduler.schedule(new Runnable(){
			@Override
			public void run() {
				sf.cancel(true);
				System.out.println("end");
			}
		}, 10, TimeUnit.SECONDS);
	}

	@Override
	public void run() {
		
			 try{
				 int r = 100/i++;
					System.out.println(r);
			 }catch (Exception e){
				 System.out.println("exc");
			 }
			
		}
	
	}
	
	


