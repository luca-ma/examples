package collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class ExOrdMap {

	/**
	 * HashMap isn't an ordered map
	 * LinkedHashMap is ordered!!!
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		HashMap<String, String> unOrdMap = new HashMap<String, String>();
		LinkedHashMap<String, String> ordMap = new LinkedHashMap<String, String>();
		
		unOrdMap.put("111", "primoIns");
		unOrdMap.put("333", "secondoIns");
		unOrdMap.put("222", "terzoIns");
		
		ordMap.put("111", "primoIns");
		ordMap.put("333", "secondoIns");
		ordMap.put("222", "terzoIns");
		
		for(String key:unOrdMap.keySet()) {
			System.out.println(key);
		}
		//print keys in casual order!! i.e. 222, 111, 333
		
		for(String key:ordMap.keySet()) {
			System.out.println(key);
		}
		//print keys in order of insertion!! i.e.111, 333,222
		
		for(String key:ordMap.keySet()) {
			System.out.println(key);
		}
		
		//If want to iterate linked list in revers order, I've to:
		//-- convert key in a list
		//-- revert list 
		//iterate on the list
		List<String> list = new ArrayList<String>(ordMap.keySet());
		System.out.println("arraylist");
		for(String key:list) {
			System.out.println(key);
		}
		System.out.println("arraylist reverse ");
		Collections.reverse(list);
				for(String key:list) {
			System.out.println(key);
			System.out.println(ordMap.get(key));
		}
	}

}
