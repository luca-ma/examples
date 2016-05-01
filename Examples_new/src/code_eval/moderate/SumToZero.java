package code_eval.moderate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SumToZero {

	public static ArrayList<Integer> baseNum =null;
	public static ArrayList<Integer> combinazioni =new ArrayList<Integer>();
	public static int count = 0;
	public static ArrayList<ArrayList<Integer>> combList = new  ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {


		File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			try {
				String[] split = line.split(",");
				
				baseNum = new  ArrayList<Integer> ();
				for(int idx=0;idx<split.length;idx++){
					baseNum.add(Integer.valueOf(split[idx]));
				}
				combList = new  ArrayList<ArrayList<Integer>>();
				combination(baseNum, 3);
				System.out.println(combList.size());
				

			}catch (Exception exc) {
				System.out.println("invalid line....skip it!");
				continue;
			}
		}
	}
		
	
	private static void  combination(ArrayList<Integer>  letters, int k) {
		ArrayList<Integer> comb =new ArrayList<Integer>();
		ArrayList<Integer> comb2 =combinationRic(letters, comb, 0, k);
    }
   
    private static ArrayList<Integer> combinationRic(ArrayList<Integer> letters, ArrayList<Integer> comb, int m, int k) {
        if (k == 0) {
        	System.out.println(comb);
        	if(sumIsZero(comb)) {
            	combList.add(comb);
        	}
        	return new ArrayList<Integer>();
        } else {
            for (int i=m; i < letters.size() ; i++) {
            	comb.add(letters.get(i));
            	ArrayList<Integer>lettersTmp = letters;
            	//lettersTmp.remove(i);
                ArrayList<Integer> combMod = combinationRic(lettersTmp, comb, i+1, k-1);
                comb.remove(letters.get(i));
                // comb.add(letters.get(i));
            }
        }
        return new ArrayList<Integer>();
    }
	
    private static boolean sumIsZero(ArrayList<Integer> nums) {
    	Integer sum = 0;
    	for(Integer num: nums) {
    		sum+=num;
    	}
    	if(sum.equals(0)) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }

}