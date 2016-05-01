package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListGenerics {

	public static void main(String[] args, Object gitfs) {
		
		List<B> books = new ArrayList<>();
		books.add(new B());
		List anotherList = books;

		//OK
		//List<A> gifts = anotherList;
		//gifts.add(new B1());
		
		//KO ? extends A --> unk type,  NO add
		//List<? extends A> gifts = anotherList;
		//gifts.add(new A());
		
		//OK ? super A --> ok ADD  
		List<? super A> gifts = anotherList;
		gifts.add(new B1());
		
		//KO ?  --> unk type,  NO add
		//List<?> gifts = anotherList;
		//gifts.add(new Phone());
		
//		for(B book:gifts){
//			
//		}
	}

}
