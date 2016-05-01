package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.TreeSet;


public class FindASquare2 {

	public static ArrayList<Point> points = new  ArrayList<Point>();
	
	public static void main(String[] args) throws IOException {

		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				Boolean square = false;
				
				String[] couples = line.split(", ");
				points.clear();
				System.out.println(line);
				
				for(int idx =0; idx < couples.length; idx++) {
					//System.out.println(couples[idx]);
					String nums = couples[idx].substring(1,couples[idx].length()-1);
					//System.out.println(nums);
					String[] numCouple = nums.split(",");
					Integer asc = Integer.valueOf(numCouple[0]);
					Integer ord = Integer.valueOf(numCouple[1]);
					FindASquare2 inst = new FindASquare2();
					Point pt =  inst.new Point(asc, ord);
					points.add(pt);
					
				}
				
				Double dist_prec  =0.0;
				square = true;
				for(int idx=1;idx<points.size();idx++){
					
					Double pt_dist = pt_dist(points.get(idx-1),points.get(idx));
					if(idx==1){
						dist_prec =pt_dist;
					}else {
						if(dist_prec.equals(pt_dist)){
							dist_prec =pt_dist;
						}else {
							square = false;
							break;
						}
					}
					checkAng(points.get(idx-1),points.get(idx));
				}
				
						
				System.out.println(square);;


			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
			
			

		}
	}
	

   private static void checkAng(Point point, Point point2) {
		// TODO Auto-generated method stub
		
	}


private static Double pt_dist(Point point, Point point2) {
		double tmp1 = Math.pow(point.getAsc()-point2.getAsc(),2);
		double tmp2 = Math.pow(point.getOrd()-point2.getOrd(),2);
		return (Math.sqrt(tmp1+tmp2));
	}


public class Point {
	   Integer asc =0;
	   Integer ord =0;
	public Integer getAsc() {
		return asc;
	}
	public void setAsc(Integer asc) {
		this.asc = asc;
	}
	public Integer getOrd() {
		return ord;
	}
	public void setOrd(Integer ord) {
		this.ord = ord;
	}
	public Point(Integer asc, Integer ord) {
		super();
		this.asc = asc;
		this.ord = ord;
	}
	   
   }
	
}
