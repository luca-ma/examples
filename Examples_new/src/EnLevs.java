public class EnLevs {

	public static final double EL_MASS = 9.109E-31;
	public static final double H_SIGN = 1.055E-34;
	public static final double L = 5E-10;

	public static void main(String[] args) {
		// TODO Auto-generated method stub4

		Double E1 = calcEnLev(1);
		System.out.println("E1:" + E1);

		Double E2 = calcEnLev(2);
		System.out.println("E2:" + E2);
		double diff = E2 - E1;
		System.out.println("E2-E1:" + diff);

		Double E3 = calcEnLev(3);
		System.out.println(E3);
		System.out.println("E3:" + E3);
		diff = E3 - E1;
		System.out.println("E3-E1:" + diff);
	}

	public static double calcEnLev(Integer level) {
		double en = (Math.pow(H_SIGN, 2) / (2 * EL_MASS))
				* Math.pow((Math.PI / L), 2) * Math.pow(level, 2);
		return (en * 6.241509e18);
	}

}
