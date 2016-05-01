package map;

import java.util.HashMap;
import java.util.Map;

public class MapEx {


	public static void main(String[] args) {
		
		Map<String, Integer> mapEx =new HashMap<String, Integer>();
		System.out.println("map val: "+mapEx.get("A"));
		mapEx.put("A", 10);
		System.out.println("map val: "+mapEx.get("A"));
		
		Integer num = mapEx.get("A");
		num=num+10;
		
		System.out.println("map val: "+mapEx.get("A"));

	}

}
