package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MinPathSum {
	
	public static int [][] nums =null;
	public static int row =0;
	public static int size = 0;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	    File file = new File(args[0]);
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    String line;
	    while ((line = in.readLine()) != null) {
	    	
	    	if (!line.contains(",")){
	    		size = Integer.valueOf(line);
	    		nums = new int[size][size];
	    		row = 0;
	    	}else {
	    		if(row<=size){
	    			String[] numsInRow = line.split(",");
		    		for(int col =0;col<numsInRow.length;col++){
		    			nums[row][col] = Integer.valueOf(numsInRow[col]);
		    		}
		    		row++;
		    		if(row==size){
	    			//find min sum path
	    			System.out.println(""+minPathSum(nums));
	    		}
	    		}
	    		
	    	}
	       
	    }

	}

	
	public static int minPathSum(int[][] grid) {
        int[][] path = new int[grid.length][grid[0].length];
        path[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            path[i][0] = path[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
         path[0][j] = path[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++)
         for (int j = 1; j < grid[0].length; j++) {
         path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
         }
        return path[grid.length - 1][grid[0].length - 1];
    }
}
