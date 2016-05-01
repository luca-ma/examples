package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;




public class RobMovements {

	static Map<String,String> numToLetters = new TreeMap<String,String>();
	static Set<String> lettersList = new TreeSet<String>();
	
	static Integer numOfPaths =0;
	static Integer DIM = 4;
	
	//static StringBuilder strOut = null;
	static String line= null;
	

	public static void main(String[] args) throws IOException {

		 
		numToLetters.put("0","0");
		numToLetters.put("1","1");
		numToLetters.put("2","abc");
		numToLetters.put("3","def");
		numToLetters.put("4","ghi");
		numToLetters.put("5","jkl");
		numToLetters.put("6","mno");
		numToLetters.put("7","pqrs");
		numToLetters.put("8","tuv");
		numToLetters.put("9","wxyz");


		try {
			boolean[][] pos = new boolean [DIM][];
			for(int idx =0;idx<DIM;idx++){
				pos [idx] = new boolean[DIM];
			}
			findP(pos,0,0);


			System.out.println(numOfPaths);


		}catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("invalid line....skip it!");

		}

		
			
		
	}
	


	public  static void findP (boolean[][] pos , Integer asc, Integer ord){
		pos[asc][ord] =true;
		if(asc.equals(DIM-1)&&ord.equals(DIM-1)){
			numOfPaths++;
			return;
		}
			
		for(int idx =-1;idx <=1;idx++){
			for(int idy =-1;idy <=1;idy++){
				if(idx==0&&idy==0)
					continue;
				if(idx!=0&&idy!=0)
					continue;
				Integer currx =asc+idx;
				Integer curry =ord+idy;
				if((currx>=0) &&(currx<DIM)&&(curry>=0) &&(curry<DIM)){
					if (!pos[currx][curry]){
						boolean[][] newPos =new boolean[DIM][DIM];
						for(int i = 0; i < pos.length; i++)
							newPos[i] = pos[i].clone();
						findP(newPos,currx, curry);
					}
				}
			}
		}
		
		
	}
	
	
}
