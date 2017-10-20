/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Mark Hodges
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;

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
      int lowestVal = grid[0][0];
      for(int row=0; row < grid.length; row++){
         for(int col=0; col<grid[0].length; col++){
             if (grid[row][col] < lowestVal){
                 lowestVal = grid[row][col];
             }
         }
      }      
      return lowestVal;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int greatestVal = grid[0][0];
      for(int row=0; row < grid.length; row++){
         for(int col=0; col<grid[0].length; col++){
             if (grid[row][col] > greatestVal){
                 greatestVal = grid[row][col];
             }
         }
      }  
      return greatestVal; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int i;
      int rowNumber = 0;
      int smallVal = grid[0][col];
      for (i = 0; i < grid.length; i++) {
          if (grid[i][col] < smallVal){
              smallVal = grid[i][col];
              rowNumber = i;
          }
      }
      return rowNumber;  
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
    int elevChange = 0;
    int i;
    Random coin = new Random();
    // Code to compute next step
    for (i = 1; i < 844; i++){
        int hDiff1 = 10000;
        int hDiff2 = 10000;
        int hDiff3 = 10000;
        if (currY == 0){
            int opt2 = grid[currY][i];
            int opt3 = grid[currY + 1][i];
            hDiff2 = Math.abs(opt2 - grid[currY][i - 1]);
            hDiff3 = Math.abs(opt3 - grid[currY][i - 1]);
        }
        else if (currY >= (grid.length - 1)){
            int opt1 = grid[currY - 1][i];
            int opt2 = grid[currY][i];
            hDiff1 = Math.abs(opt1 - grid[currY][i - 1]);
            hDiff2 = Math.abs(opt2 - grid[currY][i - 1]);
        }
        else {
            int opt1 = grid[currY - 1][i];
            int opt2 = grid[currY][i];
            int opt3 = grid[currY + 1][i];
            hDiff1 = Math.abs(opt1 - grid[currY][i - 1]);
            hDiff2 = Math.abs(opt2 - grid[currY][i - 1]);
            hDiff3 = Math.abs(opt3 - grid[currY][i - 1]);
        }
        if ((hDiff1 < hDiff2) && (hDiff1 < hDiff3)) {
            currY -= 1;
            elevChange += hDiff1;
        }
        else if ((hDiff2 <= hDiff1) && (hDiff2 <= hDiff3)) {
            elevChange += hDiff2;
        }
        else if ((hDiff3 < hDiff1) && (hDiff3 < hDiff2)) {
            currY += 1;
            elevChange += hDiff3;
        }
        else if ((hDiff1 < hDiff2) && (hDiff3 < hDiff2) && (hDiff1 == hDiff3)) {
            int flip = coin.nextInt(2);
            if (flip == 0) {
                currY -= 1;
                elevChange += hDiff1;
            }
            else {
                currY += 1;
                elevChange += hDiff3;
            }
        }
        g.fillRect(i,currY,1,1);
    }    
    return elevChange; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int i;
      int smallVal = 100000;
      int pathL;
      int rowNumber = 0;
      for (i = 0; i < grid.length; i++) {
          pathL = drawLowestElevPath(g, i);
          if (pathL < smallVal) {
              smallVal = pathL;
              rowNumber = i;
          }
      }
      return rowNumber; // row of path with lowest elevation
  
  }
  
  
}