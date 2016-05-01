package map;

import java.util.Map;
import java.util.HashMap;

public class BookStore {

	
	Map<Book, Integer> map = new HashMap<Book, Integer>();
	int getNumberOfCopies(Book b){ 
		return map.get(b);
	}
	
	public void addBook(Book b, int numberofcopies){
		
		map.put(b, numberofcopies);
	}
}
