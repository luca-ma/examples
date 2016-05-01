package collection.Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;



public class SetUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<Integer> setEx = new HashSet<Integer>();
		setEx.add(new Integer(1));
		setEx.add(new Integer(2));
		setEx.add(new Integer(2));
		setEx.add(Integer.valueOf("4"));
		  
	
		  System.out.println("listSize pre:"+setEx.size());

		  System.out.println("one is contained:"+setEx.contains(new Integer(1)));
		 System.out.println("one is contained:"+setEx.contains(1));
		 System.out.println("two is contained:"+setEx.contains(new Integer(2)));
		 System.out.println("two is contained:"+setEx.contains(2));
		 System.out.println("three is contained:"+setEx.contains(new Integer(3)));
		 System.out.println("three is contained:"+setEx.contains(3));
		 System.out.println("four is contained:"+setEx.contains(new Integer(4)));
		 System.out.println("four is contained:"+setEx.contains(4));
	}

}
