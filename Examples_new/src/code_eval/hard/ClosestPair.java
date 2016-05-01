package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ClosestPair {


    public static StringBuilder spr = null;
   
    public static ArrayList<ClosestPair.Point> points = new ArrayList<Point>();
    public static ArrayList<Integer> nums_points = new ArrayList<Integer>();
    
    public static Integer max_min_distance  = 10000;
    public static Double min_dist = (double) 40000.00;

    public static void main(String[] args) throws IOException {
       
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        ClosestPair inst  =new ClosestPair();
        while ((line = in.readLine()) != null) {
        	if(line.length()==0) {
        		continue;
        	}

        	String[] split = line.split(" ");
        	if(split.length==1) {
        		if(!split[0].equals("0")) {
        			nums_points.add(Integer.valueOf(split[0]));
        		}
        		continue;
        	}
        	System.out.println(line);
        	ClosestPair.Point currPt = inst.new Point(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
        	points.add(currPt);
        }
        
        Integer curr_idx=0;
        for(Integer numOfPoints:nums_points) {
        	 for(int firstIdx =curr_idx; firstIdx<curr_idx+numOfPoints;firstIdx++) {
             	Point firstPoint = points.get(firstIdx);
             	
             	for(int secIdx =firstIdx+1; secIdx<curr_idx+numOfPoints;secIdx++) {
             		Point secPoint = points.get(secIdx);
             		
             		Double calcDistance = calcDistance(firstPoint.getX(),firstPoint.getY(),secPoint.getX(),secPoint.getY());
             		if(calcDistance<min_dist) {
             			min_dist =calcDistance;
             		}
                 }
             	
             }
        	 if(min_dist>10000) {
             	System.out.println("INFINITY");
             }else {
             	System.out.println(String.format("%.4f", min_dist));
             }
          	 min_dist = (double) 40000.00;
          	 curr_idx+=numOfPoints;
        }
        
       
        
        
       // String longRepSubStr = longestSubSeq(line);
//        if(longRepSubStr.trim().length()==0) {
//            System.out.println("NONE");
//        }else {
        
         
//        }
    }
   
  
   
    public static Double calcDistance (Integer point1_x, Integer point1_y,Integer point2_x, Integer point2_y) {; 
    
    double pow_x = Math.pow ((point2_x -point1_x),2);
    double pow_y = Math.pow ((point2_y -point1_y),2);
    return Math.sqrt(pow_x+pow_y);
      
    }
    
    public class Point  {
    	private Integer x=0;
    	public Point(Integer x, Integer y) {
			super();
			this.x = x;
			this.y = y;
		}
		public Integer getX() {
			return x;
		}
		public void setX(Integer x) {
			this.x = x;
		}
		public Integer getY() {
			return y;
		}
		public void setY(Integer y) {
			this.y = y;
		}
		private Integer y=0;
    }
}
