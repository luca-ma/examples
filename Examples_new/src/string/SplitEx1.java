package string;

public class SplitEx1 {

	public static void main(String[] args) {

		String row = "       vnfd_nms_ci_3.0.yml       [ NOT LOADED ]";
		row = row.trim();
		String[] split = row.split("\\[");
		String key =split[0].trim();
		String value =split[1].trim();
		value = value.substring(0, value.length()-1);
		System.out.println(value);
	}

}
