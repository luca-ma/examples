package ocp_11_exam.concurrency.executors;

import java.util.concurrent.*;
	class MyCallable implements Callable<String>{ 
		public String call() throws Exception { 
			Thread.sleep(5000); 
			return "DONE";
		} 
	} 
	class MyRunnable implements Runnable{ 
		public void run()  { 
			try {
				Thread.sleep(5000); 
			}catch (Exception  exc){
				exc.printStackTrace();
			}
			return ;
		} 
	} 
	
	public class ExecutorsExample {
		public static void main(String[] args) throws Exception { 
			ExecutorService es =Executors.newSingleThreadExecutor(); 
			
			//callable example
			Future<String> futureCallable = es.submit(new MyCallable()); 
			//wait until thread finish  and print result     
			System.out.println(futureCallable.get()); 
			
			Future future = es.submit(new MyRunnable()); //wait until thread finish  and NOT  print result     
			
			//System.out.println(future.isDone()); //DOESN't wait until thread finish     
			System.out.println(future.get()); //DOESN't wait until thread finish     
			


			es.shutdownNow(); //2     
			} 
		}
		
	
	

