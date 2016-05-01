package ocp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestABC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		
		///List<Number> list = new ArrayList<Integer>();ko
		
		//ArrayList<Number> list = new ArrayList<Integer>();ko
		
		List<?> list = new ArrayList<Integer>(); //OK
		List<? extends Number> list2 = new ArrayList<Integer>(); //OK
		List<? super Number> list3 = new ArrayList<>();

		ArrayList<? extends Number> list4 = new ArrayList<Integer>();

		
		Arrays.asList(arg0)t(arg0)



	}

}
