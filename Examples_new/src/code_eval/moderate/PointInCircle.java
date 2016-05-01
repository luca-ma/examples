package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PointInCircle {


	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}

			String[] tokens = line.split(";");
			Point center = buildPoint(tokens[0]);
			Point point = buildPoint(tokens[2]);
			String[] split = tokens[1].split(":");
			Double raggio = Double.valueOf(split[1]);
			if (distance(center, point)<=raggio){
				System.out.println("true");
			}else {
				System.out.println("false");
			}
		}

	}



	public static Double distance (Point pt1, Point pt2){
		
		double xdist = Math.pow(pt1.getAsc()-pt2.getAsc(),2);
		double ydist = Math.pow(pt1.getOrd()-pt2.getOrd(),2);
		return (Math.sqrt(xdist+ydist));
	}
	
	public static Point buildPoint (String ptStr){
		String[] split = ptStr.split(":");
		String substring = split[1].substring(2, split[1].length()-1);
		String[] nums = substring.split(",");
		PointInCircle pointInCircle = new PointInCircle();
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
