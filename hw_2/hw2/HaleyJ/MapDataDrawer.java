/**
 * This program provides methods for the driver in order to determine the "path of least resistance"
 * through the Rocky Mountains of Colorado, given elevation data from NOAA.

 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * John C Haley
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.Random;

public class MapDataDrawer
{
  // store map data in grid array
  private int[][] grid; 
  
  // Read 2D array into grid. Data in file "filename", grid is rows x cols
   public MapDataDrawer(String filename, int rows, int cols) throws Exception{
      // initialize grid 
      grid = new int[rows][cols];
      //read the data from the file into the grid
      Scanner S = new Scanner(new File(filename));    
      
       for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
             grid[row][col] = S.nextInt(); 
          }
       }
      
  }

  
  /**
   * @return the min value in the entire grid
   */
  public int findMin(){
   int min = 0;
   int row = 0;
      //System.out.print(grid[0][0]);
      //new int[rows][cols];
   min = grid[0][0];
   for (int col=0; col<844; col++){
       for(row = 0; row<480; row++){
           if (grid[row][col] < min){
              min = grid[row][col];
            }  
      
    }
}

    return min;
}
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int max = 0;
      int row = 0;
      //System.out.print(grid[0][0]);
      //new int[rows][cols];
      max = grid[0][0];
      for (int col=0; col<844; col++){
          for(row = 0; row<480; row++){
              if (grid[row][col] > max){
              max = grid[row][col];
            }  
      
    }
}
System.out.println("Max: " + max + ". ");
    return max;
} 
  
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int rowMin = grid[0][col];
      int rowIndex = 0;
      for (int row = 0; row< 480; row++){
          if(rowMin > grid[row][col]){
              rowMin = grid[row][col];
              rowIndex=row;
            }
        }
      return rowIndex;  
  }
  
  
  /**
   * DON'T CHANGE THIS CODE
   * Draws the grid using the given Graphics object. 
   * Colors should be grayscale values 0-255, scaled based on min/max values in grid
   * 
   * ALERT:Until your findMin and findMax methods work, your output will
   * be a completely black graph.
   */
  public void drawMap(Graphics g){
      
    int minVal = findMin();
    int maxVal = findMax();
    double range = maxVal - minVal;
    
    for(int row=0; row < grid.length; row++){
      for(int col=0; col<grid[0].length; col++){
         int val = (int)(((grid[row][col]-minVal)/range) * 255);
         //g.setColor(new Color(val,255-val,255-val));
         g.setColor(new Color(val,val,val));
         g.fillRect(col,row,1,1);
        }
    }      
  }
  

   /**
   * Find a path from West-to-East starting at given row.
   * Choose a foward step out of 3 possible forward locations, using greedy method described in assignment.
   * @return the total change in elevation traveled from West-to-East
   */
  public int drawLowestElevPath(Graphics g, int row){
      int max = 844;
      int totChange = 0;
      for (int i = 0; i < grid[0].length - 1; i++){
	  g.fillRect(i, row, 1, 1);
	  int fwd = grid[row][i + 1];
	  int up=0;
	  int down=0;
	  
	  if (row != 0){
		  up = grid[row - 1][i + 1];
	  }
	  
	  if (row != grid.length - 1){
		  down = grid[row + 1][i + 1];
	  }
	  
	  int currSt = Math.abs(grid[row][i] - fwd);
	  int currUp=0;
	  int currDn=0;
	  if (up > -1){
		  currUp = Math.abs(grid[row][i] - up);
	  }
	  if (down > -1){
		  currDn = Math.abs(grid[row][i] - down);
	  }
	  	  
	  int min = currSt;
	  
	  if (currSt > currUp){
		  if (currUp > currDn){
			  min = currDn;
			  row++;
		  }
		  else{
			  min = currUp;
			  row--;
		  }
	  }
	  else{
		  if (currSt > currDn){
			  min = currDn;
			  row++;
		  }
		  else{
			  min = currSt;
		  }
	  }
	  
	  totChange += min;
	  
  }
  
  return totChange;
}




    
// draw next step where x is currently column and currY is row in grid

    
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
     int min = drawLowestElevPath(g, 0);
     int index = 0;	 
	 for (int i = 1; i < grid.length; i++){
		 int dif = drawLowestElevPath(g, i);
    	 if (dif < min){
    		 min = dif;
    		 index = i;
    	 }
     }

	 return index;
  
  }
  
  
}