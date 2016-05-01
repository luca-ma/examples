package num.float_ex;

import java.math.BigDecimal;

public class FloatPrecision_Ex1 {

	/**
	 * @param args
	 * check precision on summing float numbers
	 */
	public static void main(String[] args) {
		
		//sum 10 float number
		float floatNum =0.1F;
		float sum =0.0F;
		for(int idx =0;idx<10;idx++){
			sum+=floatNum;
		}

		System.out.println("Sum using float:"+sum);
		System.out.println("Error in Sum using float:"+(sum-1.0F));

		//sum 10 double number
		double doubleNum =0.1D;
		double doublSum =0.0D;
		for(int idx =0;idx<10;idx++){
			doublSum+=doubleNum;
		}

		System.out.println("Sum using float:"+doublSum);
		System.out.println("Error in Sum using float:"+(doublSum-1.0F));

		//sum 10 BigDecimal number
		BigDecimal bigDecNum = new BigDecimal(0.1F);
		BigDecimal bigDecSum = new BigDecimal(0.0F);
		for(int idx =0;idx<10;idx++){

			bigDecSum = bigDecSum.add(bigDecNum);
		}

		System.out.println("Sum using bigDec:"+bigDecSum.floatValue());
		System.out.println("Error in Sum using float:"+(bigDecSum.floatValue()-1.0F));

	}

}
