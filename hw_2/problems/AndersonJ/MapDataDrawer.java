/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Jonathan E. Anderson
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
      int absMinVal;
      absMinVal = grid[0][0]; //sets the to the first element to then compare all other elements

      for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++) { // loop through all rows and columns
              if (grid[row][col] < absMinVal) { // compares current element to current absMinVal
                  absMinVal = grid[row][col]; // if the current values is lower than absMinVal update absMinVal
              }
          }
      }
  
      return absMinVal;
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int absMaxVal;
      absMaxVal = grid[0][0]; //set the max val to the first element in the array

      for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++) {
              if (grid[row][col] > absMaxVal) { // compare current element to the current max value
                  absMaxVal = grid[row][col]; // if the current element is larger, update absMaxVal
              }
          }
      }


      return absMaxVal;
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int minInCol;
      int minRow = 0;
      minInCol = grid[0][col]; // set the min to the first element in the column

      for(int row=0; row < grid.length; row++){ // only need to loop throw the rows b/c we are explicitly told to search only column col
              if (grid[row][col] < minInCol) { // compare the current element to the current min
                  minInCol = grid[row][col]; // if the current element is smaller than the min update min
                  minRow = row;
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
  public int drawLowestElevPath(Graphics g, int row) {
      int currY = row; // row in grid of step one
      // these three variables will host the absolute value of the difference between the current element, and the element...
      int forwUp; //in the next column row above
      int forw; // in the next column same row
      int forwDown; // in the next column row below
      // draw initial step - column 0, current row (sent in as parameter)
      g.fillRect(0, row, 1, 1);
      // Code to compute next step
      for (int i = 0; i < grid[0].length; i++) {
          if (i + 1 < grid[0].length && currY + 1 < grid.length && currY - 1 >= 0) { //all of this is to avoid an array index exception
              forwDown = Math.abs(grid[currY][i] - grid[currY + 1][i + 1]); // these calculate the difference i elevation of the next three possible steps
              forw = Math.abs(grid[currY][i] - grid[currY][i + 1]);
              forwUp = Math.abs(grid[currY][i] - grid[currY - 1][i + 1]);
              if (forwUp < forw) { // this handles which step to take.
                  if (forwUp < forwDown) {
                      currY = currY - 1;
                  } else {
                      currY = currY + 1;
                  }
              } else if (forw < forwDown) {
                  currY = currY;
              } else {
                  currY = currY + 1;
              }
          } else if (currY - 1 < 0) { // this code deals with the rows that would create a index exception
              forwDown = Math.abs(grid[currY][i] - grid[currY + 1][i + 1]);
              forw = Math.abs(grid[currY][i] - grid[currY][i + 1]);
              if (forw < forwDown) {
                  currY =currY;
              } else {
                  currY = currY + 1;
              }
          }
          // draw next step where x is currently column and currY is row in grid
          int x = 0; // the value of x will be generated by a loop that goes through the
          // columns, but for now, need something to put in "paint" statement
          x = i;
          g.fillRect(x, currY, 1, 1);


      }
      int elevChange = Math.abs(grid[currY][grid[0].length -1] - grid[row][0]);
      return elevChange; // computed change in elevation

  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g) {
      int lastElevChage = 2000000000;
      int curElevChange;
      int rowOSEC =0; // rowOSEC = Row Of Smallest Elevation Change
      for (int i = 0; i < grid.length; i++) {
          curElevChange = drawLowestElevPath(g, i);
          if(curElevChange < lastElevChage) {
              rowOSEC = i;
          }
          lastElevChage = curElevChange;
      }
      return rowOSEC; // row of path with lowest elevation
  }
}