/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * Corey Taylor
 *
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import java.lang.Math;

public class MapDataDrawer
{
  // store map data in grid array
  public int[][] grid;
  
  // Read 2D array into grid. Data in file "filename", grid is rows x cols
  
   public MapDataDrawer(String filename, int rows, int cols) throws Exception{
      // initialize grid 
      grid = new int[rows][cols];
      //read the data from the file into the grid
      Scanner S = new Scanner(new File("Colorado_844x480.dat"));    
      
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
        for(int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c]<min){
                    min = grid[r][c];
                }
            }
        }

      return min;
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
        int max = grid[0][0];
        for (int r = 0; r<grid.length; r++){
            for(int c = 0; c<grid[0].length; c++){
                if(grid[r][c]>max){
                    max = grid[r][c];
                }
            }
        }
      return max;
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int min = grid[0][col];
      int minRow = 0;
      for(int r = 1; r<grid.length; r++){
          if(grid[r][col]<min){
              min = grid[r][col];
              minRow = r;
          }
      }
      return minRow;
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
    int currY = row; // row in grid of step one;
    int totalChange = 0;
    int max = findMax();
    int fwdAndUpDiff = max + 1;
    int fwdAndDownDiff = max + 1;

    g.fillRect(0,row,1,1);
    
    // Code to compute next step
    for(int p = 0; p < grid[0].length - 1; p++) {

        g.fillRect(p,currY,1,1);
         int fwd = grid[currY][p+1], fwdAndUp = -1, fwdAndDown = -1;
         int fwdDiff = Math.abs(grid[currY][p] - fwd);
         int least = fwdDiff;
        if(currY != 0){
            fwdAndUp = grid[currY - 1][p + 1];
        }
        if(currY != grid.length - 1){
            fwdAndDown = grid[currY + 1][p + 1];
        }
        if(fwdAndUp > -1){
            fwdAndUpDiff = Math.abs(grid[currY][p] - fwdAndUp);
        }
        if(fwdDiff > fwdAndUpDiff){
            if(fwdAndUpDiff > fwdAndDownDiff){
                least = fwdAndDownDiff;
                currY++;
            }
            else{
                least = fwdAndUpDiff;
                currY--;
            }
        }
        else{
            if(fwdDiff > fwdAndDownDiff){
                least = fwdAndDownDiff;
                currY++;
            }
            else{
                least = fwdDiff;
            }
        }
     totalChange += least;
    }
    
    return totalChange; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
    int least = drawLowestElevPath(g, 0);
    int index = 0;
        for(int i = 1; i<grid.length; i++){
            int change = drawLowestElevPath(g,i);
            if(change < least){
                least = change;
                index = i;
            }
        }
      return index; // row of path with lowest elevation
  
  }
  
  
}