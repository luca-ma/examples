package collection.arrayutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

	
	 static String prova1 = "AAAA";
	 static String prova2 = "BBBB";
	 public static void main(String[] args) {
		 
		 ArrayList<String> list = new  ArrayList<String>();
		 list.add("AAA"); list.add("BBB");
		 
		 Boolean res1 = list.contains(prova1);
		 Boolean res2 = list.contains(prova1);
		 
		 Boolean res3 = list.contains("AAAA");
		 Boolean res4 = list.contains("BBBB");
		 
		 
		 list.clear();
		 list.add(prova1); list.add(prova1);
		 
		 res1 = list.contains(prova1);
		 res2 = list.contains(prova1);
		 
		 res3 = list.contains("AAAA");
		 res4 = list.contains("BBBB");
		 
		 List<Integer> numbers = new ArrayList<Integer>(
			        Arrays.asList(5,3,1,2,9,5,0,7)
			    );

		 int size = 3;
		 int idx=0;
		 boolean end =false;
		 while(!end) {
			 if(idx+size<numbers.size()) {
				 List<Integer> subList = numbers.subList(idx, idx+size);
				 idx+=size;
			 }else {
				 List<Integer> subList = numbers.subList(idx, numbers.size());
				 break;
			 }
			

		}
		 
	 }
}
