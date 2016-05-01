package dataparse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
import java.net.URL;

public class FreqDataParse {
	
	static boolean startData= false;

	public Integer portNumbers = 0;
	public COMPLEX_TYPE complexFormat =COMPLEX_TYPE.RI;
	public float frequency =0.0F;
	public static Integer elab_num =0;

	List<ArrayList<Complex>> scatterMatrix =  new ArrayList<ArrayList<Complex>>();
	List<ArrayList<Boolean>> mask = new ArrayList<ArrayList<Boolean>>();
	List<Integer> vectorReorder = new ArrayList<Integer>();
	Map<Float,List<ArrayList<Complex>>> defresults = new HashMap<Float,List<ArrayList<Complex>>>();

	public Boolean firstLine = true;
	
	public enum COMPLEX_TYPE {MA,RI,DB};

	public static void main(String[] args) {

		FreqDataParse instance = new FreqDataParse();

//		File file = new File(System.getProperty("user.dir") + File.separator
//				+ "src\\dataparse\\datafile.txt");
		URL url = FreqDataParse.class.getProtectionDomain().getCodeSource().getLocation();
		System.out.println(url.getPath());
		File file = new File(url.getPath()+File.separator+"datafile.txt");
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.length() == 0) {
					continue;
				}

				if (line.startsWith("!")) {
					if(startData){
						startData= false;
						instance.defresults.put(instance.frequency,instance.scatterMatrix);
						instance.scatterMatrix = new ArrayList<ArrayList<Complex>>();
					}
					instance.firstLine=true;
				//	System.out.println("comment section");
				} else if (line.startsWith("#")) {
					System.out.println("============");
					System.out.println("SCATTER DATA NUM: "+elab_num++);
					String enumStr = line.split(" ")[3];
					instance.complexFormat = COMPLEX_TYPE.valueOf(enumStr);
					System.out.println("format: "+instance.complexFormat);
				}else {
					startData = true;
					String[] lineNormal = line.split(" "); 
					ArrayList<String> lineUtil = Utils.removeSpacesElem(lineNormal);
					if(instance.firstLine){
						instance.firstLine =false;
						instance.frequency = Float.valueOf(lineUtil.get(0));
						System.out.println("frequency: "+instance.frequency);
						instance.portNumbers = (lineUtil.size()-1)/2;
						System.out.println("portNumbers: "+instance.portNumbers);
						lineUtil.remove(0);
					}
					ArrayList<Complex> complexLine = new ArrayList<Complex>();
					for(int idx = 0; idx <instance.portNumbers ; idx+=1){	
						complexLine.add( instance.getComplexNum(instance.complexFormat, Float.valueOf(lineUtil.get(2*idx)), Float.valueOf(lineUtil.get(2*idx+1))));	
					}
					instance.scatterMatrix.add(complexLine);
				}
				
			}
			instance.defresults.put(instance.frequency,instance.scatterMatrix);
			
			for(Map.Entry <Float,List<ArrayList<Complex>>> scatter : instance.defresults.entrySet()){
				
				System.out.println("FREQ:"+scatter.getKey());
				List<ArrayList<Complex>> scatterMatr = scatter.getValue();
				System.out.println(scatterMatr);
			
			//MASK
			List<ArrayList<Boolean>> buildMaskMatrix = Utils.buildMaskMatrix();
			System.out.println("--- mask matrix");
			System.out.println(buildMaskMatrix);
			System.out.println("--- apply mask matrix");
			scatterMatr = Utils.applyMask(scatterMatr,buildMaskMatrix);
			System.out.println(scatterMatr);
			HashMap<Integer, Integer> exchangeMap =Utils.getExchangeMap();
			System.out.println(exchangeMap);
			for (Map.Entry<Integer, Integer> exchange : exchangeMap.entrySet()){
				scatterMatr = Utils.exchangeRowColMatrix(scatterMatr, exchange.getKey(), exchange.getValue());				
			}
			System.out.println("==== REaRRANGE ");
			System.out.println(scatterMatr);
		}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public Complex getComplexNum (COMPLEX_TYPE type, float num1, float num2){
		
		if(type==COMPLEX_TYPE.RI){
			return new Complex (num1, num2);
		}else if(type==COMPLEX_TYPE.MA){
			return Complex.polar(num1, num2);
		}else if (type==COMPLEX_TYPE.DB){
			Double mod = Math.pow(10.0F, (num1/20.0F));
			return new Complex (mod, num2);
		}else {
			System.out.println("unknown complex format!");
		}
		return null;
	}
	
	
	
}
