package a;

class BaseClass {
	private static void foo() {
		System.out.println("In BaseClass.foo()");
	}
	void bar() {
		System.out.println("In BaseClass.bar()");
	}
	public static void main(String[] args) {
		DerivedClass po = new DerivedClass();
		po.foo(); // BASE_FOO_CALL
		po.bar();
	}
}
class DerivedClass extends BaseClass {
	//@Override
	void foo() {
		System.out.println("In Derived.foo()");
	}
	void bar() {
		System.out.println("In Derived.bar()");
	}
}

