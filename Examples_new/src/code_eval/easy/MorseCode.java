package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MorseCode {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			try {
				
				String[] lineSplitted = line.split(" ");
				
				String morseDecoded  ="";
				String letter  ="";
				for(int idx =0; idx < lineSplitted.length; idx++) {
					String charMorse = lineSplitted[idx];
					if(charMorse.equals("")) {
						morseDecoded+=letter+" ";
						letter ="";
					}else {
						letter+=morseDecode(charMorse);
					}
				}
				morseDecoded+=letter+" ";
				System.out.println(""+morseDecoded.toUpperCase());
			}catch (NumberFormatException numExc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
		}
	
	private static String morseDecode(String toEncode) {
		    String morse = toEncode;
			 
		if (toEncode.equalsIgnoreCase(".-"))
		morse = "a";
		if (toEncode.equalsIgnoreCase("-..."))
		morse = "b";
		if (toEncode.equalsIgnoreCase("-.-."))
		            morse = "c";
		  if (toEncode.equalsIgnoreCase("-.."))
			            morse = "d";
		if (toEncode.equalsIgnoreCase("."))
		morse = "e";
		if (toEncode.equalsIgnoreCase("..-."))
		morse = "f";
			        if (toEncode.equalsIgnoreCase("--."))
			            morse = "g";
		        if (toEncode.equalsIgnoreCase("...."))
			            morse = "h";
			        if (toEncode.equalsIgnoreCase(".."))
		morse = "i";
		if (toEncode.equalsIgnoreCase(".---"))
		morse = "j";
		if (toEncode.equalsIgnoreCase("-.-/>"))
		morse = "k";
		if (toEncode.equalsIgnoreCase(".-.."))
			            morse = "l";
		if (toEncode.equalsIgnoreCase("--"))
		morse = "m";
		if (toEncode.equalsIgnoreCase("-."))
		morse = "n";
		if (toEncode.equalsIgnoreCase("---"))
		morse = "o";
		if (toEncode.equalsIgnoreCase(".--."))
		morse = "p";
		if (toEncode.equalsIgnoreCase("--.-/>"))
		morse = "q";
			        if (toEncode.equalsIgnoreCase(".-."))
		morse = "r";
		if (toEncode.equalsIgnoreCase("..."))
		morse = "s";
		if (toEncode.equalsIgnoreCase("-"))
		morse = "t";
		if (toEncode.equalsIgnoreCase("..-"))
		morse = "u";
			        if (toEncode.equalsIgnoreCase("...-"))
		morse = "v";
		if (toEncode.equalsIgnoreCase(".--"))
		morse = "w";
			        if (toEncode.equalsIgnoreCase("-..-"))
			            morse = "x";
			        if (toEncode.equalsIgnoreCase("-.-/>-"))
			            morse = "y";
			        if (toEncode.equalsIgnoreCase("--.."))
			            morse = "z";
			        if (toEncode.equalsIgnoreCase("-----"))
			            morse = "0";
			        if (toEncode.equalsIgnoreCase(".----"))
			            morse = "1";
			        if (toEncode.equalsIgnoreCase("..---"))
			            morse = "2";
			        if (toEncode.equalsIgnoreCase("...--"))
			            morse = "3";
			        if (toEncode.equalsIgnoreCase("....-"))
			            morse = "4";
			        if (toEncode.equalsIgnoreCase("....."))
			            morse = "5";
			        if (toEncode.equalsIgnoreCase("-...."))
			            morse = "6";
			        if (toEncode.equalsIgnoreCase("--..."))
			            morse = "7";
			        if (toEncode.equalsIgnoreCase("---.."))
			            morse = "8";
			        if (toEncode.equalsIgnoreCase("----."))
			            morse = "9";
			        if (toEncode.equalsIgnoreCase(" "))
			            morse = "";
			 
			        return morse;
			    }
	
	
}
