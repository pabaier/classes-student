/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Carson Barber
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
      int min = Integer.MAX_VALUE;
      for(int i = 0; i<grid.length; i++){
          for(int j = 0; j<grid[0].length;j++){
              if(grid[i][j]<min)min = grid[i][j];
            }
        }
      return min;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int max = Integer.MIN_VALUE;
      for(int i = 0; i<grid.length; i++){
          for(int j = 0; j<grid[0].length;j++){
              if(grid[i][j]>max)max = grid[i][j];
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
      int minIndex = 0;
      for(int i = 0; i<grid.length;i++){
         if(grid[i][col]<min){
             minIndex = i;
             min = grid[i][col];
            }
        }
      return minIndex;  
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
    int totalChange = 0;
    // Code to compute next step
    boolean upValid;//true if the row above the current row is valid, i.e. current row is not index 0;
    boolean downValid;//true if the row below the current row is valid, i.e. current row is not the last index in grid[0];
    int lowestSoFar;//lowest change in elevation from options examined so far this step
    int currentHeight;//shows elevation at current indexes
    char bestDirection;//char showing whether to go straight(s), up(u), or down(d);
    for(int col = 0; col<grid[0].length-1;col++){
        currentHeight = grid[currY][col];//height at current index
        upValid = (currY!=0);//find whether up is valid
        downValid = (currY!=grid.length-1);//find whether down is valid
        lowestSoFar = Math.abs(currentHeight-grid[currY][col+1]);
        bestDirection = 's';
        if(upValid && Math.abs(currentHeight-grid[currY-1][col+1])<lowestSoFar){//change lowestSoFar and bestDirection to up if up is a lower change
            lowestSoFar = Math.abs(currentHeight-grid[currY-1][col+1]);
            bestDirection = 'u';
        }
        if(downValid && Math.abs(currentHeight-grid[currY+1][col+1])<lowestSoFar){//change lowestSoFar and bestDirection to up if down is a lower change
            lowestSoFar = Math.abs(currentHeight-grid[currY+1][col+1]);
            bestDirection = 'd';
        }
        //check if up and down are the same change in height and straight is a worse option
        if(downValid && upValid && Math.abs(currentHeight-grid[currY-1][col+1]) == Math.abs(currentHeight-grid[currY+1][col+1]) && bestDirection != 's'){
            //if same then randomly select one to chose
            if((int)(Math.random()*2.0) == 0) bestDirection = 'u';
            else bestDirection = 'd';
        }
        //decide x so that the next step is painted up or down a row, or in the same row, depending on bestDirection
        int x = 0;
        if(bestDirection == 's') x = 0;
        else if(bestDirection=='u')x = -1;
        else if(bestDirection=='d')x = 1;
        g.fillRect(col+1,currY+x,1,1);//paint new step
        currY+=x;//change currY to match next step's starting location
        totalChange+=lowestSoFar;//add height change to totalChange
    }

    return totalChange; // computed change in elevation
    }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int lowestIndex = 0;//index of row with lowest elevation change
      int currChange;//elevation change of current row
      int lowestChange=Integer.MAX_VALUE;//the lowest elevation change found so far
      for(int row = 0;row<grid.length;row++){
          currChange = drawLowestElevPath(g, row);
          if(currChange<lowestChange){//update lowestIndex and lowestChange if this row's path has a lower elevation change
              lowestIndex=row;
              lowestChange=currChange;
          }
        }
      return lowestIndex; // row of path with lowest elevation
  
  }
  
  
}