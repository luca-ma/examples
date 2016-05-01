package test;

class Test extends A{
	class Base {}
	class DeriOne extends Base {}
	class DeriTwo extends Base {}

	public static int m1(int i){
		return i*3;
	}
 
	void probe(Long x) { System.out.println("In LONG"); } //4     

	//class ArrayStore {


	
		
		
		public void print(Integer i){
			System.out.println("Integer");
			}
			public void print(int i){
			System.out.println("int");
			}
//			public void print(long i){
//			System.out.println("long");
//			}
			public static void main(String args[]) {
			Test test = new Test();
			test.print(10);
			}


	


	//}		

	

}
