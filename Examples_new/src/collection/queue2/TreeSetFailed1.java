package collection.queue2;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetFailed1 {

	
	public static void main(String[] args) {
		//use generics in co
		Set s = new TreeSet();
		
		s.add("prova");
		s.add(new Integer (1));//ClassCAstException raised runtime cause String cannot compared to String!!!!
		
		Set<String> s2 = new TreeSet<String>();
		s2.add("prova");
		//s2.add(new Integer (1));//doesn't compile
	}
}
