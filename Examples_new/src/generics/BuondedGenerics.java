package generics;

import java.util.ArrayList;
import java.util.List;

public class BuondedGenerics {

	public static void main(String[] args) {
		
		//---- NO compile
		//List<?> listGen = new ArrayList<?>(); 
		
		//---- NO ADD OK GET
		List<?> listGen = new ArrayList<>(); 
		List<?> listGen2 = new ArrayList<String>();
		
		//listGen.add(1);
		//listGen2.add("sss");
		
		Object object = listGen.get(0);//ok compile and exec ok
		Object object2 = listGen2.get(0);//ok compile and exec ok
		
		//---- NO ADD , OK GET
		List<? extends Number> listNum = new ArrayList<>(); 
		
		//listNum.add(10);    				//no compile
		Number number = listNum.get(0);		//ok compile
		
		//---- ok ADD , no GET
		List<? super Integer> listInt = new ArrayList<>(); 
				
		listInt.add((Integer) new Object());    				     //no compile
		Object object3 = listInt.get(0);		 //ok compile
				

	}

}
