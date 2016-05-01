package ocp_11_exam.concurrency.conccollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class concHashMap {

	public static void main(String[] args) {
		
		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
		
		map.putIfAbsent("a", "c");
		map.replace("a", "c", "b");
		map.replace("a", "e");
		System.out.println(map);

	}

}
