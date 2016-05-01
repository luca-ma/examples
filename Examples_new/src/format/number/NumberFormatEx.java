package format.number;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatEx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Float exNum = 100000.23F;
		
		NumberFormat defNumFormat = NumberFormat.getInstance();
		NumberFormat usNumFormat = NumberFormat.getInstance(Locale.US);
		NumberFormat jpNumFormat = NumberFormat.getInstance(Locale.JAPANESE);

		System.out.println(defNumFormat.format(exNum));
		System.out.println(usNumFormat.format(exNum));
		System.out.println(jpNumFormat.format(exNum));
		
		Locale[] availableLocales = Locale.getAvailableLocales();
		for(int idx =0; idx < availableLocales.length;idx++){
			System.out.println("av locale: "+availableLocales[idx]);
		}
		System.out.println();
	}

}
