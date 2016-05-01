package astroex;
import java.math.*;
public class Ex1b_6 {

	/**
	 * @param args
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double part1= (2.0 * Math.PI)/(0.6947*86400);
		part1 = part1*part1;
		double moonRadius = 2.606 * 58228.021 *1000; //in meters
		moonRadius = moonRadius*moonRadius*moonRadius;
		double massMoon = (moonRadius * part1 )/(6.673E-11);
		double massEarth = 5.97219E24;
		System.out.println("massMoon Abs:"+massMoon);
		System.out.println("massMoon:"+massMoon/massEarth);
		
		double radius = 58228.021 * 1000;//radius in meters
		double vol = ((4*Math.PI)/3)*(radius*radius*radius);
		
		System.out.println("denityMoon:"+massMoon/vol);
		
	}

}
