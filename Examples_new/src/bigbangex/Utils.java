package bigbangex;

public class Utils {

	
	public static final String C ="3E8";
	public static final String plackRidotta = "6.582E-16"; //ev*sec.
	
	public static Double W_MASS = 80.385;// Gev/c^2
	public static Double Z_MASS = 91.1876;// Gev/c^2
	public static Double HIGGS_MASS = 125.3;// Gev/c^2
	
	public static Double PROTON_MASS = 0.938; //geV/c2
	public static Double NEUTRON_MASS = 0.939565; //geV/c2
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//a 2 exp -18, r 2exp -20

		Double a = Double.valueOf("2E-18");
		Double r = Double.valueOf("2E-20");
		 Double potRatio1 = getPotRatio(r,a);
		 System.out.println(potRatio1);
		
		 
		 
		//a 2 exp -18, r 2exp -18
		  r = Double.valueOf("2E-18");
		 Double potRatio2 = getPotRatio(r,a);
		 System.out.println(potRatio2);
		 
		//a 2 exp -18, r 2exp -16
		  r = Double.valueOf("2E-16");
		 Double potRatio3 = getPotRatio(r,a);
		 System.out.println(potRatio3);
		 
		 //3 .. to convert the length scale a
		 Double htagl = Double.valueOf(plackRidotta);
		 Double c = Double.valueOf(C);
		 Double en_ev =((htagl*c)/(a));
		 System.out.println(en_ev);
		 
		 System.out.println(en_ev/1E9);
		 
		 Double en_GEv = (en_ev/1E9);
		 
		 System.out.println(en_GEv - W_MASS );
		 System.out.println(en_GEv - Z_MASS );
		 System.out.println(en_GEv - HIGGS_MASS );
		 
		 //10.
		 
		 Double htagl_GEv = 1/6.582E25;
		 
		 Double val =(((1/(2.4*60))*htagl_GEv*16.0*Math.pow(Math.PI,2))/(Math.pow(c,10)*Math.pow(1/1.166E5,2)));
		 System.out.println(val);
		 Double val1 = Math.pow(NEUTRON_MASS,5)-Math.pow(PROTON_MASS,5);
		 System.out.println(val1);
		 Double val2 = Math.pow(NEUTRON_MASS-PROTON_MASS,5);
		 System.out.println(val2);
		 
	}


/**

 * @param radius
 * @param a
 * @return
 */
public static Double getPotRatio(Double radius, Double a  ){
	
	return 1/Math.exp(radius/a);
}	
}
