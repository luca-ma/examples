package ocp_11_exam.concurrency.executors.cookbook_ex1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

	private ThreadPoolExecutor executor;
	private ExecutorService singleExecutor;
	private ThreadType type; 

	CountDownLatch latch;
	
	public Server(ThreadType type, CountDownLatch latch){
		this.latch = latch;
		this.type = type;
		if(type==ThreadType.SINGLE){
			singleExecutor = Executors.newSingleThreadExecutor();
		}else {
			executor = poolExecutorFactory(type);
		}	
	}
	
	public void executeTask(Task task){
		if(type==ThreadType.SINGLE){
			singleExecutor.execute(task); 
		}else{
			executeTaskInPool(task);
		}
	}

	
	public void executeTaskInPool(Task task){
		//System.out.printf("Server: A new task has arrived\n");
		executor.execute(task);

//		System.out.printf("Server: Pool Size: %d\n",executor.
//				getPoolSize());
//		System.out.printf("Server: Active Count: %d\n",executor.
//				getActiveCount());
//		System.out.printf("Server: Completed Tasks: %d\n",executor.
//				getCompletedTaskCount());
		
		
		
		
	}

	public void endServer() {
		if (executor!=null)
			executor.shutdown();
		if (singleExecutor!=null)
			singleExecutor.shutdown();
	}

	private ThreadPoolExecutor poolExecutorFactory (ThreadType type){
		switch(type){
		case FIXED_SIZE:
			System.out.println ("create a fixed size Executor");
			executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(5);
			break;
		case CACHED:
			System.out.println ("create a cached Executor");
			executor=(ThreadPoolExecutor)Executors.newCachedThreadPool();
			break;
		default:
			System.out.println ("NOT FOUND Executor");
			break;
		}
		return executor;
	}

}
