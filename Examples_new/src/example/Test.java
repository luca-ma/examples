package example;

import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<A> listEx = new ArrayList<A>();
		listEx.add(new A());
		listEx.add(new B());
		
		System.out.println(1+2<3+5);
		ArrayList<Integer> listM = new ArrayList<Integer>();
		listM.add(1);listM.add(2);listM.add(3);
		 for(Integer month : listM){
			 String monthString="";
			 switch (month) {
	            case 1:  monthString = "January";
	                     continue;
	            case 2:  monthString = "February";
	                     break;
	            case 3:  monthString = "March";
	                     break;
	                     
	        }
			 System.out.println(monthString);
		 }
	       
		
	}

}
