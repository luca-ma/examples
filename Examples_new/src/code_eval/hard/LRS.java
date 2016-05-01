package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LRS {


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
            System.out.println(line);
               
            String longRepSubStr = longestSubSeq(line);
            if(longRepSubStr.trim().length()==0) {
                System.out.println("NONE");
            }else {
                System.out.println(longRepSubStr);
            }
        }
    }
   
  
   
    public static String longestSubSeq(String inStr) {
        String longest = "";
        for (int i = 0; i < inStr.length() - 2 * longest.length() * 2; i++) {
            OUTER:
            for (int j = longest.length() + 1; j * 2 < inStr.length() - i; j++) {
                String find = inStr.substring(i, i + j);
                for (int k = i + j; k <= inStr.length() - j; k++) {
                    if (inStr.substring(k, k + j).equals(find)) {
                        longest = find;
                        continue OUTER;
                    }
                }
                break;
            }
        }
        return longest;
    }
}
