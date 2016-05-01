package I18N;

import java.util.Locale;
import java.util.Locale.Builder;

public class LocaleEx {

	public static void main(String[] args) {
		
		//1 Example create Locale from Const
		Locale locFromConst = Locale.ITALY;
		System.out.println(locFromConst.getCountry());
		System.out.println(locFromConst.getLanguage());
		
		
		//2 Example create Locale from constructors
		
		//Locale locale1 = new Locale("en");       // English language

		//Locale locale2 = new Locale("en", "UK"); // English language, United Kingdom
		Locale locale3 = new Locale("en", "CA"); // English language, Canada
		System.out.println(locale3.getCountry());
		System.out.println(locale3.getLanguage());
		
		//3 Example using Locale Builder
		Locale cLocale = new Locale.Builder().setLanguage("en")
                .setRegion("US").build();
		System.out.println(cLocale.getCountry());
		System.out.println(cLocale.getLanguage());
	}

}
