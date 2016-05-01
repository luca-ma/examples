package generics;

public class Generics {

	public static void main(String[] args) {
		

	}
	
	//OK generic class
	class MyClass1 <T, A, B> {/*use only T and B*/}
	
	//OK Oracle *recommends* usage of single uppercase letter for type
	//parameters. However using any other variable names-camelCase or ALL_CAPS-will allow the
	//code to compile
	class MyClass4 <Var1, Var2> {/*..*/}
	
	//KO ? invalid type parameter!!
	//class MyClass5 <?> {/*..*/}
	
	//OK T is defined cause is a Number
	class MyClass6 <T extends Number> {/*..*/}
	
	//KO T is NOT defined 
	//class MyClass7 <T super Integer> {/*..*/}

}
