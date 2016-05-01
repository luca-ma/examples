package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordSearch {


    public static StringBuilder spr = null;
   
    public static String [][] matr = {   { "A", "B", "C", "E"},
        { "S", "F", "C", "S" },
        { "A", "D", "E", "E" }
    };;
    public static String  word ="";

    public static void main(String[] args) throws IOException {
       
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while ((line = in.readLine()) != null) {
            if(line.length()==0) {
                continue;
            }
//            String[] split = line.split(";");
//            Integer m = Integer.valueOf(split[0]);
//            Integer n = Integer.valueOf(split[1]);
            //String[] matr_lin = split[2].split(" ");
            word = line.trim();
            Boolean fnd =false;
            for(int row =0; row <3; row++) {
                for(int col =0; col<4; col++) {
                    if(matr[row][col].equals(String.valueOf(line.charAt(0)))) {
                        if(findSeq(col, row, 0, String.valueOf(line.charAt(0)))) {
                            fnd  = true;
                            break;
                        }

                    }
                }
            }

            String out = "";
            if(fnd) {
                out = "True";
            }else {
                out = "False";
            }
            System.out.println(out);
        }
    }
   
    public static Boolean findSeq(Integer pos_x, Integer pos_y, Integer len, String partStr) {
    	//System.out.println(partStr);
    	try {
    		if (!matr[pos_x][pos_y].equals(String.valueOf(word.charAt(len)))) {
                return false;
            }
            if (len.equals(word.length()-1)) {
                return matr[pos_x][pos_y].equals(String.valueOf(word.charAt(len)));
            }
    	}catch (Exception exc) {
          //  exc.printStackTrace();
            return false;
        }
        len++;
        Boolean ret = false;
        try {
            for(Integer idx =-1 ; idx<2; idx++) {
                for(Integer idy =-1 ; idy<2; idy++) {
                    ret = ret ||findSeq(pos_x+idx,pos_y+idy,len,partStr+String.valueOf(word.charAt(len)));
                }
            }
            return ret;
        }catch (Exception exc) {
            exc.printStackTrace();
        }
        return true;
    }

}

