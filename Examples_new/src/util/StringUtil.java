package util;

import java.util.ArrayList;

public class StringUtil {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str_ini = "pippo ppl";
		String str1 = "TRUE ";
		String str2 = "TRUE";
		// System.out.println(str1.trim().equalsIgnoreCase(str2));
		String preStr = "(";
		String suffStr = ")";
		String strMod = SurroundStringWithString(str_ini, preStr, suffStr);
		// System.out.println(strMod);

		String str = "ABCD";

		String replace = str.replace("A", "");

		System.out.println(str.concat("E"));

		StringBuilder strB = new StringBuilder("ABCD");
		// strB.delete(0, 2);
		strB.deleteCharAt(0);
		System.out.println(strB);

		ArrayList<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");

		list.remove(new Integer(0));
		System.out.println(list);

		StringBuilder sb = new StringBuilder();

	}

	public static String SurroundStringWithString(String strIni,
			String prefixStr, String suffixStr) {

		StringBuffer stBuf = new StringBuffer(strIni);
		stBuf.append(suffixStr);
		stBuf.insert(0, prefixStr);
		return (stBuf.toString());

	}

}
