package code_eval.hard;

import static java.lang.Math.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Random;
import java.util.Set;

public class LevDistance {

	public static String ini_Str = "abcde";

    public static void main(String[] args) throws IOException {
       
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while ((line = in.readLine()) != null) {
            if(line.length()==0) {
                continue;
            }
            Double maxSs= 0.0;
            String[] namsProds = line.split(";");
            String[] names = namsProds[0].split(",");
            String[] prods = namsProds[1].split(",");
           // System.out.println("names len:"+names.length);
        
            
            
            }
           

    }
   
   
    public static int minimum(int a, int b, int c) {
    	return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(CharSequence str1,
    		CharSequence str2) {
    	int[][] distance = new int[str1.length() + 1][str2.length() + 1];

    	for (int i = 0; i <= str1.length(); i++)
    		distance[i][0] = i;
    	for (int j = 1; j <= str2.length(); j++)
    		distance[0][j] = j;

    	for (int i = 1; i <= str1.length(); i++)
    		for (int j = 1; j <= str2.length(); j++)
    			distance[i][j] = minimum(
    					distance[i - 1][j] + 1,
    					distance[i][j - 1] + 1,
    					distance[i - 1][j - 1]
    							+ ((str1.charAt(i - 1) == str2.charAt(j - 1)) ? 0
    									: 1));

    	return distance[str1.length()][str2.length()];
    }
}
