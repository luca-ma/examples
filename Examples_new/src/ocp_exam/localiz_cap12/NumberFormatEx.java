package ocp_exam.localiz_cap12;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberFormatEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//number format using locale
		Locale locale = new Locale("da", "DK");
		NumberFormat numberFormat = NumberFormat.getInstance(locale);
		String number = numberFormat.format(100.99);
		System.out.println(number);
		
		//currency
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale);
		String currency = currencyFormat.format(100.999);
		System.out.println(currency);
		
		 numberFormat =
			    NumberFormat.getCurrencyInstance(new Locale("da", "DK"));
			numberFormat.setCurrency(Currency.getInstance("EUR"));

			String currencyString = numberFormat.format(120.99);
			System.out.println(currencyString);

			Locale defaultLocale = Locale.getDefault();
			defaultLocale.getCountry();
			NumberFormat currencyFormatLoc = NumberFormat.getCurrencyInstance(defaultLocale);
			String currencyLoc = currencyFormatLoc.format(100.999);
			System.out.println(defaultLocale.getCountry());
	}

}
