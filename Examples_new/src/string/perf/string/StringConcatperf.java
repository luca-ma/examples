package string.perf.string;

public class StringConcatperf {

	private static int LEN =100000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String iniChr = "a";
		String str = iniChr; 
		long initTime = System.currentTimeMillis();
		while(str.length()<LEN) {
			str+=iniChr;
		}
		long elapsedT = (System.currentTimeMillis()-initTime);
		System.out.println("Strconcat done in :"+elapsedT+" msec.");
		
		StringBuilder strBuild = new StringBuilder(iniChr);
		 initTime = System.currentTimeMillis();
		while(strBuild.length()<LEN) {
			strBuild.append(iniChr);
		}
		elapsedT = (System.currentTimeMillis()-initTime);
		System.out.println("StrBuilder.append done in :"+elapsedT+" msec.");
	}

}
