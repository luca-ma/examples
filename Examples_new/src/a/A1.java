package a;

import java.util.HashMap;
import java.util.Map;

class Book { 
	
	private String title, isbn; 
	public boolean equals(Object o){
		return (o instanceof Book && ((Book)o).isbn.equals(this.isbn));
	}  // ... setters and getters for title and isbn 
	public void setIsbn(String string) {
		// TODO Auto-generated method stub
		
	}
}  

class BookStore {
	Map<Book, Integer> map = new HashMap<Book, Integer>();
	Integer getNumberOfCopies(Book b){ 
		Integer integer = map.get(b);
	return integer;
	} 
	public void addBook(Book b, int numberofcopies){
		map.put(b, numberofcopies);
		} // ... other useful methods. 
	}  
public class A1 {
	static BookStore bs = new BookStore(); 
	
	public static void main(String[] args){
		Book b = new Book(); b.setIsbn("111"); 
		bs.addBook(b, 10); 
		System.out.println(bs.getNumberOfCopies(b)); 
		b = new Book(); b.setIsbn("111"); 
		Integer numberOfCopies = bs.getNumberOfCopies(b);
		System.out.println(bs.getNumberOfCopies(b));
		
		Map<Integer,Integer> map = new HashMap<>();
		map.put(1, 2);
		System.out.println(map.get(2));
		 }
}