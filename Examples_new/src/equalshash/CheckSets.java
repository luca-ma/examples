package equalshash;

import java.util.HashMap;
import java.util.HashSet;

public class CheckSets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		NameEqNoHash noHash1 = new NameEqNoHash("luca");
		NameEqNoHash noHash3 = new NameEqNoHash("ppp");
		
		HashSet<NameEqNoHash> noHashMap = new HashSet<NameEqNoHash>();
		noHashMap.add(noHash1);
		noHashMap.add(noHash3);
		
		
		NameEqNoHash noHash2 = new NameEqNoHash("luca");
		if (noHash1.equals(noHash2)) {
			System.out.println("ok nohash equals");//OK obj equals!!!
			
		}
		Boolean contained= noHashMap.contains(noHash2);
		System.out.println("contained in Set:"+contained);//string is null!!!
		
		NameEqHash hash1 = new NameEqHash("luca");
		NameEqHash hash2 = new NameEqHash("luca");
		NameEqHash hash3 = new NameEqHash("ppp");
		
		HashSet<NameEqHash> hashMap = new HashSet<NameEqHash>();
		hashMap.add(hash1);
		hashMap.add(hash3);
		
		Boolean cont = hashMap.contains(hash2);
		System.out.println("contained in Set:"+cont);//aaa value is returned OK!!!
		
		
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
