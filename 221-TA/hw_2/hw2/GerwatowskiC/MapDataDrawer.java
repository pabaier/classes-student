/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Claire Gerwatowski
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import  java.util.Random;

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
      int min = grid[0][0];
      for (int i = 1; i < grid.length; i++) {
          for (int j = 0; j < grid[i].length; j++) {
              if (grid[i][j] < min) 
                min = grid[i][j];
            }   
        }
      return min;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int max = grid[0][0];
      for (int i = 1; i < grid.length; i++) {
          for (int j = 0; j < grid[i].length; j++) {
              if (grid[i][j] > max) 
                max = grid[i][j];
            }   
        }
      return max; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int lowestVal = grid[0][col];
      int indexLow = 0;
      for (int i = 0; i < 480; i++) {
          if (grid[i][col]<lowestVal) {
             lowestVal = grid[i][col];
             indexLow = i;
            }
        }
      return indexLow;
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
    int currY = row; // row in grid of step one
    // draw initial step - column 0, current row (sent in as parameter)
    g.fillRect(0,row,1,1);
    
    // Code to compute next step
    int totalChange = 0;
    
        for (int i = 0; i < grid[0].length-1; i++){
            if (currY == 0){
                int downFwd = grid[currY+1][i+1];
                int fwd = grid[currY][i+1];
                
                int changeDown = Math.abs(downFwd - grid[currY][i]);
                int changeFwd =  Math.abs(fwd - grid[currY][i]);
                if (changeFwd <= changeDown){
                    totalChange += changeFwd;
                }
                else {
                    totalChange += changeDown;
                    currY += 1;
                }
            }
            
    
            else if (currY >= grid[0].length-1){
                int upFwd = grid[currY-1][i+1];
                int fwd = grid[currY][i+1];
                
                int changeUp = Math.abs(upFwd - grid[currY][i]);
                int changeFwd =  Math.abs(fwd - grid[currY][i]);
                
                if (changeFwd <= changeUp){
                    totalChange += changeFwd;
                }
                
                else {
                    totalChange += changeUp;
                    currY -= 1;
                }
            }
        
            else {
                
                int upFwd = grid[currY-1][i+1];
                int downFwd = grid[currY+1][i+1];
                int fwd = grid[currY][i+1];
                
                int changeUp = Math.abs(upFwd - grid[currY][i]);
                int changeDown = Math.abs(downFwd - grid[currY][i]);
                int changeFwd =  Math.abs(fwd - grid[currY][i]);
                if (changeFwd <= changeDown && changeFwd <= changeUp){
                    totalChange += changeFwd;
                }
                else if (changeDown < changeFwd && changeDown < changeUp) {
                    totalChange += changeDown;
                    currY += 1;
                }
                else if (changeUp < changeDown && changeUp < changeFwd) {
                    totalChange += changeUp;
                    currY -= 1;
                }
                else {
                    Random rand = new Random();
                    int flip = rand.nextInt(2);
                    if (flip == 0) {
                        totalChange += changeUp;
                        currY -= 1;
                        
                    }
                    else {
                        totalChange += changeDown;
                        currY += 1;
                    }
                }
            }
            g.fillRect(i,currY,1,1);
    }
    // draw next step where x is current column and currY is row in grid
     // the value of x will be generated by a loop that goes through the
    // columns, but for now, need something to put in "paint" statement

    
    return totalChange; // computed change in elevation
  }

  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int minChange = drawLowestElevPath(g,0);
      int minChangeI = 0;
      for (int j = 0; j < 476; j++) {
          int change = drawLowestElevPath(g,j);
          if (change < minChange){
              minChange = change;
              minChangeI = j;
            }
          
        }
      return minChangeI; // row of path with lowest elevation
  
  }
  
  
}