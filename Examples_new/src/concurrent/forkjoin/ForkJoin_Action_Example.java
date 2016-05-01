package concurrent.forkjoin;

import java.util.ArrayList; 
import java.util.Arrays; 
import java.util.concurrent.ForkJoinPool; 
import java.util.concurrent.RecursiveAction; 

public class ForkJoin_Action_Example extends RecursiveAction{ 
	
	int[] ia; int from; int to; 
	public ForkJoin_Action_Example(int[] ia, int from, int to){ 
		this.ia = ia; 
		this.from = from; 
		this.to = to;
	} 
	@Override
	protected void compute() { 
		if(from == to){ //Update the value using logic implemented somewhere else.             
			ia[from] = utilityMethod(ia[from]); 
		}else{
			int mid = (from+to)/2; 
			ForkJoin_Action_Example newtask1 = new ForkJoin_Action_Example(ia, from, mid); 
			ForkJoin_Action_Example newtask2 = new ForkJoin_Action_Example(ia, mid+1, to); 
			newtask2.fork(); 
			newtask1.compute();
			newtask2.join();
			}
		}
	
	public static void main(String[] args) { 
		int ia[] = new int[]{ 1, 2, 3, 4 , 5, 6, 7};
		ForkJoinPool fjp = new ForkJoinPool(); 
		ForkJoin_Action_Example st = new ForkJoin_Action_Example(ia, 0, 6); 
		fjp.submit(arg,);
		invoke(st); 
		System.out.print("New Array Values = "); 
		for(int i : ia) System.out.print(i+" ");		
	}  

		public static int utilityMethod(int x) { 
			return x+1;
		}
	
	
}
