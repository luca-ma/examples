package collection.queue2.priority;

import java.util.Comparator;
import java.util.PriorityQueue;

/** 
 * implements a priority queue of String
 * priority is based on String len
 * 
 * 
 * @author luca
 *
 */
public class PrioQueue {


	    public static void main(String[] args)
	    {
	        Comparator<String> comparator = (new PrioQueue()).new StringLengthComparator();
	        PriorityQueue<String> prio_queue = 
	            new PriorityQueue<String>(10, comparator);
	        prio_queue.add("short");
	        prio_queue.add("very long indeed");
	        prio_queue.add("medium");
	        while (prio_queue.size() != 0)
	        {
	            System.out.println(prio_queue.remove());
	        }
	    }
	

	

	class StringLengthComparator implements Comparator<String>
	{
	    @Override
	    public int compare(String x, String y)
	    {
	        // Assume neither string is null. Real code should
	        // probably be more robust
	        if (x.length() < y.length())
	        {
	            return -1;
	        }
	        if (x.length() > y.length())
	        {
	            return 1;
	        }
	        return 0;
	    }
	}

}
