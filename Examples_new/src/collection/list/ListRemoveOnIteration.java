package collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class ListRemoveOnIteration {

	public static void main(String[] args) {
		
		
		List<String> iniList = new ArrayList<String>();
		List<String> cpList = new ArrayList<String>();
		cpList = iniList;
		iniList.add("A");
		iniList.add("B");
		iniList.add("C");
		for(String  str  : iniList){
			if(str.equals("B"))
			iniList.remove("B");
		}
		System.out.println("INI LIST:"+iniList);	
		System.out.println("CP LIST:"+cpList);
		
		}

}
