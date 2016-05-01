package collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class ListOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet<String> treeSet = new java.util.TreeSet<String>();
		treeSet.add("0811111124");
		treeSet.add("0811111122");
		treeSet.add("0811111123");
		
		
		for(String num :treeSet) {
			System.out.println("num:"+num);
		}
		
		List<String> numbers = new ArrayList<String>();
				numbers.add("0811111124");
				numbers.add("0811111122");
				numbers.add("0811111123");
		
		
		for(String num :numbers) {
			System.out.println("num:"+num);
		}

		Collections.sort(numbers);
		for(String num :numbers) {
			System.out.println("num:"+num);
		}
	}

}
