package collection.map;

import java.util.HashMap;

public class MapsExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HashMap<MapKey,String> exMap1 = new HashMap<MapKey,String>();

		exMap1.put(new MapKey("luca"), "lucama");
		exMap1.put(new MapKey("alba"), "alba1");
		exMap1.put(new MapKey("tigre"), "tiger");
		System.out.println("keys: "+exMap1.keySet().size());
		String string = exMap1.get(new MapKey("luca"));
	}

}
