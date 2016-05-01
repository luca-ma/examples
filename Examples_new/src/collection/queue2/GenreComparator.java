package collection.queue2;

import java.util.Comparator;

public class GenreComparator implements Comparator<DvdInfo> {

	@Override
	public int compare(DvdInfo first, DvdInfo second) {
		// TODO Auto-generated method stub
		return first.getGenre().compareTo(second.getGenre());
	}

}
