package ocp_2_advclassdes;

 enum MALE {
	A(1),B(2);
	int i;

	MALE(int i){
		this.i = i;
	}
}
public class Testexa{
	public static void main(String[] args){
		System.out.println(MALE.A);
		System.out.println(MALE.A.i);
	}
}