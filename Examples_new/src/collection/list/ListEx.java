package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> allRows = new ArrayList<String>();
		List<String> partialRows1 = new ArrayList<String>();
		List<String> partialRows2 = new ArrayList<String>();
		
		System.out.println(allRows);
		partialRows1.add("1");
		partialRows1.add("2");
		allRows.addAll(partialRows1);
		System.out.println(allRows);
		
		allRows.addAll(partialRows1);
		System.out.println(allRows);
		
		//partialRows2 = null;
		allRows.addAll(null);
		System.out.println(allRows);
	}

}
