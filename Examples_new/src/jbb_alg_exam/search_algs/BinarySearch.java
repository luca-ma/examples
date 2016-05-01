package jbb_alg_exam.search_algs;

import java.util.List;

public class BinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * This binary search works fine, taking the lower half (roughly) of the List if p &lt; the middle element, and taking the upper half if p&gt; the middle element.  The base case is when only one element is left in the list.

As stated before, this implementation requires the list to be sorted and to contain at least one element.
	 */
	
	public static boolean f(Integer p, List<Integer> l)
	 {
	     if(l.size() == 1)
	     {
	         return p.equals(l.get(0));
	     }
	     int mid = l.size()/2;
	     if(p < l.get(mid))
	     {
	         return f(p, l.subList(0, mid));
	     }
	     if(p > l.get(mid))
	    {
	         return f(p, l.subList(mid, l.size()));
	     }
	     return true;
	 }

}
