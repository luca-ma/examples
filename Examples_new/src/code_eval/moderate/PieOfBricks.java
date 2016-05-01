package code_eval.moderate;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class PieOfBricks {
 

	public static Integer hole_largh =0;
	public static Integer hole_high=0;
	public static TreeSet<Integer> bricksPass = new TreeSet<Integer> ();

    public static void main(String[] args) throws IOException {
       
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while ((line = in.readLine()) != null) {
            if(line.length()==0) {
                continue;
            }
            if(line.startsWith("#"))
                continue;
            
           //hole processing
            String[] holeCoords = line.split("\\|")[0].split(" ");
            hole_largh = Integer.valueOf(holeCoords[0].split(",")[0].substring(1)) -
             Integer.valueOf(holeCoords[1].split(",")[0].substring(1));
            if(hole_largh<0) hole_largh  = -hole_largh;
            
            hole_high = Integer.valueOf(holeCoords[0].split(",")[1].replaceFirst("]","")) -
                    Integer.valueOf(holeCoords[1].split(",")[1].replaceFirst("]",""));
            if(hole_high<0) hole_high  = -hole_high;
            //System.out.println("bnumOfBl:"+numOfBlocks);
           // System.out.println(hole_largh); 
            //System.out.println(hole_high); 
            
           //brick proc
            String[] brickArray = line.split("\\|")[1].split(";");  
            bricksPass.clear();
            
            for(int idx=0; idx < brickArray.length;idx++){
            	String[] brickEl = brickArray[idx].split(" ");
            	
            	Integer brick_largh = Integer.valueOf(brickEl[1].split(",")[0].substring(1)) -
                        Integer.valueOf(brickEl[2].split(",")[0].substring(1));
            	if(brick_largh<0) brick_largh =-brick_largh;
            	
            	Integer brick_high = Integer.valueOf(brickEl[1].split(",")[1]) -
                         Integer.valueOf(brickEl[2].split(",")[1]);
                 if(brick_high<0) brick_high  = -brick_high;
               //  System.out.println(brick_largh); 
                // System.out.println(brick_high); 
                 
                 if(((brick_largh<=hole_largh)&&(brick_high<=hole_high))||
                 ((brick_largh<=hole_high)&&(brick_high<=hole_largh)))
                 {
                	 bricksPass.add(Integer.valueOf(brickEl[0].substring(1)));
                 }
            }
           // System.out.println("-------------"); 
            printList(bricksPass); 
            //System.out.println("-------------"); 
        }
    }
   
   
    public static void printList(TreeSet<Integer> solSet){
    	StringBuilder outStr = new StringBuilder();
    	
    	for(Integer val: solSet){
    		outStr.append(val).append(",");
    	}
    	if(outStr.length()>0){
    		System.out.println(outStr.substring(0, outStr.length()-1));
    	}else {
    		System.out.println("-");
    	}
    		
    }
    
    
    public static Boolean isBlockPassed (Float s_min, Float s_max, Float av_min, Float av_max, Float ang_coeff) {
    	return false;
    	
    		
  }
}

