package ocp_6_exam.collection;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PrioQueueExa {

	public static void main(String[] args) {
		
	 //   Comparator<String> comparator = new StringLengthComparator();
        PriorityQueue<String> queue = 
            new PriorityQueue<String>();
        
        ArrayDeque<String> queuesimple = 
                new ArrayDeque<String>();
        queue.add("short");
        queue.add("very long indeed");
        queue.add("medium");
        queuesimple.add("short");
        queuesimple.add("very long indeed");
        queuesimple.add("medium");
        while (queue.size() != 0)
        {
            System.out.println(queue.remove());
          
        }
        while (queuesimple.size() != 0)
        {
            System.out.println(queuesimple.remove());
        }
		

	}

}
