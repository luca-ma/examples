import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Test{
	public void testRefs(String str, StringBuilder sb){
	    str = str + sb.toString();
	    sb.append(str);
	    str = null;
	    sb = null;
	  }
	  public static void main(String[] args){
		  TreeSet<StringBuilder> treeSetNames = new TreeSet<StringBuilder>();
		//  treeSetNames.add(new StringBuilder("Shreya"));

	  }
}
