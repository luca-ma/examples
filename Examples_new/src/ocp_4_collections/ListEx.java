package ocp_4_collections;

import java.util.ArrayList;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(30);
		list.add(23);
		list.add(1,0);

		List<Integer> list2 = new ArrayList<>(list);
		list2.addAll(list);
		list2.add(4,9);
		
		List<Integer> list3 = list2.subList(2, 5);
		list3.clear();
		System.out.println(list2);
		
	}

}
