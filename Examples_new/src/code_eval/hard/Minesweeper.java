package code_eval.hard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Minesweeper {

    /**
     * 722
     * @param args
     */
    public static final String  MINE ="*";
    
    public static String[][] oriMines= null;
    public static String[][] valueMines= null;
    public static String minesInLine ="";
    public static Integer row =0;
    public static Integer col =0;
   
    public static void main(String[] args) throws IOException {
        Minesweeper inst  =new Minesweeper();
        //visited_Points.add(inst.new Point(0,0));
       
        File file = new File(args[0]);
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;

		while ((line = in.readLine()) != null) {
			if(line.length()==0) {
				continue;
			}
			String[] split = line.split(";");
			minesInLine = split[1];
			String[] dim = split[0].split(",");
			row = Integer.valueOf(dim[0]);
			col = Integer.valueOf(dim[1]);
			oriMines =new String[row][col];
			valueMines =new String[row][col];
			
			buildOriMines();
			
			for(int r =0 ;r<row;r++){
				for(int c =0 ;c<col;c++){
					if(oriMines[r][c].equals(String.valueOf(MINE))){
						valueMines[r][c] = String.valueOf(MINE);
					}else{
						valueMines[r][c] =String.valueOf(numOfMinesInNeigh(r,c));
					}
				}	
			}
			
			System.out.println(strinfyMatr(valueMines));
		}
	
    }
    
    private static void buildOriMines(){
    	for(int r =0 ;r<row;r++){
			for(int c =0 ;c<col;c++){
				oriMines[r][c] = String.valueOf(minesInLine.charAt(c+col*r));
			}
    	}
    }
   
    private static Integer numOfMinesInNeigh(int r, int c) {
		
    	Integer sumOfMines=0;
    	for(int x =-1;x<2;x++){
    		for(int y=-1;y<2;y++){
    			if((x==0)&&(y==0)){
    				continue;
    			}
    			Integer currAsc =r+x;
    			Integer currOr = c+y;
    			if((currAsc>=0)&&(currOr>=0)
    				&&(currAsc<row)&&(currOr<col)){
    				if (oriMines[currAsc][c+y].equals(String.valueOf(MINE))){
        				sumOfMines++;
        			}
    			}
    			
    		}
    	}
    	
		return sumOfMines;
	}

	private static String strinfyMatr (String[][] valueMines){
		String ret ="";
		
		for(int r =0 ;r<row;r++){
			for(int c =0 ;c<col;c++){
				ret+=valueMines[r][c];
			}
		}
		return ret;
	}

}


