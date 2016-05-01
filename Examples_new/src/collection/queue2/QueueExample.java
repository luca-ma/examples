package collection.queue2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		queue.offer("A");
		queue.offer("B");
		System.out.println(queue.peek());
		System.out.println(queue.remove());

	}

}
