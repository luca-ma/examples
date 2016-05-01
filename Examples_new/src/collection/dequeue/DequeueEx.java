package collection.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Deque<String> dequeInst = new ArrayDeque<>();

		// DEQUE as a Stack (LIFO queue)
		// Push --> addFirst
		// Pop --> removeFirst or pop
		// Peek (read an not remove) --> peek
		System.out.println(dequeInst.size());

		dequeInst.push("q");
		dequeInst.offerFirst("q");
		dequeInst.addFirst("a");
		System.out.println(dequeInst);

		dequeInst.addFirst("b");
		System.out.println(dequeInst);

		String peek = dequeInst.peek();
		System.out.println(peek);
		System.out.println(dequeInst.getFirst());
		System.out.println(dequeInst.element());

		System.out.println(dequeInst);
		
		System.out.println(dequeInst.pop());
		System.out.println(dequeInst);
		
		
		// DEQUE as a QUEUE (FIFO queue)
		// add, offer --> add a the end of Queue
		// remove, removeFirst --> remove at start of Queue
		// Peek, o (read an not remove) --> peek
		Deque<Integer> fifo = new ArrayDeque<>();
		System.out.println(fifo.size());
		fifo.add(1);
		fifo.addLast(2);
		fifo.offer(3);
		fifo.offerLast(4);
		System.out.println(fifo);
		fifo.remove();
		fifo.removeFirst();
		System.out.println(fifo);
		fifo.peek();

		System.out.println(fifo);
		
	}

}
