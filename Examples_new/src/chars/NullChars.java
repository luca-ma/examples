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
public class NullChars {
	public static void main(String[] args) {


		char[] chars = new char[7];
		Arrays.fill(chars, '\0');
		String buildStr =String.valueOf(chars);
		System.out.println( "str :"+ buildStr);

		Field fld = new Field(10, "15", '\0');

		File file2Save = new File ("D:\\luca\\tmpfile.ttt");
		if(file2Save.exists()) {
			file2Save.delete();
		}else {
			try {
				file2Save.createNewFile();
			} catch (IOException e) {
				System.out.println("file: "+file2Save.getAbsolutePath()+" NOT created");
			}
		}
		try{
			FileOutputStream fos = new FileOutputStream(file2Save);
			fos.write(fld.getValue().getBytes());
			fos.close();
		}catch(FileNotFoundException ex) {
			System.out.println("file: "+file2Save.getAbsolutePath()+" NOT found");
		}catch(Exception ex) {
			System.out.println("exception working on file: "+file2Save.getAbsolutePath());
		}


	}
}
