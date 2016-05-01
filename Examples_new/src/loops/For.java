package loops;

public class For {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//float loop
		for(double i =0.0; i<10;i++){
			System.out.println(i);
		}
		
		//for loop that end after ;
//		for(double i =0.0; i<10;i++);
//					System.out.println(i);
					
		Integer [] var = new Integer[3];
		Integer el=0;
//		for(el : arr){//el deve essere dichiarato nel loop
//			
//		}
		System.out.println(incFAke(0));

		System.out.println(2%2);
		System.out.println(1%2);
		int [] arr = new int [3];
		System.out.println(varg(1,2,new Integer(1)));
		System.out.println(varg(arr));
	}
	
	public static int incFAke(int val){
		return val++;
	}
	
	public static int varg(int... val){
		return 1;
	}
	

}
