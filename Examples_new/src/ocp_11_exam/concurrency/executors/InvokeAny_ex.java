package ocp_11_exam.concurrency.executors;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InvokeAny_ex {

	/**
	 * @param args
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//This code example will print out the object returned by one of the Callable's in the given collection. 
		//I have tried running it a few times, and the result changes. 
		//Sometimes it is "Task 1", sometimes "Task 2" etc.
		//http://tutorials.jenkov.com/java-util-concurrent/executorservice.html
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		String result = executorService.invokeAny(callables);

		System.out.println("result = " + result);

		executorService.shutdown();

	}

}
