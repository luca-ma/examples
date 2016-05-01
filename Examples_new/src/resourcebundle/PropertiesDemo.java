package resourcebundle;


import java.util.*;

public class PropertiesDemo {

   static void displayValue(Locale currentLocale, String key) {

	   
	   ArrayList<String> list = new ArrayList<>();
      ResourceBundle labels = 
         ResourceBundle.getBundle("resourcebundle.LabelsBundle",currentLocale);
      String value  = labels.getString(key);
      System.out.println(
           "Locale = " + currentLocale.toString() + ", " +
           "key = " + key + ", " +
           "value = " + value);

   } // displayValue


   static void iterateKeys(Locale currentLocale) {

      ResourceBundle labels = 
         ResourceBundle.getBundle("resourcebundle.LabelsBundle",currentLocale);

      Enumeration bundleKeys = labels.getKeys();

      while (bundleKeys.hasMoreElements()) {
         String key = (String)bundleKeys.nextElement();
         String value  = labels.getString(key);
         System.out.println("key = " + key + ", " +
           "value = " + value);
      }

   } // iterateKeys


   static public void main(String[] args) {

      Locale[] supportedLocales = {
         Locale.FRENCH,
         Locale.GERMAN,
         Locale.ENGLISH
      };

      for (int i = 0; i < supportedLocales.length; i ++) {
          displayValue(supportedLocales[i], "s2");
      }

      System.out.println();

      iterateKeys(supportedLocales[0]);

   } // main

} // class
