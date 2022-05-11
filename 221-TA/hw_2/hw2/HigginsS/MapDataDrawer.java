/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Steven Higgins
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
      int rows = grid.length;
      int cols = grid[0].length;
      int minVal = grid[0][0];
      for(int row = 0; row < rows; row++) {
          for(int col = 0; col < cols; col++) {
              if(grid[row][col] < minVal){
                  minVal = grid[row][col];
                }
            }
        }
  
      return minVal;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){      
      int rows = grid.length;
      int cols = grid[0].length;
      int maxVal = grid[0][0];
      for(int row = 0; row < rows; row++) {
          for(int col = 0; col < cols; col++) {
              if(grid[row][col] > maxVal){
                  maxVal = grid[row][col];
                }
            }
        }
  
      return maxVal;  
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public int indexOfMinRow(int col){
      int minRow = 0;
      int minVal = grid[0][col];
      for(int row = 1; row < 480; row++){
          if(minVal > grid[row][col]){
              minRow = row;
              minVal = grid[row][col];
            }
          else{
              minRow = minRow;
              minVal = minVal;
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
    
    
    int currY = row;
    // row in grid of step one
    // draw initial step - column 0, current row (sent in as parame
    // Code to compute next step
    int change = 0;
    int x = 0;
    Random rand = new Random();
    
    for(int col = 0; col < grid[0].length - 1; col++){
       //System.out.println(currY);
       g.fillRect(col, currY, 1, 1);
       int start = grid[row][0];
       
       int foward = 0;
       int up = 0;
       int down = 0;
       
       
       if(currY != 0){
           down = grid[currY - 1][col + 1];
        }
       if(currY != grid.length - 1 && currY < 480){
           up = grid[currY + 1][col + 1];
        }
       foward = grid[currY][col + 1];
       int fowardDiff = Math.abs(foward - start);
       int upDiff = Math.abs(up - start);
       int downDiff = Math.abs(down - start);
       if(upDiff < fowardDiff && upDiff < downDiff){
           change = change + upDiff;
           currY = currY + 1;    
        }
       else if(downDiff < fowardDiff && downDiff < upDiff){
           change = change + downDiff;
           currY = currY - 1;
        }
       else if(upDiff == downDiff && upDiff < fowardDiff){
           x = rand.nextInt(1);
           if(x == 0){
               currY = currY + 1;
            }
           else{
               currY = currY - 1;
            }           
        }
       else if((fowardDiff < upDiff && fowardDiff < downDiff) || fowardDiff == upDiff || fowardDiff == downDiff){
           change = change + fowardDiff;
           currY = currY;
        }
       

    // draw next step where x is currently column and currY is row in grid
    //int x = 0; // the value of x will be generated by a loop that goes through the
    // columns, but for now, need something to put in "paint" statement
    
    
    // computed change in elevation
    }
  return change;
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int lowElev = drawLowestElevPath(g, 0);
      int currRowElev = 0;
      int rowTO = 0;
      
      //System.out.println("grid lenth 88888888888888888888 " + grid.length);
      //System.out.println("grid 480 " + grid[479][480]);
      for(int row = 1; row < grid.length - 60; row++){
          
          currRowElev = drawLowestElevPath(g, row);
          if(lowElev > currRowElev){
              lowElev = currRowElev;
              rowTO = row;
          }
        }
       
      return rowTO; // row of path with lowest elevation
  
  }
  
  

}