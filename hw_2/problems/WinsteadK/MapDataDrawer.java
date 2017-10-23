/*
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Kyle Winstead
 * Due Date: October 06, 2016
 */

import java.util.*;
import java.io.*;
import java.awt.*;

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
	  int minimum = grid[0][0];
	  for (int row = 0; row<grid.length; row++) {
		  for (int col = 0; col<grid[0].length; col++) {
			  if (grid[row][col]<minimum){
				  minimum = grid[row][col];
			  }
		  }
	  }
	  return minimum;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
	  int max = grid[0][0];
	  for (int row = 0; row<grid.length; row++) {
		  for (int col = 0; col<grid[0].length; col++) {
			  if (grid[row][col]>max){
				  max = grid[row][col];
			  }
		  }
	  }
	  return max;
      //return Integer.MAX_VALUE; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int row){

	  int minimum = grid[0][0];
	  int minimumRow = 0;
      for (int i = 1; i < grid.length; i++){
    	  if (grid[i][row] < minimum){
    		  minimum = grid[i][row];
    		  minimumRow = i;
    	  }
      }
      return minimumRow; 
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
     int change = 0;
     int currY = row;
     int maximum = findMax();
     int up = -1;
     int x = 0;
     int down = -1;
     int forward = grid[currY][x+1]; 
     int currForward = Math.abs(grid[currY][x]-forward);
     int currUp = maximum + 1;
     int currDown = maximum+1;
     int smallestCh = currForward;
     
    for(x=0 ; x<grid[0].length -1; x++) {
    	//g.fillRect(0, row, 1, 1);
    	g.fillRect(x, currY, 1, 1);
    	
    	
    	if(currY != 0) {
    		up = grid[currY - 1][x+1];
    		}
    	if(row != grid.length - 1) {
    		down = grid[row+ 1][x +1];
    		}
    	if(up > -1) {
    		currUp = Math.abs(grid[currY][x] - forward);
    	}
    	if(down > -1){
    		currDown = Math.abs(grid[currY][x]-down);
    	}
    	 
    	if(currForward > currUp) {
    		if(currUp > currDown) {
    			smallestCh = currDown;
    			currY++;
    		}
    		else {
    			smallestCh = currUp;
    			currY--;
    		}
    	}
    	else {
    		if(currForward > currDown) {
    			smallestCh = currDown;
    			currY++;
    		}
    		else {
    			smallestCh = currForward;
    		}
    	}
    	change += smallestCh;
    
    }
    return change; 
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
	  int leastPath = drawLowestElevPath(g, 0);
	     int index = 0;
	    		 
		 for (int i = 0; i < grid.length; i++){
			 
	    	 if (grid[0][i] < leastPath){
	    		 leastPath = grid[0][i];
	    		 index = i;
	    	 }
	     }

		 return index;
	  
	  }
 
  
  
}