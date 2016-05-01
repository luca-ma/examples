package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;

public class Distance {


	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}

			//String[] tokens = line.split(")");
			String str1 = line.substring(1, line.indexOf(")"));
			Point center = buildPoint(str1);
			Point point = buildPoint(line.substring(line.lastIndexOf("(")+1,line.length()-1));
			NumberFormat nf = NumberFormat.getInstance();  
		    nf.setMaximumFractionDigits(0);// set as you need  
		    String myString = nf.format(distance(center, point));  
		   // System.out.println("string : " + myString);  
			System.out.println(myString);
			
		}

	}



	public static Double distance (Point pt1, Point pt2){
		
		double xdist = Math.pow(pt1.getAsc()-pt2.getAsc(),2);
		double ydist = Math.pow(pt1.getOrd()-pt2.getOrd(),2);
		return (Math.sqrt(xdist+ydist));
	}
	
	public static Point buildPoint (String ptStr){
		//String[] split = ptStr.split(":");
	//	String substring = ptStr.substring(2, ptStr.length()-1);
		String[] nums = ptStr.split(",");
		Distance pointInCircle = new Distance();
		return pointInCircle. new Point(Double.valueOf(nums[0]),Double.valueOf(nums[1]));
	}
	public class Point {
		Double asc;
		public Point(Double asc, Double ord) {
			super();
			this.asc = asc;
			this.ord = ord;
		}
		public Double getAsc() {
			return asc;
		}
		public void setAsc(Double asc) {
			this.asc = asc;
		}
		public Double getOrd() {
			return ord;
		}
		public void setOrd(Double ord) {
			this.ord = ord;
		}
		Double ord;
	}
}
