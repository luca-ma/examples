package ocp_4_collections;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class DequeEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deque<Integer> deque = new ArrayDeque<>();
		List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5);
		deque.addAll(asList);
		System.out.println("The removed element is: " + deque.remove()); // ERROR

	}

}
