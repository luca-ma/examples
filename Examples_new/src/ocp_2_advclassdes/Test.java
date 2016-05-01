package ocp_2_advclassdes;

public class Test {
	
	private int i =2;
	private class A {
		void m1 () {
			i =3;
			System.out.print(i);
		}
	}
	
	void m1 () {
		new A().m1();
		System.out.print(i);
	}
	
	public static void main(String[] args){
		Test obj = new Test();
		obj.m1();
	}

}
