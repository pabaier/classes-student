/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Sydney Jackson
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import java.lang.Math;
import java.util.Random;
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
      
      int minVal = grid [0][0];
      for (int i = 0; i < grid.length; i++){
          for (int j = 0; j < grid[0].length; j++){
              if (grid[i][j] < minVal){
                  minVal = grid[i][j];
                  
                }
            }
        }
      return minVal;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      
      int maxVal = grid[0][0];
      for (int i = 0; i < grid.length;i++){
          for (int j = 0; j < 844; j++){
              if (grid[i][j] > maxVal){
                  maxVal = grid[i][j];
                  
                }
            }
        }
      return maxVal; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int k = 0;
      int s = 0;
      int minValRow = grid[k][col];
      for(k = 1; k < grid.length; ++k){
          if (grid[k][col] < minValRow){
              minValRow = grid[k][col];
              s = k;
              
            }
        }
      System.out.println(s);
      return s;
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
         //System.out.println(val);
         //System.out.println(range);
         //System.out.println(grid[row][col]);
         g.setColor(new Color(val,255-val,255-val));
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
    int changeTot = 0;
    
    // Code to compute next step
    for (int i =0; i < grid[0].length - 1; ++i){
        int x = 0;
        Random randInt = new Random();
        int currRow = row;
        int diffFwdUp = 0;
        int diffFwdDown = 0;
        int diffFwd = 0;
        //System.out.println("Row: " + currRow + " Col: " + i);
        if (currRow == 0){
            diffFwdUp = 10000;
            diffFwdDown = Math.abs(grid[currRow][i] - grid[currRow+1][i + 1]);
            diffFwd = Math.abs(grid[currRow][i] - grid[currRow][i+1]);
        }
        else if (currRow == (grid[0].length - 1)){
            diffFwdDown = 10000;
            diffFwdUp = Math.abs(grid[currRow][i] - grid[currRow-1][i+1]);
            diffFwd = Math.abs(grid[currRow][i] - grid[currRow][i+1]);
        }
        else if (currRow < grid[0].length - 1 && currRow > 0){
        //else{
            diffFwdUp = Math.abs(grid[currRow][i] - grid[currRow-1][i+1]);
            diffFwdDown = Math.abs(grid[currRow][i] - grid[currRow+1][i+1]);
            diffFwd = Math.abs(grid[currRow][i] - grid[currRow][i+1]);
        }
            if ((diffFwdUp < diffFwdDown) && (diffFwdUp < diffFwd)){
                x = i + 1;
                currRow -= 1;
                changeTot += diffFwdUp;
            }
            else if((diffFwdDown < diffFwdUp) && (diffFwdDown < diffFwd)){
                x = i + 1;
                currRow += 1;
                changeTot += diffFwdDown;
            }
            else if((diffFwd < diffFwdDown) && (diffFwd < diffFwdUp)){
                x = i + 1;
                currRow = currRow;
                changeTot += diffFwd;
            }
            else if(diffFwd == diffFwdDown){
                int rand = randInt.nextInt(10) + 1;
                if (rand > 5){
                    x = i + 1;
                    currRow = currRow;
                    changeTot += diffFwd;
                }
                else{
                    x = i + 1;
                    currRow +=1;
                    changeTot += diffFwdDown;
                }
            }
            else if(diffFwdUp == diffFwdDown){
                int rand = randInt.nextInt(10) + 1;
                if (rand > 5){
                    x = i + 1;
                    currRow -= currRow;
                    changeTot += diffFwdUp;
                }
                else{
                    x = i + 1;
                    currRow +=1;
                    changeTot += diffFwdDown;
                }
            }
            else if(diffFwd == diffFwdUp){
                int rand = randInt.nextInt(10) + 1;
                if (rand > 5){
                    x = i + 1;
                    currRow = currRow;
                    changeTot += diffFwd;
                }
                else{
                    x = i + 1;
                    currRow -=1;
                    changeTot += diffFwdUp;
                }
            }
            g.fillRect(x,currRow, 1,1);    
        
                
        
    // draw next step where x is currently column and currY is row in grid
    //int x = 0; // the value of x will be generated by a loop that goes through the
    // columns, but for now, need something to put in "paint" statement
        //g.fillRect(x,currY,1,1);
    }
        return changeTot;
    }
  

  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int minElev = 0;
      int j = 0;
      int indexRow = 0;
      for (j = 0; j < grid.length - 1; ++j){
          if (drawLowestElevPath(g, j) < minElev){
              minElev = drawLowestElevPath(g,j);
              indexRow = j;
            }
        }
          
      return indexRow; // row of path with lowest elevation
  
  }
  
  
}
