package collection.arrayutil;

import java.util.ArrayList;

public class ArayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		 ArrayList<String> list = new  ArrayList<String>();
		 list.add("AAA"); list.add("BBB");
		 list.add("BBB");
		 
		 String arr [] = new String[4];
		 String arr1 [] = new String[2];
		 System.out.println("---- arr dim 4");
		 String[] arrayN = list.toArray(arr);
		 for(String el: arrayN){
			 System.out.println("el N :"+el);
		 }
		 for(String el: arr){
			 System.out.println("el N :"+el);
		 }
		 
		 System.out.println("---- arr dim 2");
		 String[] arrayN1 = list.toArray(arr1);
		 for(String el: arrayN1){
			 System.out.println("el N :"+el);
		 }
		 for(String el: arr1){
			 System.out.println("el N :"+el);
		 }
		 
		 
		 String str = "ww"; 
		 StringBuilder strB = new StringBuilder(); 
		 Integer [] a = {0,1,2,3};


		 ArrayList<Integer> listI = new  ArrayList<Integer>();
		 listI.add(1); listI.add(1);
		 listI.add(2); listI.add(2);
		 listI.add(3); listI.add(3);
		 
		 for(Integer el: listI){
			 System.out.println("el I :"+el);
		 }
//		 
//		 listI.remove(3);
//		 System.out.println("remove 3 as a int");
//		 for(Integer el: listI){
//			 System.out.println("el I :"+el);
//		 }
//		 
		 listI.remove(new Integer(3));
		 System.out.println("remove 3 as a Integer");
		 for(Integer el: listI){
			 System.out.println("el I :"+el);
		 }
	}

}
