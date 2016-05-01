package ocp_6_exam.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEx {

	public static void main(String[] args) {
		String[] names = {"Alex", "Bob", "Charlie" };
		List<?> list = new ArrayList<?>(Arrays.asList(names));

	}

}
