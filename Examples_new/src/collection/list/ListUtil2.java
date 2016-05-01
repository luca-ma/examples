package collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ListUtil2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 List<String> myList = new ArrayList<String>();
		  myList.add("1");
		  myList.add("2");
		  myList.add("3");
		  myList.add(new String ("4"));
		  
		 //remove che non funziona
//		  for(String listEL:myList) {
//			  if(listEL.equals("1")) {
//				  myList.remove(listEL); //java.util.ConcurrentModificationException
//			  }
//		  }
		  System.out.println("listSize pre:"+myList.size());
		  Iterator<String> iter = myList.iterator();
		  while(iter.hasNext()) {
			  String listElem = iter.next();
			  if(listElem.equals("1")) {
				  iter.remove();
				//  break;//se ne devi rimuovere solouno
			}
			  
		  }
		  
		  System.out.println("listSize post:"+myList.size());
	}

}
