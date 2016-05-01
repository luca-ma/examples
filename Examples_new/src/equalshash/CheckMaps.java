package equalshash;

import java.util.HashMap;

public class CheckMaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NameEqNoHash noHash1 = new NameEqNoHash("luca");
		NameEqNoHash noHash3 = new NameEqNoHash("ppp");
		
		HashMap<NameEqNoHash,String> noHashMap = new HashMap<NameEqNoHash,String>();
		noHashMap.put(noHash1, "aaa");
		noHashMap.put(noHash3, "bbb");
		
		
		NameEqNoHash noHash2 = new NameEqNoHash("luca");
		if (noHash1.equals(noHash2)) {
			System.out.println("ok nohash equals");//OK obj equals!!!
			
		}
		String string = noHashMap.get(noHash2);
		System.out.println("get map value:"+string);//string is null!!!
		
		NameEqHash hash1 = new NameEqHash("luca");
		NameEqHash hash2 = new NameEqHash("luca");
		NameEqHash hash3 = new NameEqHash("ppp");
		
		HashMap<NameEqHash,String> hashMap = new HashMap<NameEqHash,String>();
		hashMap.put(hash1, "aaa");
		hashMap.put(hash3, "bbb");
		
		String stringHash = hashMap.get(hash2);
		System.out.println("get map value:"+stringHash);//aaa value is returned OK!!!
		
		
//		if(hash1.equals(hash2)) {
//			System.out.println("hash1 == hash2");
//		}else {
//			System.out.println("hash1 != hash2");
//		}
//		if(hash1.equals(hash3)) {
//			System.out.println("hash1 == hash3");
//		}else {
//			System.out.println("hash1 != hash3");
//		}
	}

}
