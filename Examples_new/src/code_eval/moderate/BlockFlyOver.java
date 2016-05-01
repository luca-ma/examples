package code_eval.moderate;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BlockFlyOver {
 


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
           
            String[] split = line.split(" ");
            String avStr = split[1].substring(1, split[1].length()-1);
            String streetsStr = split[0].substring(1, split[0].length()-1);
            //System.out.println(avStr);
            //System.out.println(streetsStr);
            
            String[] avArray = avStr.split(",");
            String[] streetsArray = streetsStr.split(",");
           
            Float ang_coeff = (Float.valueOf(avArray[avArray.length-1]))/(Float.valueOf(streetsArray[streetsArray.length-1]));
                    
            //System.out.println(calcY(1, Float.valueOf(avArray[avArray.length-1]),Float.valueOf(streetsArray[streetsArray.length-1])));
            Integer numOfBlocks =0;
        //    Integer lastBl =0;
           int curr_av =0;
            for(int idx_str =0 ; idx_str < streetsArray.length -1;idx_str++) {
            	
            	Float streetMin = Float.valueOf(streetsArray[idx_str]);
            	Float streetMax = Float.valueOf(streetsArray[idx_str+1]);
            	
                for(int idx_av =0 ; idx_av < avArray.length -1;idx_av++) {
                
                    Float av_min = Float.valueOf(avArray[idx_av]);
                    Float av_max = Float.valueOf(avArray[idx_av+1]);

                    if(isBlockPassed(streetMin, streetMax, av_min, av_max, ang_coeff)) {
                    	numOfBlocks++;
                    }
                    
                }
                
              //  System.out.println("bnumOfBlpartial :"+numOfBlocks);
            }
            //System.out.println("bnumOfBl:"+numOfBlocks);
            System.out.println(numOfBlocks); 

        }
    }
   
   

    
    public static Boolean isBlockPassed (Float s_min, Float s_max, Float av_min, Float av_max, Float ang_coeff) {
    	Integer numOfCheck =0;
    	if((((av_min/ang_coeff)>=s_min)&&((av_min/ang_coeff)<=s_max)) ||
    	  (((av_max/ang_coeff)>=s_min)&&((av_max/ang_coeff)<=s_max)))
    		numOfCheck++;	 
    	if ((((s_min*ang_coeff)>=av_min)&&((s_min*ang_coeff)<=av_max))||
    		(((s_max*ang_coeff)>=av_min)&&((s_max*ang_coeff)<=av_max)))
    		numOfCheck++;
    	
    	if ((av_min.equals(ang_coeff*s_max))||
    			(av_max.equals(ang_coeff*s_min)))
    		return false;
    	if(numOfCheck>=1) {
    		return true;
    	}else {
    		return false;
    	}
    		
  }
}

