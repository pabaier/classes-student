/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Jacob Mattox 
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
      int minValue = grid[0][0]; 
      for(int row = 0; row < grid.length; row++){
          for(int col = 0; col < grid[0].length; col++){
              if(grid[row][col] < minValue)
                minValue = grid[row][col];
            }
        } 
      return minValue;  //searches for and returns minimum value in the grid
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int maxValue = grid[0][0];
      for(int row = 0; row < grid.length; row++){
          for(int col = 0; col < grid[0].length; col++){
              if(grid[row][col] > maxValue)
                maxValue = grid[row][col];
            }
        }
      return maxValue; //searches for and returns the maximum value in the grid
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int lowestValueInRow = grid[0][col];
      int indexOfRow = 0;
      for(int row = 0; row < grid.length; row++){
          if(grid[row][col] < lowestValueInRow){
              lowestValueInRow = grid[row][col];
              indexOfRow = row;
            }
        }
      return indexOfRow;  //searches for and returns the index of the lowest value in the first row (row = 0)
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
    int currY = row; // row in grid of step one :
    // draw initial step - column 0, current row (sent in as parameter)
    g.fillRect(0,row,1,1);
    int changeInElev = 0;
    for(int i = 1; i < grid[0].length; i++){ //iterates through all columns in the given row finding the path of least elevation change and moving foward
       if(currY != 0 && currY != (grid.length - 1)){ //if not the very top or very bottom value
           
           if(Math.abs(grid[currY][i - 1] - grid[currY][i]) <= Math.abs(grid[currY][i - 1] - grid[currY - 1][i]) && //if the forward position is smallest, move foward 
                Math.abs(grid[currY][i - 1] - grid[currY][i]) <=Math.abs(grid[currY][i - 1] - grid[currY + 1][i])){
                currY = currY;
                changeInElev = changeInElev + Math.abs(grid[currY][i] - grid[currY][i - 1]);
           }
           else if(Math.abs(grid[currY][i - 1] - grid[currY - 1][i]) < Math.abs(grid[currY][i - 1] - grid[currY + 1][i])){ //moves forward and up
                changeInElev = changeInElev + Math.abs(grid[currY - 1][i] - grid[currY][i - 1]);
                currY = currY - 1;
           }
           else if(Math.abs(grid[currY][i - 1] - grid[currY + 1][i]) < Math.abs(grid[currY][i - 1] - grid[currY - 1][i])){ //moves forward and down
                changeInElev = changeInElev + Math.abs(grid[currY + 1][i] - grid[currY][i - 1]);
                currY = currY + 1;
           }
           else if(Math.abs(grid[currY][i - 1] - grid[currY - 1][i]) == Math.abs(grid[currY][i - 1] - grid[currY + 1][i])){ //if up and down are equal randomly chooses one
                if(Math.random() > .5){
                    changeInElev = changeInElev + Math.abs(grid[currY + 1][i] - grid[currY][i - 1]);
                    currY = currY + 1;
                }
                else{
                    changeInElev = changeInElev + Math.abs(grid[currY - 1][i] - grid[currY][i - 1]);
                    currY = currY - 1;
                }
           }
       }
       else if(currY == 0){ //handles the top of the map
           if(Math.abs(grid[currY][i - 1] - grid[currY][i]) <= Math.abs(grid[currY][i - 1] - grid[currY + 1][i])){
               currY = currY;
               changeInElev = changeInElev + Math.abs(grid[currY][i] - grid[currY][i - 1]);
           }
            else if(Math.abs(grid[currY][i - 1] - grid[currY + 1][i]) < Math.abs(grid[currY][i - 1] - grid[currY][i])){
               changeInElev = changeInElev + Math.abs(grid[currY + 1][i] - grid[currY][i - 1]);
               currY = currY + 1;
           } 
       }
       else if(currY == grid.length -1){ //handles the bottom of the map
           if(Math.abs(grid[currY][i - 1] - grid[currY][i]) <= Math.abs(grid[currY][i - 1] - grid[currY - 1][i])){
               currY = currY;
               changeInElev = changeInElev + Math.abs(grid[currY][i] - grid[currY][i - 1]);
            }
            else if(Math.abs(grid[currY][i - 1] - grid[currY - 1][i]) < Math.abs(grid[currY][i - 1] - grid[currY][i])){
               changeInElev = changeInElev + Math.abs(grid[currY - 1][i] - grid[currY][i - 1]);
               currY = currY - 1;
            }
       }
    // draw next step where x is currently column and currY is row in grid
    // the value of x will be generated by a loop that goes through the
    // columns, but for now, need something to put in "paint" statement
    g.fillRect(i,currY,1,1); //draws line in map
    }
    return changeInElev; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int currY;
      int changeInElev;
      int lowestElev = 500000;
      int bestRow = 0;
      for(int row = 0; row < grid.length; row++){
          currY = row;
          changeInElev = 0;
        for(int i = 1; i < grid[0].length; i++){
           if(currY != 0 && currY != (grid.length - 1)){
               
               if(Math.abs(grid[currY][i - 1] - grid[currY][i]) <= Math.abs(grid[currY][i - 1] - grid[currY - 1][i]) && //if the forward position is smallest, move foward 
                Math.abs(grid[currY][i - 1] - grid[currY][i]) <=Math.abs(grid[currY][i - 1] - grid[currY + 1][i])){
                currY = currY;
                changeInElev = changeInElev + Math.abs(grid[currY][i] - grid[currY][i - 1]);
           }
           else if(Math.abs(grid[currY][i - 1] - grid[currY - 1][i]) < Math.abs(grid[currY][i - 1] - grid[currY + 1][i])){ //moves forward and up
                changeInElev = changeInElev + Math.abs(grid[currY - 1][i] - grid[currY][i - 1]);
                currY = currY - 1;
           }
           else if(Math.abs(grid[currY][i - 1] - grid[currY + 1][i]) < Math.abs(grid[currY][i - 1] - grid[currY - 1][i])){ //moves forward and down
                changeInElev = changeInElev + Math.abs(grid[currY + 1][i] - grid[currY][i - 1]);
                currY = currY + 1;
           }
           else if(Math.abs(grid[currY][i - 1] - grid[currY - 1][i]) == Math.abs(grid[currY][i - 1] - grid[currY + 1][i])){ //if up and down are equal randomly chooses one
                if(Math.random() > .5){
                    changeInElev = changeInElev + Math.abs(grid[currY + 1][i] - grid[currY][i - 1]);
                    currY = currY + 1;
                }
                else{
                    changeInElev = changeInElev + Math.abs(grid[currY - 1][i] - grid[currY][i - 1]);
                    currY = currY - 1;
                }
           }
       }
       else if(currY == 0){ //handles the top of the map
           if(Math.abs(grid[currY][i - 1] - grid[currY][i]) <= Math.abs(grid[currY][i - 1] - grid[currY + 1][i])){
               currY = currY;
               changeInElev = changeInElev + Math.abs(grid[currY][i] - grid[currY][i - 1]);
           }
            else if(Math.abs(grid[currY][i - 1] - grid[currY + 1][i]) < Math.abs(grid[currY][i - 1] - grid[currY][i])){
               changeInElev = changeInElev + Math.abs(grid[currY + 1][i] - grid[currY][i - 1]);
               currY = currY + 1;
           } 
       }
       else if(currY == grid.length -1){ //handles the bottom of the map
           if(Math.abs(grid[currY][i - 1] - grid[currY][i]) <= Math.abs(grid[currY][i - 1] - grid[currY - 1][i])){
               currY = currY;
               changeInElev = changeInElev + Math.abs(grid[currY][i] - grid[currY][i - 1]);
            }
            else if(Math.abs(grid[currY][i - 1] - grid[currY - 1][i]) < Math.abs(grid[currY][i - 1] - grid[currY][i])){
               changeInElev = changeInElev + Math.abs(grid[currY - 1][i] - grid[currY][i - 1]);
               currY = currY - 1;
            }
        }
        g.fillRect(i,currY,1,1);
    }
    if(changeInElev < lowestElev){
        bestRow = row;
        lowestElev = changeInElev;
    }
}
     
      return bestRow; // row of path with lowest elevation
  
  }
  
  
}