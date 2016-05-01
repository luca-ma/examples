package collection.queue2;

import java.util.LinkedList;


/**
 * implements a FIFO queue
 * @author luca
 *
 * @param <E>
 */
public class FifoQueue <E> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FifoQueue<String> fifo = new FifoQueue<String>();
		fifo.put("aaa");
		fifo.put("bbb");
		fifo.put("ccc");
		
		int size = fifo.size();
		
		String peek = fifo.peek();//return aaa and not remove it
		size = fifo.size();
		String el = fifo.get();//return aaa and  remove it
		size = fifo.size();
	}

	
	
		  private LinkedList<E> list = new LinkedList<E>();

		  /**
		   * Puts object in queue.
		   */
		  public void put(E o) {
		    list.addLast(o);
		  }

		  /**
		   * Returns an element (object) from queue.
		   *
		   * @return element from queue or <code>null</code> if queue is empty
		   */
		  public E get() {
		    if (list.isEmpty()) {
		      return null;
		    }
		    return list.removeFirst();
		  }

		  /**
		   * Returns all elements from the queue and clears it.
		   */
		  public Object[] getAll() {
		    Object[] res = new Object[list.size()];
		    for (int i = 0; i < res.length; i++) {
		      res[i] = list.get(i);
		    }
		    list.clear();
		    return res;
		  }


		  /**
		   * Peeks an element in the queue. Returned elements is not removed from the queue.
		   */
		  public E peek() {
		    return list.getFirst();
		  }

		  /**
		   * Returns <code>true</code> if queue is empty, otherwise <code>false</code>
		   */
		  public boolean isEmpty() {
		    return list.isEmpty();
		  }

		  /**
		   * Returns queue size.
		   */
		  public int size() {
		    return list.size();
		  }
}

