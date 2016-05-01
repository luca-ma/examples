package cripto_courseI;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

public class UtilsCripto {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String exStr = "a";
		String b = "b";
		String spaces = " ";
		// System.out.println("ex:" + toByteArray(exStr));
		String asciiStr = toHexAsciiArray(exStr);
		String asciiSpaces = toHexAsciiArray(spaces);
		System.out.println("exAsciiStrEx:" + asciiStr);
		System.out.println("spacesStrEx:" + asciiSpaces);
		String asciiStrOri = hexToASCII(asciiStr);
		System.out.println("exAsciiStr:" + asciiStrOri);
		System.out.println("exOrSpacesValII:" + stringExOR(exStr, spaces));
		System.out.println("exOrSpacesValII:" + stringExOR(exStr, b));
	}
	public static String toHexString(byte[] array) {
		return DatatypeConverter.printHexBinary(array);
	}
	public static String toHexAsciiArray(String str) {
		char a;
		int j;
		String retStr = "";
		for (int i = 0; i < str.length(); ++i) {
			char c = str.charAt(i);
			j = (int) c;
			a = (char) j;
			// System.out.println("char:" + a);
			// System.out.println("decAsciiInt:" + j);
			// System.out.println("hexAsciiInt:" + Integer.toHexString(j));
			String hexString = Integer.toHexString(j);
			if (hexString.length() == 1) {
				hexString = "0" + hexString;
			}
			retStr += hexString;
		}
		return retStr;
	}
	/**
	 * str1 and str2 both in ascii.... i.e. str1 = "A" str2 = " " --> res = "a"
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String stringExOR(String str1, String str2) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str1.length(); i++)
			sb.append((char) (str1.charAt(i) ^ str2.charAt(i)));
		return (sb.toString());
	}
	public static String hexToASCII(String hex) {
		if (hex.length() % 2 != 0) {
			System.err.println("requires EVEN number of chars");
			return null;
		}
		StringBuilder sb = new StringBuilder();
		// Convert Hex 0232343536AB into two characters stream.
		for (int i = 0; i < hex.length() - 1; i += 2) {
			/*
			 * Grab the hex in pairs
			 */
			String output = hex.substring(i, (i + 2));
			/*
			 * Convert Hex to Decimal
			 */
			try {
				int decimal = Integer.parseInt(output, 16);
				sb.append((char) decimal);
			} catch (NumberFormatException numExc) {
				sb.append("_");
			}
		}
		return sb.toString();
	}
}
