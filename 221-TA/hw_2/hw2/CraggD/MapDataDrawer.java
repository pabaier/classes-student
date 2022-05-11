/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Dustin Cragg
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
      int minValue = Integer.MAX_VALUE;
      for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
              if( grid[row][col] < minValue )
              {
               minValue = grid[row][col];   
              }
          }
       }
      return minValue;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int maxValue = Integer.MIN_VALUE;
      for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
              if( grid[row][col] > maxValue )
              {
               maxValue = grid[row][col];   
              }
          }
       }
      return maxValue; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int minValue = Integer.MAX_VALUE;
      int rowOutput = 0;
      for(int row=0; row < grid.length; row++){
         if( grid[row][col] < minValue)
         {
             rowOutput = row;
          }
       }
      return rowOutput;  
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
    int elevChange = 0;
    int lowestChange = 0;
    
    g.fillRect(0,row,1,1);
    
    
    
    for(int x = 0; x < grid[0].length -1; ++x)
    {
        g.fillRect(x, currY, 1, 1);
        int forward = grid[currY][x + 1];
        int up = -1;
        int down = -1;
        int forwardPath = Math.abs(grid[currY][x] - forward);
        int pathUp = findMax() + 1;
        int pathDown = findMax() + 1;
        lowestChange = forwardPath;
        Random rand = new Random();
        int n = rand.nextInt(2)+1;
        
        
        if (currY != 0)
        {
            up = grid[currY - 1][x + 1];
        }
        if (currY != grid.length - 1)
        {
            down = grid[currY + 1][x + 1];
        }
        if(up > -1)
        {
            pathUp = Math.abs(grid[currY][x] - up);
        }
        if(down > -1)
        {
            pathDown = Math.abs(grid[currY][x] - down);
        }
        
        if(forwardPath < pathUp && forwardPath < pathDown)
        {
            lowestChange = forwardPath;
        }
        if(pathUp < forwardPath && pathUp < pathDown)
        {
            lowestChange = pathUp;
            --currY;
        }
        if(pathDown < forwardPath && pathDown < pathUp)
        {
            lowestChange = pathDown;
            ++currY;
        }
        if(pathDown == forwardPath || pathUp == forwardPath)
        {
            lowestChange = forwardPath;
        }
        if(pathDown < forwardPath && forwardPath == pathUp)
        {
            if( n == 1)
            {
                lowestChange = pathUp;
                --currY;
            }
            else
            {
                lowestChange = pathDown;
                ++currY;
            }
        
        }
        elevChange = elevChange + lowestChange;
        
    }
   
    return elevChange; 
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int lowestChange = drawLowestElevPath(g, 0);
      int lowestElevPath = 0;
      for(int col = 1; col < grid.length; ++col)
      {
          if(grid[0][col] < lowestChange);
          {
              lowestChange = grid[0][col];
              lowestElevPath = col;
          }
      }
      return lowestElevPath; 
  
  }
  
  
}