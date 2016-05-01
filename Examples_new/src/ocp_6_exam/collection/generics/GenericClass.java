package ocp_6_exam.collection.generics;

import java.util.ArrayList;

public class GenericClass<X,Y extends X> {
	
	
	public static void main(String[] args){
		GenericClass<A,A> a = new GenericClass<>();
		ArrayList<Object> arrayList = new ArrayList<>();
	}

}
