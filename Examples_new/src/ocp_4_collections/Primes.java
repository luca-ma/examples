package ocp_4_collections;

import java.util.*;
public class Primes {
	public static void main(String[] args) {
		Integer[] primes = {2, 7, 5, 3};
		for(Integer p2: primes){
			System.out.print("" +p2 + " ");
		}
		System.out.println("");
		MySort ms = new MySort();
		Arrays.sort(primes, ms);
		for(Integer p2: primes){
			System.out.print("" +p2 + " ");
		}
			
	}
}

class MySort implements Comparator<Integer>{
	public int compare(Integer x, Integer y) {
		return y.compareTo(x);
	}



}

