package ocp_5_exam_string_pattern;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Calendar;

public class StringFormat2 {

	public static void main(String[] args) {
		String str = String.format("%-1.2f.", 1.0,2.5);
		System.out.println(str);
		
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.MONTH, Calendar.FEBRUARY);
		
		System.out.println(instance.getTime());
		instance.roll(Calendar.DAY_OF_MONTH, 30);
		
		System.out.println(instance.getTime());
	}

}
