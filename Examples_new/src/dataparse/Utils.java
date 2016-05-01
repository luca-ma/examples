package dataparse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Utils {

	//remove in an array space elements
	public static ArrayList<String> removeSpacesElem (String[] arrStr){
		ArrayList<String> retList = new ArrayList<String>();
		for(int idx =0;idx<arrStr.length;idx++){
			if(arrStr[idx]!=null && arrStr[idx]!=" " && arrStr[idx].length()>0){
				retList.add(arrStr[idx]);
			}
		}
		return retList;
	}
	
	public  static HashMap<Integer,Integer> getExchangeMap(){
		HashMap<Integer,Integer> exchMap = new HashMap<Integer,Integer>();
		File file = new File(System.getProperty("user.dir") + File.separator
				+ "src\\dataparse\\exchange_vector.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] tokens = line.split(";");
				for(int idx =0;idx<tokens.length;idx++){
					String[] pair = tokens[idx].split(",");
					exchMap.put(Integer.valueOf(pair[0]),Integer.valueOf(pair[1]));
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return exchMap;
	}
	
	public static List<ArrayList<Complex>>  exchangeRowColMatrix(List<ArrayList<Complex>> scatterMatrix , Integer from, Integer to){
		
		//Exchange Rows
		ArrayList<Complex> oriFromRow = scatterMatrix.get(from-1);
		scatterMatrix.set(from-1, scatterMatrix.get(to-1));
		scatterMatrix.set(to-1, oriFromRow);
		
		//Echange Cols
		for(int row =0; row<scatterMatrix.size();row++){
			ArrayList<Complex> rowMatrix = scatterMatrix.get(row);
			
			Complex tmp = rowMatrix.get(from-1);
			rowMatrix.set(from-1, rowMatrix.get(to-1));
			rowMatrix.set(to-1, tmp);
		}
		
		return scatterMatrix;
	
	}
	
	public static List<ArrayList<Boolean>> buildMaskMatrix(){
		List<ArrayList<Boolean>> mask = new ArrayList<ArrayList<Boolean>>();
		File file = new File(System.getProperty("user.dir") + File.separator
				+ "src\\dataparse\\mask.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] rows = line.split(";");
				
				for(int idx =0;idx<rows.length;idx++){
					ArrayList<Boolean> maskRow = new ArrayList<Boolean>();
					
					String[] values = rows[idx].split(",");
					for(int col =0;col<values.length;col++){
						Integer maskVal =  Integer.valueOf(values[col]);
						if(maskVal.equals(1)){
							maskRow.add(col, true);
						}else {
							maskRow.add(col, false);
						}
						
					}
					mask.add(idx,maskRow);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return mask;
	}
	
	
	public static List<ArrayList<Complex>>  applyMask(List<ArrayList<Complex>> matrix,List<ArrayList<Boolean>> mask){
		
		for(int row =0; row<mask.size();row++){
			ArrayList<Complex> matrixRow = matrix.get(row);
			ArrayList<Boolean> maskRow = mask.get(row);
			
			for(int col =0; col<maskRow.size();col++){
				
				if (!maskRow.get(col)){
					matrixRow.set(col, new Complex(0.0,0.0));
				}
				
			}
			
			
			
		}
		
		return matrix;
	}
	
}
