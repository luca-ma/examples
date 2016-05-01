package a;

import java.util.HashMap;


class Color {
static int count = 0;
public int hashCode() {
++count;
return super.hashCode();
}
}


public class Metal {
		public static void main(String args[]) 
{
		HashMap<Color, String> map = new HashMap<>();
		Color c1 = new Color(); Color c2 = new Color();
		map.put(c1, "Red");
		map.put(c2, "Yellow");
		String string = map.get(new Color());
		String string2 = map.get(c1);
		System.out.print(Color.count);

	}
}

