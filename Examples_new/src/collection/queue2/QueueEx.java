package collection.queue2;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> q = new PriorityQueue<>();
		LinkedList<Integer>l = new LinkedList<>();
		
		q.add(2);
		q.add(33);
		
		l.offerFirst(2);
		l.offerFirst(3);
		System.out.println(q); //NO FIFO, but priority using natural order
		System.out.println(q.peek());
		System.out.println(l); // FIFO, 
		
		System.out.println(l.peek());
		
		
		
	}

}
