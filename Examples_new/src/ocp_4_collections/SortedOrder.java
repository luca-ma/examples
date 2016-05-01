package ocp_4_collections;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class SortedOrder {
	public static void main(String []args) {
		Set<String> set = new TreeSet<String>();
		set.add("S");
		set.add("R");
		Iterator<String> iter = set.iterator();
		set.add("P");
		set.add("Q");
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	}
}