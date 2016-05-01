package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;



public class ListUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<String> treeSet = new java.util.TreeSet<String>();
		treeSet.add("1");
		treeSet.add("2");
		treeSet.add("2");
		treeSet.add(new String ("4"));
		  
	
		  System.out.println("listSize pre:"+treeSet.size());
		 String one  ="1";String two  ="2";
		 System.out.println("one is contained:"+treeSet.contains(one));
		 System.out.println("two is contained:"+treeSet.contains(two));
		 
		 
		 TreeSet<Integer> treeSet2 = new java.util.TreeSet<Integer>();
		 treeSet.add("1");
			treeSet.add("2");
			treeSet.add("2");
			treeSet.add(new String ("4"));
	}

}
