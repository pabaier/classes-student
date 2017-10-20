/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Jonathan Rabiu
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
      int min = grid[0][0];
      for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
             if(grid[row][col]< min){
                 min = grid [row][col];
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
      for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
             if(grid[row][col]> max){
                 max = grid [row][col];
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
     int index = 0;
      for(int row=1; row < grid.length; row++){
          if(grid[row][col]< min){
              min = grid[row][col];
              index = row;
          }
     }
     return index;  
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
    int prevStepY = row; // row in grid of step one
    int elevationDelta = 0;
    
    // draw initial step - column 0, current row (sent in as parameter)
    g.fillRect(0,row,1,1);
    for(int column = 0; column < grid[0].length-1; column++){
        int prevStepVal = grid[prevStepY][column];
        if(prevStepY == 0){
            int topStepValue = grid[0][column+1];
            int bottomStepValue = grid[1][column+1];
            int topChange = Math.abs(topStepValue - prevStepVal);
            int bottomChange = Math.abs(bottomStepValue - prevStepVal);
            if(topChange < bottomChange){//if top change is less, go to top val
                prevStepY = 0;
                elevationDelta += topChange;
            }else if(bottomChange < topChange){//if bottom change is less, go to the bottom val
                prevStepY = 1;
                elevationDelta += bottomChange;
            }else if(topChange == bottomChange){//if topChange equals bottomChange, flip a coin
                if (Math.random() < .5) {
                    prevStepY = 0;
                    elevationDelta += topChange;
                }else{
                    prevStepY = 1;
                    elevationDelta += bottomChange;
                }
                    
            }
        }
        else if(prevStepY == grid.length - 1){
            int topStepValue = grid[prevStepY-1][column+1];
            int bottomStepValue = grid[prevStepY][column+1];
            int topChange = Math.abs(topStepValue - prevStepVal);
            int bottomChange = Math.abs(bottomStepValue - prevStepVal);
            if(topChange < bottomChange){//if top change is less, go to top val
                prevStepY = prevStepY-1;
                elevationDelta += topChange;
            }else if(bottomChange < topChange){//if bottom change is less, go to the bottom val
                prevStepY = prevStepY;
                elevationDelta += bottomChange;
            }else if(topChange == bottomChange){//
                if (Math.random() < .5) {
                    prevStepY = prevStepY-1;
                    elevationDelta += topChange;
                }else{
                    prevStepY = prevStepY;
                    elevationDelta += bottomChange;
                }
                    
            }
       }
        else{
            int topStepValue = grid[prevStepY+1][column+1];
            int middleStepValue = grid[prevStepY][column+1];
            int bottomStepValue = grid[prevStepY-1][column+1];
            int topChange = Math.abs(topStepValue - prevStepVal);
            int middleChange = Math.abs(middleStepValue - prevStepVal);
            int bottomChange = Math.abs(bottomStepValue - prevStepVal);
            //case 1: if all equal, go to the middle one
           
            if(topChange == bottomChange && middleChange == topChange && middleChange == bottomChange){//if all are equal, go to the middle
                prevStepY = prevStepY;
                elevationDelta += middleChange; 
            }else if(topChange < bottomChange && topChange < middleChange){//if top is less than bottom and top is less than middle, pick top
                prevStepY = prevStepY+1;
                elevationDelta += topChange;
            }else if(bottomChange < topChange && bottomChange < middleChange){// if bottom is less than top and middle, go to bottom
                prevStepY = prevStepY-1;
                elevationDelta += bottomChange;
            }else if(middleChange < topChange && middleChange < bottomChange){// if middle is less than top and bottom, go to middle
                prevStepY = prevStepY;
                elevationDelta += middleChange;  
            }else if(topChange == bottomChange && middleChange > topChange && middleChange > bottomChange){
                if (Math.random() < .5) {
                    prevStepY = prevStepY+1;
                    elevationDelta += topChange;
                }else{
                    prevStepY = prevStepY-1;
                    elevationDelta += bottomChange;
                }
            }else if(topChange == middleChange && bottomChange > topChange && bottomChange > middleChange){
                if (Math.random() < .5) {
                    prevStepY = prevStepY+1;
                    elevationDelta += topChange;
                }else{
                    prevStepY = prevStepY;
                    elevationDelta += middleChange;
                }
            }else if(middleChange == bottomChange && topChange > middleChange && topChange > bottomChange){
                if (Math.random() < .5){
                    prevStepY = prevStepY;
                    elevationDelta += middleChange;
                }else{
                    prevStepY = prevStepY-1;
                    elevationDelta += bottomChange;
                }
            }
       }
       g.fillRect(column+1, prevStepY, 1, 1);
        
     }
    
    return elevationDelta; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
     int lowest = drawLowestElevPath(g, 0);
     int index = 0;
     for(int row=1; row < grid.length; row++){
         int temp = drawLowestElevPath(g, row);
         if(temp < lowest){
             lowest = temp ;
             index = row;
        }
     }
     return index;
   }
}