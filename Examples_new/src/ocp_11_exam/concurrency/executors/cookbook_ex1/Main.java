package ocp_11_exam.concurrency.executors.cookbook_ex1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

 enum ThreadType {
	CACHED, //nessun limite di numero max threads
	FIXED_SIZE, //numero prestabilito di max di threads
	SINGLE; //un solo thread	
}
 
 

/**
 * esempio di uso di ThreadPoolExecutor
 * 
 * 1) newCachedThreadPool
 * 		--un nuovo thread creato quando occorre
 *    		-- va bene se ho tanti threads che durano poco e nascono in continuazione
 *    		-- non va bene se ho tanti threads che durano molto (non c'èun num max di threads prefissato)
 *    
 *    		-- modificare durata (duration) del task per verificare quanti thread vengono creati
 *    
 *  2) newFixedThreadPool(5)
 * 		-- max cinque threads creati 
 *    		-- va bene per non creare troppi threads
 *    		-- tuning del num max di threads 
 *    
 *  3) newSingleThreadExecutor
 *	    --un solo thread utilizzatos 
 *
 * @author 
 *
 */
public class Main {


	private static ThreadType type = ThreadType.CACHED;
	public static void main(String[] args) throws InterruptedException {
		long iniTime = System.currentTimeMillis();

		Main exec = new Main();

		final CountDownLatch latch = new CountDownLatch(100);

		Server server=new Server(type, latch);
		for (int i=0; i<100; i++){
			//Thread.sleep(100);
			Task task=new Task("Task "+i, latch);
			server.executeTask(task);
		}

		try{
			latch.await();  //main thread is waiting on CountDownLatch to finish
			System.out.println("end");
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Duration: "+ (endTime-iniTime)/1000);

		server.endServer();

	}

	
}




