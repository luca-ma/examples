package string;

public class SplitEx {

	public static void main(String[] args) {

		String str ="+39025577102,,paola,paola@unicredit.com,LYNC,italy.it,lyncUnicredit.com,italy.it,P,";
		String[] split = str.split(",");
		
		System.out.println(split.length);
		
		String strWithPoint = "ascv.csv";
		String[] split2 = strWithPoint.split(".");
		System.out.println(split2.length);
		String[] split3 = strWithPoint.split("\\.");
		System.out.println(split3.length);
		
	}

}
