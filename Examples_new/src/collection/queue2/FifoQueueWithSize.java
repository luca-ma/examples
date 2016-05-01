package collection.queue2;

import java.util.LinkedList;


/**
 * implements a FIFO queue
 * with a MAX size 
 * 
 * when max size has been reached:
 * 
 *   - this.blocked ==  true --> no more insertion are permitted 
 *   - this.blocked ==  false --> put of a new element in queue means that 
 *  first element will be removed
 * @author luca
 *
 * @param <E>
 */
public class FifoQueueWithSize <E> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FifoQueueWithSize<String> fifo = new FifoQueueWithSize<String>(3);
		fifo.put("aaa");
		fifo.put("bbb");
		fifo.put("ccc");
		
		int size = fifo.size();
		
		@SuppressWarnings("unused")
		String peek = fifo.peek();//return aaa and not remove it
		size = fifo.size();
		String el = fifo.get();//return aaa and  remove it
		size = fifo.size();
		
		fifo.put("ddd");
		fifo.put("eee");
		size = fifo.size();
		
	}

	private Integer maxSize;
	private Boolean blocked =false;//if true when max size has been reached no more insertion are permitted 
	
	public FifoQueueWithSize (Integer maxSize){
		this.maxSize = maxSize;
		this.blocked = false;
	}
	public FifoQueueWithSize (Integer maxSize, Boolean blockMaxQueue){
		this.maxSize = maxSize;
		this.blocked = blockMaxQueue;
	}
	
		  private LinkedList<E> list = new LinkedList<E>();

		  /**
		   * Puts object in queue.
		   */
		  public void put(E o) {
			  if (list.size()==(this.maxSize)) {
				  if(this.blocked) {
					  System.out.println("max size reached, can't insert new elements");
					  return;
				  }
				  this.get();
			  }
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

