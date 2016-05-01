package ocp_6_exam.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEx {

	public static void main(String[] args) {

		
		Map<String,List<String>> map = new HashMap<>();

		List<String> list = null;
		ArrayList<String> arL = new ArrayList<String>();
		list= arL;
		
		map.put("a", list);
		map.put("a", arL);
	}

}
