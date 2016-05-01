package ocp_11_exam.concurrency;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.*;

public class ConcMapExample  extends Thread{
	static private ConcurrentHashMap<Integer, String> map;
	
	public static void main(String[] args) {
		ConcMapExample concMapExample = new ConcMapExample();//new ConcMapExample();
		concMapExample.start();
		ConcMapExample concMapExample2 = new ConcMapExample();
		concMapExample2.start();
	}
	ConcMapExample() {
		//INSERT CODE HERE
		map = new ConcurrentHashMap<Integer, String>();
		map.put(1, "red");
		map.put(2, "blue");
		map.put(3, "yellow");
	}
	public void iterate() {
		Iterator iter = map.keySet().iterator();
		while(iter.hasNext()) {
			Integer key = (Integer)iter.next();
			String val = (String)map.get(key);
			System.out.println(key + "-" + val);
			add(4, "green");
		}
	}
	public void add(Integer i, String v){
		map.replace(i, v);
	}
	public void run() {
		iterate();
	}
}

