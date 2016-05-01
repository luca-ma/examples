package ocp_11_exam.concurrency;

import java.util.concurrent.*;
import java.util.*;

public class Hotel implements Executor {
	
	final Queue<Runnable> custQueue = new ArrayDeque<>();
	public void execute(Runnable r) {
		synchronized(custQueue) {
			custQueue.offer(r);
		}
		processEarliestOrder();
	}
	private void processEarliestOrder() {
		synchronized(custQueue) {
			Runnable task = custQueue.poll();
			task.run();
		}
	}
	public static void main(String args[]) {
		Hotel hotel = new Hotel();
		hotel.execute(new Order("tea"));
		hotel.execute(new Order("coffee"));
		hotel.execute(new Order("burger"));
	}
}
