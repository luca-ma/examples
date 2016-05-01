package code_eval.moderate;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BlockFlyOver_verI_KO {



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
           
            //System.out.println(calcY(1, Float.valueOf(avArray[avArray.length-1]),Float.valueOf(streetsArray[streetsArray.length-1])));
            Integer numOfBlocks =0;
        //    Integer lastBl =0;
           int idx_av =0;
           int curr_av =0;
            for(int idx_str =1 ; idx_str < streetsArray.length ;idx_str++) {
                Boolean findFirstBlock = false;
                Float prevStrVal = calcY(Integer.valueOf(streetsArray[idx_str-1]), Float.valueOf(avArray[avArray.length-1]),Float.valueOf(streetsArray[streetsArray.length-1]));
                Float currStrVal = calcY(Integer.valueOf(streetsArray[idx_str]), Float.valueOf(avArray[avArray.length-1]),Float.valueOf(streetsArray[streetsArray.length-1]));
               // for(int idx_av =0 ; idx_av < avArray.length -1;idx_av++) {
                while(idx_av < avArray.length -1){
                    Float min = Float.valueOf(avArray[idx_av]);
                    Float max = Float.valueOf(avArray[idx_av+1]);
//                    if(((isInInterval(prevStrVal, min, max))&&(idx_str ==1))||
//                    ((isInInterval(currStrVal, min, max))&&(idx_str ==1))){
//                        numOfBlocks++;
//                        findFirstBlock = true;
//                    }else if(idx_str>1)
//                            if(currStrVal >=max)
//                                numOfBlocks++;
//                            else
//                                break;
                    if((min.equals(prevStrVal))&&(max.equals(currStrVal))){
                    	idx_av++;
                        numOfBlocks++;
                        break;
                    }
                    if((isInInterval(prevStrVal, min, max))||
                            ((isInInterval(currStrVal, min, max)))||
                            (min>prevStrVal && max<currStrVal)){
                                numOfBlocks++;
                                findFirstBlock = true;
                            }
                    if(min>currStrVal){
                    	idx_av--;
                    	break;
                    }else if (min.equals(currStrVal)){
                    	break;
                    }
                    idx_av++;
                }
                if(idx_av==(avArray.length -1))
                	idx_av--;
                System.out.println("bnumOfBlpar :"+numOfBlocks);
            }
            System.out.println("bnumOfBl:"+numOfBlocks);

        }
    }
   
   
    public static Float calcY(Integer x, Float lastY,  Float lastX ) {
       
       
        return  (lastY/lastX)* x;
    }
   
    public static Boolean isInInterval (Float val, Float min, Float max) {
        if((val>min)&&(val <=max))
            return true;
        else
            return false;
    }
}

