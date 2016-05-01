package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class OverlappRect {

	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				
				String[] split = line.split(",");
				OverlappRect ov = new OverlappRect();
				Rect rect1 = ov.new Rect(Integer.valueOf(split[0]), Integer.valueOf(split[3]), Integer.valueOf(split[2]), Integer.valueOf(split[1]));
				Rect rect2 = ov.new Rect(Integer.valueOf(split[4]), Integer.valueOf(split[7]), Integer.valueOf(split[6]), Integer.valueOf(split[5]));
				boolean overlapp = rect1.Intersect(rect2);
				if(overlapp)
					System.out.println("True");
				else 
					System.out.println("False");
			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
	}
	
	public class Rect {
	    public int minX;
	    public int minY;
	    public int maxX;
	    public int maxY;

	    public Rect() {}

	    public Rect(int x, int y, int w, int h) {
	        this.minX = x;
	        this.minY = y;
	        this.maxX = w;
	        this.maxY = h;
	    }

	    public boolean Intersect(Rect r) {
	        return this.maxX >= r.minX &&
	               this.minX <= r.maxX &&
	               this.maxY >= r.minY &&
	               this.minY <= r.maxY;              
	    }
	}
}