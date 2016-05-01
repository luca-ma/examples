package enumUt;



enum MyEnum {AA,BB};
public class TestEnums {

	final Integer val;

	TestEnums(MyEnum enumVal) {

		switch (enumVal) {
		case AA :		
			val =0;
			//break;
		case BB : 		
			val =1;
			break;
		default: 
			val =0;
		}
	}
	
	

}
