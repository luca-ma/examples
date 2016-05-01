package chars;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import bytes.Field;

/**example use and print null chars
 * 
 * @author l
 *
 */
public class NullCharsinStr {
	public static void main(String[] args) {


		char[] chars = new char[7];
		Arrays.fill(chars, '\0');
		String buildStr =String.valueOf(chars);
		System.out.println( "str :"+ buildStr);

		System.out.println( "str  len:"+ buildStr.length());
		


	}
}
