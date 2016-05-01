package example;

public class ExampleS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Double hc = 5.031E24;
		Double hc = 1 / (6.626E-34 * 2.998E8);

		System.out.println(hc);

		// Resp 4.4.2
		double A1 = (calcIntlinExpr(7.5E15, -2.25E9, 300E-9, 500E-9)) * hc;
		// System.out.println(A1);

		double A2 = (calcIntlinExpr(-1.5E15, 2.25E9, 500E-9, 1500E-9)) * hc;
		// System.out.println(A2);

		double tot = A1 + A2;
		System.out.println("A:" + tot);

		double q = 1.6E-19;
		double EQE = 0.8;
		double A2part = (calcIntlinExpr(-1.5E15, 2.25E9, 500E-9, 700E-9)) * hc;
		System.out.println("A2part" + A2part);

		double JA = (1 / 10.0) * q * EQE * (A1 + A2part);
		System.out.println("JA:" + JA);

		double A3part = (calcIntlinExpr(-1.5E15, 2.25E9, 700E-9, 1300E-9)) * hc;
		System.out.println("A3part:" + A3part);

		// System.out.println("a1+a3+a3part:" + (A1 + A2part + A3part));

		double JB = (1 / 10.0) * q * 0.6 * (A3part);
		System.out.println("JB:" + JB);

	}

	/**
	 * Ax^2+Bx --> Ax^3/3+ Bx^2/2
	 * 
	 */
	private static Double calcIntlinExpr(double A, double B, double inf,
			double sup) {

		double supVal = ((Math.pow(sup, 3)) * A) / 3 + ((Math.pow(sup, 2)) * B)
				/ 2;
		double infVal = ((Math.pow(inf, 3)) * A) / 3 + ((Math.pow(inf, 2)) * B)
				/ 2;

		return (supVal - infVal);
	}
}
