package map;

import java.util.HashMap;

public class MapExample {

	static BookStore bs = new BookStore();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
//		HashMap<String, Float> myMap = new HashMap<String, Float>();
//		myMap.put(new String("aaa"), 1.0F);
//		myMap.put("bbb", 2.0F);
//		myMap.put("ccc", 3.0F);
//
//		if (myMap.containsKey(new String("aaa"))) {
//			System.out.println("found");
//		} else {
//			System.out.println("NOT found");
//		}
		
		Book b = new Book(); 
		b.setIsbn("111"); 
		bs.addBook(b, 10); 
		System.out.println(bs.getNumberOfCopies(b));
		b = new Book(); 
		b.setIsbn("111");
		System.out.println(bs.getNumberOfCopies(b));
		
	}

}
