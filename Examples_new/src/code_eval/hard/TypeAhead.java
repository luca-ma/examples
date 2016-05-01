package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class TypeAhead {

	public static String text_to_analize = "Mary had a little lamb its fleece was white as snow;"+
											" And everywhere that Mary went, the lamb was sure to go."+ 
											" It followed her to school one day, which was against the rule;"+	
											" It made the children laugh and play, to see a lamb at school."+
											" And so the teacher turned it out, but still it lingered near,"+
											" And waited patiently about till Mary did appear.\""+
											" \"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";
    
	public static String text_to_analize2 ="ONE TWO ONE TWO THREE TWO THREE";
	public static TreeMap<String,Float> occMap = null;
	public static Map<String,Float> outMap = null;
	
	public static StringBuilder spr = null;
   
    //public static ArrayList<TypeAhead.Point> points = new ArrayList<Point>();
    public static ArrayList<Integer> nums_points = new ArrayList<Integer>();
    
    public static Integer max_min_distance  = 10000;
    public static Double min_dist = (double) 40000.00;

    public static void main(String[] args) throws IOException {
       
    	//build an arrylist with text_to_analize
    	//for()
    	
    	String[] textArr = text_to_analize.split(" ");
    	List<String> textList = Arrays.asList(textArr);
    	
    	
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

       // TypeAhead inst  =new TypeAhead();
        while ((line = in.readLine()) != null) {
        	if(line.length()==0) {
        		continue;
        	}
        	
        	HashMap<String,Float> map = new HashMap<String,Float>();
           ValueComparator bvc =  new ValueComparator(map);
           // TreeMap<String,Double> sorted_map = new TreeMap<String,Double>(bvc);
        //	outMap = new TMap<String,Float>(bvc);
        	occMap = new TreeMap<String, Float>();
        	Integer totalFnd = 0;
        	

        	String[] split = line.split(",");
        
        	//System.out.println(line);
        	
        	Integer numsAfter = Integer.valueOf(split[0]);
        	String word = split[1];
        	ArrayList<Integer> listOfFndIdx =new ArrayList<Integer>();
        	for(int x =0;x<textList.size();x++){
        		String wordInList = textList.get(x);
        		if(wordInList.equals(word)){
        			listOfFndIdx.add(x);
        		}
        	}
        	
        	for(Integer idxOfOcc: listOfFndIdx){

        		for(int idx =1; idx <=(numsAfter-1);idx++){
        			String str = textList.get(idxOfOcc+idx);
        			Character lastChr = str.charAt(str.length()-1);
        			if(!Character.isAlphabetic(lastChr)){
        				str = str.substring(0, str.length()-1);
        			}
        			Float numOfOcc = occMap.get(str);
        			if(numOfOcc==null){
        				occMap.put(str, 1F);
        			}else {
        				numOfOcc++;
        				occMap.put(str, numOfOcc);
        			}
        			totalFnd++;
        		}
        	}
        	for(Map.Entry<String, Float> occEntry :occMap.entrySet()){
        		occEntry.setValue(occEntry.getValue()/totalFnd);
        	//	outMap.put(occEntry.getKey(),occEntry.getValue());
        	}
        	outMap = sortByComparator(occMap);
        	
        	
        	//<Float, String> descendingMap = outMap.descendingMap();
        	StringBuilder strout = new StringBuilder();
        	for(Map.Entry<String,Float> outEntry :outMap.entrySet()){
        		strout.append(outEntry.getKey()).append(",");
        		
        		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols();
        		otherSymbols.setDecimalSeparator('.');
        		otherSymbols.setGroupingSeparator('.'); 
        		DecimalFormat df = new DecimalFormat("#.###", otherSymbols);
        	//	DecimalFormat formatter = new DecimalFormat("#.###");

        		//System.out.println(formatter.format(amount));
        		//String.format("%.3f", outEntry.getValue())
        		strout.append(df.format(outEntry.getValue()));
        		strout.append(";");
        	}
        	strout.deleteCharAt(strout.length()-1);
        	System.out.println(strout);
        	//TypeAhead.Point currPt = inst.new Point(Integer.valueOf(split[0]),Integer.valueOf(split[1]));
        	//points.add(currPt);
        }
        
       
    
        
       
        
        
       // String longRepSubStr = longestSubSeq(line);
//        if(longRepSubStr.trim().length()==0) {
//            System.out.println("NONE");
//        }else {
        
         
//        }
    }
    public  static Map sortByComparator(Map unsortMap) {
    	 
		List list = new LinkedList(unsortMap.entrySet());
 
		// sort list based on comparator
		Collections.sort(list, new Comparator() {
			public int compare(Object o2, Object o1) {
				return ((Comparable) ((Map.Entry) (o1)).getValue())
                                       .compareTo(((Map.Entry) (o2)).getValue());
			}
		});
 
		// put sorted list into map again
                //LinkedHashMap make sure order in which keys were inserted
		Map sortedMap = new LinkedHashMap();
		//Collections.reverseOrder(list);
		for (Iterator it = list.iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
   
  
}
   
    
    class ValueComparator implements Comparator<String> {

        Map<String, Float> base;
        public ValueComparator(Map<String, Float> base) {
            this.base = base;
        }

        // Note: this comparator imposes orderings that are inconsistent with equals.    
        public int compare(String a, String b) {
           if (base==null)
        		   return 0;
        	if((a==null)||(b==null))
        	   return 0;
        	if ((base.get(a)==null)||(base.get(b)==null))
        		return 0;
        	if (base.get(a) >= base.get(b)) {
                return -1;
            } else {
                return 1;
            } // returning 0 would merge keys
        }
    }

