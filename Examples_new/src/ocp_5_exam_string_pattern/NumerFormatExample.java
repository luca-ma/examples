package ocp_5_exam_string_pattern;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Locale;

public class NumerFormatExample {

	public static void main(String[] args) throws ParseException {
		
		double amount = 123456.789; 
		Locale fr = new Locale("fr", "FR"); 
		NumberFormat formatter = NumberFormat.getInstance(fr);
		String s = formatter.format(amount) ; 
		System.out.println( "s: "+s);
		formatter = NumberFormat.getInstance(); 
		Number amount2 = formatter.parse(s); 
		System.out.println( "amount in locale:"+fr+", is :"+amount );
		System.out.println( "amount in DEflocale:"+Locale.getDefault()+", is :"+amount2 );
		System.out.println( "amount in DEflocale:"+Locale.getDefault()+", is :"+formatter.format(amount));
		
		NumberFormat currencyInstanceF = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println( "currency in DEflocale:"+Locale.US+", is :"+currencyInstanceF.format(amount));
		
		System.out.println(Arrays.toString(Locale.getAvailableLocales()));
	}

}
