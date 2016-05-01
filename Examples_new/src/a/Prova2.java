package a;

class SuperClass {
	SuperClass() {
		foo();
	}
	public void foo(){
		System.out.println("In SuperClass.foo()");
	}
}
class SubClass extends SuperClass {
	public SubClass() {
		member = "HI";
	}
	public void foo() {
		System.out.println("In Derived.foo(): " + member.toLowerCase());
	}
	private String member;
	public static void main(String[] args) {
		SuperClass reference = new SubClass();
		reference.foo();
	}
}

