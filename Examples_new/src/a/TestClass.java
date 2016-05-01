package a;

private class TC extends java.util.Hashtable {
	public TC(){ 
		super(100); 
		System.out.println("TC created");    
	} 
} 

public class TestClass extends TC { 
	public TestClass()
	{ 
		System.out.println("TestClass created");} 
	public static void main(String[] args){ new TestClass(); }; }