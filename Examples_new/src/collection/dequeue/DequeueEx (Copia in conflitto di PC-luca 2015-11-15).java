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
	}

}
