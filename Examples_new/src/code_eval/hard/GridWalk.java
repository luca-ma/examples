package code_eval.hard;

import java.util.ArrayList;

public class GridWalk {

    /**
     * 722
     * @param args
     */
    public static final Integer MAX_INT =19;
    public static ArrayList<Point> visited_Points = new ArrayList<Point>();
   
    public static void main(String[] args) {
        GridWalk inst  =new GridWalk();
        //visited_Points.add(inst.new Point(0,0));
       
        addPoint(inst.new Point(0,0));
        System.out.println(visited_Points.size());
      //  System.out.println(visited_Points);

    }
   
    public static void addPoint(Point pt) {
        Integer curr_x = pt.getX();
        Integer curr_y = pt.getY();
        if((pointContained(pt)) && !pointVisited(pt)){
            visited_Points.add(pt);
            GridWalk inst = new GridWalk();
            addPoint(inst.new Point(curr_x+1, curr_y));
            addPoint(inst.new Point(curr_x, curr_y+1));
            addPoint(inst.new Point(curr_x-1, curr_y));
            addPoint(inst.new Point(curr_x, curr_y-1));
        }else {
            return;
        }
    }
   
    public static Boolean pointContained(Point pt) {
        Integer x = pt.getX();
        Integer y = pt.getY();
        if(x<0) x=-x;
        if(y<0) y=-y;
        if(x+y>MAX_INT) return false;
        return true;
    }
    public static Boolean pointVisited(Point pt) {
        Integer x = pt.getX();
        Integer y = pt.getY();
        for(Point vis_pt : visited_Points){
        	if((vis_pt.getX().equals(x))
        		&&(vis_pt.getY().equals(y)))
        		 return true;
        }
       
        return false;
    }
   
    public class Point  {
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
        private Integer x =0;
        private Integer y= 0;
		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
    }

}


