package concurrent.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;  

public class ForkJoin_Task_Ex extends RecursiveTask<Integer>{
	
	int[] ia; int from; int to;
	static final int THRESHOLD = 3;
	public ForkJoin_Task_Ex(int[] ia, int from, int to){
		this.ia = ia; 
		this.from = from; 
		this.to = to;
	}
	
	public int transform(int t){//this can be a CPU intensive operation that 
								//transforms t and returns the value       
								//For now, just return t         
		return t;
	} 
	
	protected Integer compute() { 
		int sum = 0;
		if(from + THRESHOLD > to){
			for(int i = from; i<=to; i++){
				sum = sum+transform(ia[i]);
			}
		} else{ 
			int mid = (from+to)/2; 
			ForkJoin_Task_Ex newtask1 = new ForkJoin_Task_Ex(ia, from, mid); 
			ForkJoin_Task_Ex newtask2 = new ForkJoin_Task_Ex(ia, mid+1, to); 
			newtask2.fork(); 
			sum = newtask1.compute()+newtask2.join(); 
			} 
		return sum;
	} 
	public static void main(String[] args) {
		int ia[] = new int[]{ 1, 2, 3, 4 , 5, 6, 7};
		ForkJoinPool fjp = new ForkJoinPool(); 
		ForkJoin_Task_Ex st = new ForkJoin_Task_Ex(ia, 0, 6);  
		int sum = fjp.invoke(st); 
		System.out.println("sum = "+sum);
	}
	
}