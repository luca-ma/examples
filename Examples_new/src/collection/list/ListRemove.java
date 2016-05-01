package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListRemove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 List<String> myList = new ArrayList<String>();
		  myList.add("1");
		  myList.add("2");
		  myList.add("3");
		  myList.add(new String ("4"));
		  
		  String myStr = new String ("1");
		  String myStr4 = new String ("4");
		  if(myList.contains("1")){
			  System.out.println("Ok1");
		  }
		  if(myList.contains(myStr)){
			  System.out.println("Ok2");
		  }
		  if(myList.contains(myStr4)){
			  System.out.println("Ok3");
		  }
	}

}
