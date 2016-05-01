package ocabook.cap1.a;

import ocabook.cap1.b.B;

public class A extends B{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		A b = new A();
		b.exec();
		// TODO Auto-generated method stub
		double div = 2/0.0;
	//	int div2 =1/0;
	}

	public void print(){
		
		System.out.println("IN A");
	}
}
