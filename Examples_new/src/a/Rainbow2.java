package a;
import java.util.*;
class Color2 {
	static int count = 0;
	public int hashCode() {
		++count;
		return super.hashCode();
	}
}
public class Rainbow2 {
	public static void main(String args[]) {
		HashMap<Color2, String> map = new HashMap<>();
		Color2 c1 = new Color2(); 
		Color2 c2 = new Color2();
		map.put(c1, "Red");
		map.put(c2, "Yellow");
		String string = map.get(new Color2());
		map.get(c1);
		System.out.print(Color2.count);
	}
}
