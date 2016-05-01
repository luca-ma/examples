package collection.queue2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<DvdInfo> listDvdSimple = new ArrayList<DvdInfo>();
		listDvdSimple.add(new DvdInfo("aaa", "comic"));
		listDvdSimple.add(new DvdInfo("bbb", "thriller"));
		listDvdSimple.add(new DvdInfo("bbb", "musical"));
		
		//Collections.sort(listDvdSimple);//DOESN'T compile...cause DvdSimple Doesn't implements comparable
		Collections.sort(listDvdSimple,new GenreComparator());//Ok using a comparator
		
		List<DvdInfoComp> listDvdComp= new ArrayList<DvdInfoComp>();
		listDvdComp.add(new DvdInfoComp("aaa", "comic"));
		listDvdComp.add(new DvdInfoComp("bbb", "thriller"));
		listDvdComp.add(new DvdInfoComp("bbb", "musical"));
		
		Collections.sort(listDvdComp);//OK ...cause DvdInfoComp implements comparable
	}

}
