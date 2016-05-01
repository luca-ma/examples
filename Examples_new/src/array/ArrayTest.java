package array;

public class ArrayTest {

	public static void main(String[] args) {
		
		
		A[] a, a1;
		B[] b;
		
		a = new A[10]; 
		a1= a; 
		b =new B[20]; 
		a = b;
		b = (B[]) a;
		b = (B[]) a1; // 3
		
		
	}

}
