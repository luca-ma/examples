package a;

class AA {
 static int age() {return 10;}
}
interface BB {
int age();
}
public class CC extends AA implements BB {

public int age(){
	return 1 ;
}
}
