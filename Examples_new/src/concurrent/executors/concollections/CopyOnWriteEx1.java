package concurrent.executors.concollections;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteEx1 {
	
	private CopyOnWriteArrayList<String> cal = new CopyOnWriteArrayList<>();
	public void addData(List<String> list){ 
		cal.addAll(list);
	} 
	
	public Iterator getIterator(){ 
		return cal.iterator();
				} 
	
}
