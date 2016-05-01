package code_eval.easy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Fibonacci {

	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			try {
				System.out.println(""+fibonacci(Integer.valueOf(line)));
			}catch (NumberFormatException numExc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
		}
	
	public static Integer fibonacci (Integer num) {

		if(num==null) {
			return 0;
		}else if(num<0) {
			return 0;
		}else if (num.equals(0)) {
			return 0;
		}else if (num.equals(1)) {
			return 1;
		}else {
			return (fibonacci(num-1)+fibonacci(num-2));
		}
	}
	
}
