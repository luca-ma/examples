package ocp_exam.concurrency_cap12;

import java.util.Locale;
import java.util.Locale.Category;

public class LocaleEx {

	public static void main(String[] args) {
		
		Locale loc = new Locale("it");
		System.out.println(loc.getCountry()+","+loc.getLanguage());
		Locale build = new Locale.Builder().setLanguage("it").build();
		System.out.println(Locale.getDefault());
		Locale.setDefault(Locale.ENGLISH);
		System.out.println(Locale.getDefault());
		Locale.setDefault(Category.FORMAT,Locale.GERMAN);
		System.out.println(Locale.getDefault());
		Locale.setDefault(Category.DISPLAY,Locale.GERMAN);
		System.out.println(Locale.getDefault());
	}

}
