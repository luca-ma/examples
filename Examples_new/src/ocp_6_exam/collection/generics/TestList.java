package ocp_6_exam.collection.generics;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		
		List<Integer> l1 = new ArrayList<>();
		l1.add(1);
		
		List l2 = l1;
		l2.add("hello");
		
		List<Integer>l3 = l2;
		l3.add(10);
		//l3.add("ss");
		
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		
	}

}
