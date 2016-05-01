package enumUt;

public enum Coffee

{

	ESPRESSO("Very Strong"),
	MOCHA, 
	LATTE; //2  

public String strength; //3    

private Coffee() {
}

Coffee(String strength) //4  
{
this.strength = strength; //5    
} 
}
