package equalshash;

public class CheckEquals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NameEqNoHash noHash1 = new NameEqNoHash("luca");
		NameEqNoHash noHash2 = new NameEqNoHash("luca");
		NameEqNoHash noHash3 = new NameEqNoHash("ppp");
		
		if(noHash1.equals(noHash2)) {
			System.out.println("nohash1 == nohash2");
		}else {
			System.out.println("nohash1 != nohash2");
		}
		if(noHash1.equals(noHash3)) {
			System.out.println("nohash1 == nohash3");
		}else {
			System.out.println("nohash1 != nohash3");
		}
		
		
		NameEqHash hash1 = new NameEqHash("luca");
		NameEqHash hash2 = new NameEqHash("luca");
		NameEqHash hash3 = new NameEqHash("ppp");
		
		if(hash1.equals(hash2)) {
			System.out.println("hash1 == hash2");
		}else {
			System.out.println("hash1 != hash2");
		}
		if(hash1.equals(hash3)) {
			System.out.println("hash1 == hash3");
		}else {
			System.out.println("hash1 != hash3");
		}
	}

}
