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

public class DiscOff {

	public static double[][] matrix = new double[3][3];

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
           // System.out.println("prods len:"+prods.length);
            //System.out.println("============");
            matrix = new double[names.length][prods.length];
            for(int name_idx =0; name_idx<names.length;name_idx++) {
            
            	Float sumSs =0.0F;
            	 
            		for(int prod_idx =0; prod_idx<prods.length;prod_idx++) {
            		Float tmpSs =0.0F;
                	//System.out.println("============");
                   
                    Integer namesWovels = numOfWovels(names[name_idx]);
                    if(isEvenLen(prods[prod_idx])) {
                        tmpSs = namesWovels*1.5F;
                    }else {
                        tmpSs = (float)(strNumOrChar(names[name_idx])-namesWovels);                   
                    }
                    int gcdThing = gcdThing(strNumOrChar(names[name_idx]),strNumOrChar(prods[prod_idx]));
                    if(gcdThing>1) {
                        tmpSs = tmpSs*1.5F;
                    }
                   matrix [name_idx][prod_idx] = tmpSs;
                   
                   // sumSs +=tmpSs;
                   // System.out.println("val:"+ tmpSs+", name:"+names[name_idx]+", prod:"+prods[prod_idx]);
                   // System.out.println("sum:"+ sumSs);
                    //System.out.println("============");
                       
                }
//            	if (sumSs>maxSs) {
//                    maxSs =sumSs;
//                }
            		//System.out.println("matr:"+ matrix.toString());
                //System.out.println("sum:"+ sumSs);
                //System.out.println("max:"+ maxSs);
                //System.out.println("============");
            }   
           
           // System.out.println(line);
            //System.out.println(maxSs);
            //System.out.println("matr:"+ Arrays.deepToString(matrix));
            DiscOff discOff = new DiscOff();
            HungarianAlgorithm hungarianAlgorithm = discOff.new HungarianAlgorithm();
            if (matrix.length > matrix[0].length)
       		{
       			//System.out.println("Array transposed (because rows>columns).\n");	//Cols must be >= Rows.
       			matrix = hungarianAlgorithm.transpose(matrix);
       		}
            int[][] computeAssignments = hungarianAlgorithm.hgAlgorithm(matrix, "max");
           // System.out.println("matr:"+ Arrays.deepToString(computeAssignments));
            //System.out.println("============ ===============");
            //System.out.println("============ ===============");
            //System.out.println("============ ===============");
            double sum =0.0;
            for(int idx=0;idx<computeAssignments.length;idx++){
            	int asc = computeAssignments[idx][0];
            	int ord = computeAssignments[idx][1];
            	sum+=matrix[asc][ord];
            	
            }
            NumberFormat df = DecimalFormat.getInstance();
            df.setMinimumFractionDigits(2);
            df.setMaximumFractionDigits(2);
            df.setRoundingMode(RoundingMode.DOWN);

            System.out.println(String.format(Locale.ENGLISH,"%.2f", sum));
 //           System.out.println(sum);
   //         System.out.println("============ ===============");
     //       System.out.println("============ ===============");
            
            
            }
           

    }
   
    public static Boolean isEvenLen(String str) {
        Integer strNumOrChar = strNumOrChar(str);
        return ((strNumOrChar%2)==0);

    }
   
    public static Integer strNumOrChar(String str) {
       
        Integer numOfL =0;
        //String strWSpaces = str.replaceAll(" ", "");
        for (int idx =0; idx < str.length();idx++) {
            char ch = str.charAt(idx);
            if(((ch >= 'a' && ch <= 'z') 
            		|| (ch >= 'A' && ch <= 'Z')))
            {
                numOfL++;
            }
               
        }
        //return strWSpaces.length();
      //  System.out.println(str+" numofLetters:"+numOfL);
        return numOfL;
    }
    public static Integer numOfWovels(String str) {
        Integer numOfW =0;
        for (int idx =0; idx < str.length();idx++) {
            char charAt = str.charAt(idx);
            if((charAt=='a')||(charAt=='e')||(charAt=='i')||(charAt=='o')||
                    (charAt=='u')||
                    (charAt=='y')||
                    (charAt=='A')||(charAt=='E')||(charAt=='I')||(charAt=='O')||
                    (charAt=='U')
                    ||(charAt=='Y')
                    ) {
                numOfW++;
            }
               
        }
//        System.out.println(str+" numofWov:"+numOfW);
        return numOfW;
   
    }
   
    private static int gcdThing(Integer a, Integer b) {
        BigInteger b1 = new BigInteger(""+a); // there's a better way to do this. I forget.
        BigInteger b2 = new BigInteger(""+b);
        BigInteger gcd = b1.gcd(b2);
 //       System.out.println(""+a+","+b+":,gcd:"+gcd.intValue());
        return gcd.intValue();
    }
   

    public class HungarianAlgorithm {

    	//********************************//
    	//METHODS FOR CONSOLE INPUT-OUTPUT//
    	//********************************//
    	
//    	public static int readInput(String prompt)	//Reads input,returns double.
//    	{
//    		Scanner in = new Scanner(System.in);
//    		System.out.print(prompt);
//    		int input = in.nextInt();
//    		return input;
//    	}
    	public void printTime(double time)	//Formats time output.
    	{
    		String timeElapsed = "";
    		int days = (int)floor(time)/(24 * 3600);
    		int hours = (int)floor(time%(24*3600))/(3600);
    		int minutes = (int)floor((time%3600)/60);
    		int seconds = (int)round(time%60);
    		
    		if (days > 0)
    			timeElapsed = Integer.toString(days) + "d:";
    		if (hours > 0)
    			timeElapsed = timeElapsed + Integer.toString(hours) + "h:";
    		if (minutes > 0)
    			timeElapsed = timeElapsed + Integer.toString(minutes) + "m:";
    		
    		timeElapsed = timeElapsed + Integer.toString(seconds) + "s";
    		System.out.print("\nTotal time required: " + timeElapsed + "\n\n");
    	}
    	
    	//*******************************************//
    	//METHODS THAT PERFORM ARRAY-PROCESSING TASKS//
    	//*******************************************//
    	
    	public void generateRandomArray	//Generates random 2-D array.
    	(double[][] array, String randomMethod)	
    	{
    		Random generator = new Random();
    		for (int i=0; i<array.length; i++)
    		{
    			for (int j=0; j<array[i].length; j++)
    			{
    				if (randomMethod.equals("random"))
    					{array[i][j] = generator.nextDouble();}
    				if (randomMethod.equals("gaussian"))
    				{
    						array[i][j] = generator.nextGaussian()/4;		//range length to 1.
    						if (array[i][j] > 0.5) {array[i][j] = 0.5;}		//eliminate outliers.
    						if (array[i][j] < -0.5) {array[i][j] = -0.5;}	//eliminate outliers.
    						array[i][j] = array[i][j] + 0.5;				//make elements positive.
    				}
    			}
    		}			
    	}
    	public  double findLargest		//Finds the largest element in a positive array.
    	(double[][] array)
    	//works for arrays where all values are >= 0.
    	{
    		double largest = 0;
    		for (int i=0; i<array.length; i++)
    		{
    			for (int j=0; j<array[i].length; j++)
    			{
    				if (array[i][j] > largest)
    				{
    					largest = array[i][j];
    				}
    			}
    		}
    			
    		return largest;
    	}
    	public double[][] transpose		//Transposes a double[][] array.
    	(double[][] array)	
    	{
    		double[][] transposedArray = new double[array[0].length][array.length];
    		for (int i=0; i<transposedArray.length; i++)
    		{
    			for (int j=0; j<transposedArray[i].length; j++)
    			{transposedArray[i][j] = array[j][i];}
    		}
    		return transposedArray;
    	}
    	public double[][] copyOf			//Copies all elements of an array to a new array.
    	(double[][] original)	
    	{
    		double[][] copy = new double[original.length][original[0].length];
    		for (int i=0; i<original.length; i++)
    		{
    			//Need to do it this way, otherwise it copies only memory location
    			System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
    		}
    		
    		return copy;
    	}
    	
    	//**********************************//
    	//METHODS OF THE HUNGARIAN ALGORITHM//
    	//**********************************//
    	
    	public int[][] hgAlgorithm (double[][] array, String sumType)
    	{
    		double[][] cost = copyOf(array);	//Create the cost matrix
    		
    		if (sumType.equalsIgnoreCase("max"))	//Then array is weight array. Must change to cost.
    		{
    			double maxWeight = findLargest(cost);
    			for (int i=0; i<cost.length; i++)		//Generate cost by subtracting.
    			{
    				for (int j=0; j<cost[i].length; j++)
    				{
    					cost [i][j] = (maxWeight - cost [i][j]);
    				}
    			}
    		}
    		double maxCost = findLargest(cost);		//Find largest cost matrix element (needed for step 6).
    		
    		int[][] mask = new int[cost.length][cost[0].length];	//The mask array.
    		int[] rowCover = new int[cost.length];					//The row covering vector.
    		int[] colCover = new int[cost[0].length];				//The column covering vector.
    		int[] zero_RC = new int[2];								//Position of last zero from Step 4.
    		int step = 1;											
    		boolean done = false;
    		while (done == false)	//main execution loop
    		{ 
    			switch (step)
    		    {
    				case 1:
    					step = hg_step1(step, cost);     
    		    	    break;
    		    	case 2:
    		    	    step = hg_step2(step, cost, mask, rowCover, colCover);
    					break;
    		    	case 3:
    		    	    step = hg_step3(step, mask, colCover);
    					break;
    		    	case 4:
    		    	    step = hg_step4(step, cost, mask, rowCover, colCover, zero_RC);
    					break;
    		    	case 5:
    					step = hg_step5(step, mask, rowCover, colCover, zero_RC);
    					break;
    		    	case 6:
    		    	   	step = hg_step6(step, cost, rowCover, colCover, maxCost);
    					break;
    		  	    case 7:
    		    	    done=true;
    		    	    break;
    		    }
    		}//end while
    		
    		int[][] assignment = new int[array.length][2];	//Create the returned array.
    		for (int i=0; i<mask.length; i++)
    		{
    			for (int j=0; j<mask[i].length; j++)
    			{
    				if (mask[i][j] == 1)
    				{
    					assignment[i][0] = i;
    					assignment[i][1] = j;
    				}
    			}
    		}
    		
    		//If you want to return the min or max sum, in your own main method
    		//instead of the assignment array, then use the following code:
    		/*
    		double sum = 0; 
    		for (int i=0; i<assignment.length; i++)
    		{
    			sum = sum + array[assignment[i][0]][assignment[i][1]];
    		}
    		return sum;
    		*/
    		//Of course you must also change the header of the method to:
    		//public static double hgAlgorithm (double[][] array, String sumType)
    		
    		return assignment;
    	}
    	public int hg_step1(int step, double[][] cost)
    	{
    		//What STEP 1 does:
    		//For each row of the cost matrix, find the smallest element
    		//and subtract it from from every other element in its row. 
    	    
    	   	double minval;
    	   	
    		for (int i=0; i<cost.length; i++)	
    	   	{									
    	   	    minval=cost[i][0];
    	   	    for (int j=0; j<cost[i].length; j++)	//1st inner loop finds min val in row.
    	   	    {
    	   	        if (minval>cost[i][j])
    	   	        {
    	   	            minval=cost[i][j];
    	   	        }
    			}
    			for (int j=0; j<cost[i].length; j++)	//2nd inner loop subtracts it.
    	   	    {
    	   	        cost[i][j]=cost[i][j]-minval;
    	   	    }
    		}
    	   			    
    		step=2;
    		return step;
    	}
    	public int hg_step2(int step, double[][] cost, int[][] mask, int[]rowCover, int[] colCover)
    	{
    		//What STEP 2 does:
    		//Marks uncovered zeros as starred and covers their row and column.
    		
    		for (int i=0; i<cost.length; i++)
    	    {
    	        for (int j=0; j<cost[i].length; j++)
    	        {
    	            if ((cost[i][j]==0) && (colCover[j]==0) && (rowCover[i]==0))
    	            {
    	                mask[i][j]=1;
    					colCover[j]=1;
    	                rowCover[i]=1;
    				}
    	        }
    	    }
    							
    		clearCovers(rowCover, colCover);	//Reset cover vectors.
    			    
    		step=3;
    		return step;
    	}
    	public int hg_step3(int step, int[][] mask, int[] colCover)
    	{
    		//What STEP 3 does:
    		//Cover columns of starred zeros. Check if all columns are covered.
    		
    		for (int i=0; i<mask.length; i++)	//Cover columns of starred zeros.
    	    {
    	        for (int j=0; j<mask[i].length; j++)
    	        {
    	            if (mask[i][j] == 1)
    	            {
    	                colCover[j]=1;
    				}
    	        }
    	    }
    	    
    		int count=0;						
    		for (int j=0; j<colCover.length; j++)	//Check if all columns are covered.
    	    {
    	        count=count+colCover[j];
    	    }
    		
    		if (count>=mask.length)	//Should be cost.length but ok, because mask has same dimensions.	
    	    {
    			step=7;
    		}
    	    else
    		{
    			step=4;
    		}
    	    	
    		return step;
    	}
    	public int hg_step4(int step, double[][] cost, int[][] mask, int[] rowCover, int[] colCover, int[] zero_RC)
    	{
    		//What STEP 4 does:
    		//Find an uncovered zero in cost and prime it (if none go to step 6). Check for star in same row:
    		//if yes, cover the row and uncover the star's column. Repeat until no uncovered zeros are left
    		//and go to step 6. If not, save location of primed zero and go to step 5.
    		
    		int[] row_col = new int[2];	//Holds row and col of uncovered zero.
    		boolean done = false;
    		while (done == false)
    		{
    			row_col = findUncoveredZero(row_col, cost, rowCover, colCover);
    			if (row_col[0] == -1)
    			{
    				done = true;
    				step = 6;
    			}
    			else
    			{
    				mask[row_col[0]][row_col[1]] = 2;	//Prime the found uncovered zero.
    				
    				boolean starInRow = false;
    				for (int j=0; j<mask[row_col[0]].length; j++)
    				{
    					if (mask[row_col[0]][j]==1)		//If there is a star in the same row...
    					{
    						starInRow = true;
    						row_col[1] = j;		//remember its column.
    					}
    				}
    							
    				if (starInRow==true)	
    				{
    					rowCover[row_col[0]] = 1;	//Cover the star's row.
    					colCover[row_col[1]] = 0;	//Uncover its column.
    				}
    				else
    				{
    					zero_RC[0] = row_col[0];	//Save row of primed zero.
    					zero_RC[1] = row_col[1];	//Save column of primed zero.
    					done = true;
    					step = 5;
    				}
    			}
    		}
    		
    		return step;
    	}
    	public int[] findUncoveredZero	//Aux 1 for hg_step4.
    	(int[] row_col, double[][] cost, int[] rowCover, int[] colCover)
    	{
    		row_col[0] = -1;	//Just a check value. Not a real index.
    		row_col[1] = 0;
    		
    		int i = 0; boolean done = false;
    		while (done == false)
    		{
    			int j = 0;
    			while (j < cost[i].length)
    			{
    				if (cost[i][j]==0 && rowCover[i]==0 && colCover[j]==0)
    				{
    					row_col[0] = i;
    					row_col[1] = j;
    					done = true;
    				}
    				j = j+1;
    			}//end inner while
    			i=i+1;
    			if (i >= cost.length)
    			{
    				done = true;
    			}
    		}//end outer while
    		
    		return row_col;
    	}
    	public int hg_step5(int step, int[][] mask, int[] rowCover, int[] colCover, int[] zero_RC)
    	{
    		//What STEP 5 does:	
    		//Construct series of alternating primes and stars. Start with prime from step 4.
    		//Take star in the same column. Next take prime in the same row as the star. Finish
    		//at a prime with no star in its column. Unstar all stars and star the primes of the
    		//series. Erasy any other primes. Reset covers. Go to step 3.
    		
    		int count = 0;												//Counts rows of the path matrix.
    		int[][] path = new int[(mask[0].length*mask.length)][2];	//Path matrix (stores row and col).
    		path[count][0] = zero_RC[0];								//Row of last prime.
    		path[count][1] = zero_RC[1];								//Column of last prime.
    		
    		boolean done = false;
    		while (done == false)
    		{ 
    			int r = findStarInCol(mask, path[count][1]);
    			if (r>=0)
    			{
    				count = count+1;
    				path[count][0] = r;					//Row of starred zero.
    				path[count][1] = path[count-1][1];	//Column of starred zero.
    			}
    			else
    			{
    				done = true;
    			}
    			
    			if (done == false)
    			{
    				int c = findPrimeInRow(mask, path[count][0]);
    				count = count+1;
    				path[count][0] = path [count-1][0];	//Row of primed zero.
    				path[count][1] = c;					//Col of primed zero.
    			}
    		}//end while
    		
    		convertPath(mask, path, count);
    		clearCovers(rowCover, colCover);
    		erasePrimes(mask);
    		
    		step = 3;
    		return step;
    		
    	}
    	public int findStarInCol			//Aux 1 for hg_step5.
    	(int[][] mask, int col)
    	{
    		int r=-1;	//Again this is a check value.
    		for (int i=0; i<mask.length; i++)
    		{
    			if (mask[i][col]==1)
    			{
    				r = i;
    			}
    		}
    				
    		return r;
    	}
    	public int findPrimeInRow		//Aux 2 for hg_step5.
    	(int[][] mask, int row)
    	{
    		int c = -1;
    		for (int j=0; j<mask[row].length; j++)
    		{
    			if (mask[row][j]==2)
    			{
    				c = j;
    			}
    		}
    		
    		return c;
    	}
    	public void convertPath			//Aux 3 for hg_step5.
    	(int[][] mask, int[][] path, int count)
    	{
    		for (int i=0; i<=count; i++)
    		{
    			if (mask[(path[i][0])][(path[i][1])]==1)
    			{
    				mask[(path[i][0])][(path[i][1])] = 0;
    			}
    			else
    			{
    				mask[(path[i][0])][(path[i][1])] = 1;
    			}
    		}
    	}
    	public void erasePrimes			//Aux 4 for hg_step5.
    	(int[][] mask)
    	{
    		for (int i=0; i<mask.length; i++)
    		{
    			for (int j=0; j<mask[i].length; j++)
    			{
    				if (mask[i][j]==2)
    				{
    					mask[i][j] = 0;
    				}
    			}
    		}
    	}
    	public void clearCovers			//Aux 5 for hg_step5 (and not only).
    	(int[] rowCover, int[] colCover)
    	{
    		for (int i=0; i<rowCover.length; i++)
    		{
    			rowCover[i] = 0;
    		}
    		for (int j=0; j<colCover.length; j++)
    		{
    			colCover[j] = 0;
    		}
    	}
    	public int hg_step6(int step, double[][] cost, int[] rowCover, int[] colCover, double maxCost)
    	{
    		//What STEP 6 does:
    		//Find smallest uncovered value in cost: a. Add it to every element of covered rows
    		//b. Subtract it from every element of uncovered columns. Go to step 4.
    		
    		double minval = findSmallest(cost, rowCover, colCover, maxCost);
    		
    		for (int i=0; i<rowCover.length; i++)
    		{
    			for (int j=0; j<colCover.length; j++)
    			{
    				if (rowCover[i]==1)
    				{
    					cost[i][j] = cost[i][j] + minval;
    				}
    				if (colCover[j]==0)
    				{
    					cost[i][j] = cost[i][j] - minval;
    				}
    			}
    		}
    			
    		step = 4;
    		return step;
    	}
    	public double findSmallest		//Aux 1 for hg_step6.
    	(double[][] cost, int[] rowCover, int[] colCover, double maxCost)
    	{
    		double minval = maxCost;				//There cannot be a larger cost than this.
    		for (int i=0; i<cost.length; i++)		//Now find the smallest uncovered value.
    		{
    			for (int j=0; j<cost[i].length; j++)
    			{
    				if (rowCover[i]==0 && colCover[j]==0 && (minval > cost[i][j]))
    				{
    					minval = cost[i][j];
    				}
    			}
    		}
    		
    		return minval;
    	}
    	
    	//***********//
    	//MAIN METHOD//
    	//***********//
//    	
//    	public static void main(String[] args) 
//    	{
//    		//Below enter "max" or "min" to find maximum sum or minimum sum assignment.
//    		String sumType = "max";		
//    				
//    		//Hard-coded example.
//    		//double[][] array =
//    		//{
//    		//		{1, 2, 3},
//    		//		{2, 4, 6},
//    		//		{3, 6, 9}
//    		//};
//    		
//    		//<UNCOMMENT> BELOW AND COMMENT BLOCK ABOVE TO USE A RANDOMLY GENERATED MATRIX
//    		int numOfRows = readInput("How many rows for the matrix? ");
//    		int numOfCols = readInput("How many columns for the matrix? ");
//    		double[][] array = new double[numOfRows][numOfCols];
//    		generateRandomArray(array, "random");	//All elements within [0,1].
//    		//</UNCOMMENT>
//    		
//    		if (array.length > array[0].length)
//    		{
//    			System.out.println("Array transposed (because rows>columns).\n");	//Cols must be >= Rows.
//    			array = transpose(array);
//    		}
//    				
//    		//<COMMENT> TO AVOID PRINTING THE MATRIX FOR WHICH THE ASSIGNMENT IS CALCULATED
//    		System.out.println("\n(Printing out only 2 decimals)\n");
//    		System.out.println("The matrix is:");
//    		for (int i=0; i<array.length; i++)
//    		{
//    			for (int j=0; j<array[i].length; j++)
//    				{System.out.printf("%.2f\t", array[i][j]);}
//    			System.out.println();
//    		}
//    		System.out.println();
//    		//</COMMENT>*/
//    		
//    		double startTime = System.nanoTime();	
//    		int[][] assignment = new int[array.length][2];
//    		assignment = hgAlgorithm(array, sumType);	//Call Hungarian algorithm.
//    		double endTime = System.nanoTime();
//    						
//    		System.out.println("The winning assignment (" + sumType + " sum) is:\n");	
//    		double sum = 0;
//    		for (int i=0; i<assignment.length; i++)
//    		{
//    			//<COMMENT> to avoid printing the elements that make up the assignment
//    			System.out.printf("array(%d,%d) = %.2f\n", (assignment[i][0]+1), (assignment[i][1]+1),
//    					array[assignment[i][0]][assignment[i][1]]);
//    			sum = sum + array[assignment[i][0]][assignment[i][1]];
//    			//</COMMENT>
//    		}
//    		
//    		System.out.printf("\nThe %s is: %.2f\n", sumType, sum);
//    		printTime((endTime - startTime)/1000000000.0);
//    		
//    	}
    }


}
