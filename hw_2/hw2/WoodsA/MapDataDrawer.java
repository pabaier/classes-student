/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Ashley Woods
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
      //grid = new int[rows][cols];
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
      for (int row=0; row<grid.length; row++) {
        for (int col=0; col<grid[0].length; col++) {
            if (grid[row][col] < min) {
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
      int max = grid[0][0];
      for (int row=0; row<grid.length; row++) {
        for (int col=0; col<grid[0].length; col++) {
            if (grid[row][col] > max) {
                max = grid[row][col];
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
      int minRowIndex = 0;
      int min = grid[0][col];
      for (int row = 0; row<grid.length; row++) {
          if (grid[row][col]<min){
              minRowIndex = row;
              min = grid[row][col];
          }
      }
      return minRowIndex;  
  }
  
  
  /**
   * DO NOT CHANGE THIS CODE
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
    g.fillRect(0,currY,1,1);
    int fwd;
    int fwdAndUp;
    int fwdAndDown;
    int elevDiffUp;
    int elevDiffDown;
    int elevDiffFwd;
    int elevationChange = 0;
    Random rand = new Random();
    int randomNumber;
    // Code to compute next step
    for (int col=1; col<grid[0].length; col++) {
        if (currY == (grid.length-1)) {
            fwd = grid[currY][col];
            fwdAndUp = grid[currY-1][col];
            elevDiffFwd = Math.abs(fwd - grid[currY][col-1]);
            elevDiffUp = Math.abs(fwdAndUp - grid[currY][col-1]);
            if (elevDiffFwd<=elevDiffUp){
                //currY = currY;
                g.fillRect(col,currY,1,1);
                elevationChange = elevationChange + elevDiffFwd;
            }
            else {
                currY = currY-1;
                g.fillRect(col,currY,1,1);
                elevationChange = elevationChange + elevDiffUp;
            }
        }
        else if (currY == 0) {
            fwd = grid[currY][col];
            fwdAndDown = grid[currY+1][col];
            elevDiffFwd = Math.abs(fwd - grid[currY][col-1]);
            elevDiffDown = Math.abs(fwdAndDown - grid[currY][col-1]);
            
            //System.out.print(col + ": START-" + grid[currY][col-1] + " FWD-" + fwd + "   FWDandDown-" + fwdAndDown + ": ");
            if (elevDiffFwd<=elevDiffDown){
                //currY = currY;
                g.fillRect(col,currY,1,1);
                elevationChange = elevationChange + elevDiffFwd;
                
                //System.out.println("Went forward");
            }
            else{
                currY = currY+1;
                g.fillRect(col,currY,1,1);
                elevationChange = elevationChange + elevDiffDown;
                
                //System.out.println("Went forward and down");
            }
        }
        else {
            fwdAndUp = grid[currY-1][col];
            fwd = grid[currY][col];
            fwdAndDown = grid[currY+1][col];
            elevDiffUp = Math.abs(fwdAndUp - grid[currY][col-1]);
            elevDiffFwd = Math.abs(fwd - grid[currY][col-1]);
            elevDiffDown = Math.abs(fwdAndDown - grid[currY][col-1]); 
            
            //System.out.print(col+": START-" + grid[currY][col-1] +" FWD-" + fwd + "   FWDandDown-" + fwdAndDown + "FWDandUp" + fwdAndUp+": ");
            if ((elevDiffFwd<=elevDiffUp && elevDiffFwd<=elevDiffDown)){
                //currY = currY;
                g.fillRect(col,currY,1,1);
                elevationChange = elevationChange + elevDiffFwd;
                
                //System.out.println("Went forward");
            }
            else if (elevDiffUp<elevDiffFwd && elevDiffUp<elevDiffDown){
                currY = currY-1;
                g.fillRect(col,currY,1,1);
                elevationChange = elevationChange + elevDiffUp;
                
                //System.out.println("Went forward and up");
            }
            else if (elevDiffDown<elevDiffUp && elevDiffDown<elevDiffFwd){
                currY = currY+1;
                g.fillRect(col,currY,1,1);
                elevationChange = elevationChange + elevDiffDown;
                
                //System.out.println("Went forward and down");
            }
            else if (elevDiffUp == elevDiffDown) {
                randomNumber = rand.nextInt(2);
                if (randomNumber == 0) {
                    currY = currY+1;
                    g.fillRect(col,currY,1,1);
                    elevationChange = elevationChange + elevDiffDown;
                    //System.out.print(0);
                    //System.out.println("Went forward and down");
                }
                else {
                    currY = currY-1;
                    g.fillRect(col,currY,1,1);
                    elevationChange = elevationChange + elevDiffUp;
                    //System.out.print(1);
                    //System.out.println("Went forward and up");
                }
            }
        }
    }
    //g.fillRect(col,currY,1,1);--Just a note in case I need it, do not uncomment
    
    return elevationChange; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int indexOfLowestElevPath = 0;
      int currLowestElevChange = drawLowestElevPath(g,0);
      for (int row=1; row < grid.length; row++) {
          int currElevChange = drawLowestElevPath(g,row);
          if (currElevChange< currLowestElevChange) {
              indexOfLowestElevPath = row;
              currLowestElevChange = currElevChange;
          }
      }
      return indexOfLowestElevPath; // row of path with lowest elevation
  }
  
  
}