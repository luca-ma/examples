package jbb_alg_exam.sorting_algs;

public class SortingAlgs {

	static int[] unOrderedArray = { 1000, 900, 800, 700, 600, 500,400, 300, 200, 100};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 printElem(unOrderedArray);
		 SortingAlgs.bubbleSort(unOrderedArray);
		 printElem(unOrderedArray);
	}
	
	/**
	 * http://en.wikipedia.org/wiki/Sorting_algorithm
	 * Bubble sort is a simple sorting algorithm. 
	 * The algorithm starts at the beginning of the data set. 
	 * It compares the first two elements, and if the first is greater than 
	 * the second, it swaps them. 
	 * It continues doing this for each pair of adjacent elements to the end of the data set. It then starts again with the first two elements, repeating until no swaps have occurred on the last pass. 
	 * This algorithm's average and worst case performance is O(n2)
	 * @param nums
	 * @return
	 
	//Sorts an integer array in ascending order.  
	Parameters:  
	   data - reference to the integer array to sort, must not be null  
	Postcondition:  
	   The array is sorted in ascending order.  
	 
	 * @param nums
	 * @return
	 */
	static int[] bubbleSort(int[] nums)  
	{  
	   int iterNums =0;
	   boolean unsorted = true;  
	   while (unsorted){  
	      unsorted = false;  
	      for (int i = nums.length - 1; i > 0; i--)  
	      {  
	    	  iterNums++;
	         if (nums[i] < nums[i-1])  
	         {  
	            int temp = nums[i];  
	            nums[i] = nums[i-1];  
	            nums[i-1] = temp;  
	            unsorted = true;  
	         }  
	      }  
	   }  
	   System.out.println("bubbleSort num of iterations:"+iterNums);
	   return nums;  
	}  
	
	public static void printElem (int[] nums) {
		System.out.println("===========");
		for(Integer number:nums) {
			System.out.println(number);
		}
		System.out.println("===========");
	}

}
