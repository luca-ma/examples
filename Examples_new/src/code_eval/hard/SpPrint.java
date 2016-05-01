package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SpPrint {


    public static StringBuilder spr = null;
   
    public static String [][] ini_matr = null;

    public static void main(String[] args) throws IOException {
       
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while ((line = in.readLine()) != null) {
            if(line.length()==0) {
                continue;
            }
            String[] split = line.split(";");
            Integer m = Integer.valueOf(split[0]);
            Integer n = Integer.valueOf(split[1]);
            String[] matr_lin = split[2].split(" ");
           
            int lin_idx=0;
            ini_matr = new String [m][n];
            for (int row =0; row <m; row++) {
                for (int col =0; col<n; col++) {
                    String val = matr_lin [lin_idx];
                    ini_matr[row][col] = val;
                    lin_idx++;
                }
            }
            spr =new StringBuilder();
            Boolean terminated = false;
            int x =0;
            while(!terminated) {
                if(!build_row_dx(x, x, n-1-x)) {
                    break;
                }
                if(!build_col_down(n-1-x, x+1, m-1-x)) {
                    break;
                }
                if(!build_row_sx(m-1-x, n-2-x, x)) {
                    break;
                }
                if(!build_col_up(x, m-2-x, x+1)) {
                    break;
                }
                x++;
            }
            System.out.println(spr.deleteCharAt(spr.length()-1));

        }
    }
   
    public static Boolean build_row_dx(Integer row, Integer start_idx, Integer end_idx) {
        if(start_idx>end_idx) {
            return false;
        }else {
            for(Integer col =start_idx; col <=end_idx; col++ ) {
                spr.append(ini_matr[row][col]).append(" ");
            }
        }
        return true;
    }
   
    public static Boolean build_col_down(Integer col, Integer start_idx, Integer end_idx) {
        if(start_idx>end_idx) {
            return false;
        }else {
            for(Integer row =start_idx; row <=end_idx; row++ ) {
                spr.append(ini_matr[row][col]).append(" ");
            }
        }
        return true;
    }
   
    public static Boolean build_row_sx(Integer row, Integer start_idx, Integer end_idx) {
        if(start_idx<end_idx) {
            return false;
        }else {
            for(Integer col =start_idx; col >=end_idx; col-- ) {
                spr.append(ini_matr[row][col]).append(" ");
            }
        }
        return true;
    }
    public static Boolean build_col_up(Integer col, Integer start_idx, Integer end_idx) {
        if(start_idx<end_idx) {
            return false;
        }else {
            for(Integer row =start_idx; row >=end_idx; row-- ) {
                spr.append(ini_matr[row][col]).append(" ");
            }
        }
        return true;
    }
}
