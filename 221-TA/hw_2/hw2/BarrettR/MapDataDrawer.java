/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Ryan Barrett
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
      //cycles through all possible values and stores the minimum in min...
      for(int i = 0; i < grid.length; i++)
        for(int j = 0; j< grid[0].length; j++)
            if(grid[i][j] < min)
                min = grid[i][j];
  
      return min;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
      int max = grid[0][0];
      //cycles through all possible values and stores the maximum in max...
      for(int i = 0; i < grid.length; i++)
        for(int j = 0; j < grid[0].length; j++)
            if(grid[i][j] > max)
                max = grid[i][j];
      
      return max; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int min = 0;
      //don't know if we had to code this but here it is
      for(int i = 1; i < grid.length; i++)
        if(grid[min][col] > grid[i][col])
            min = i;
      return min;  
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
    g.fillRect(0,row,1,1);
    int col = 0;
    int totalElevationChange = 0;
    
    //runs until it reaches the end...
    while(col < grid[0].length - 1)
    {   
        int current = grid[row][col];
        
        int left = 0;
        if(row - 1 >= 0)
            left = grid[row - 1][col + 1];
        else
            left = 999999999;   //ensures an out of bounds value won't be chosen
        
        int middle = grid[row][col + 1];
        
        int right = 0;
        if(row + 1 < grid.length)
            right = grid[row + 1][col + 1];
        else
            right = 999999999;  //ensures an out of bounds value won't be chosen
        
        //finds difference based on elevation change
        int rightDif = Math.abs(right - current);
        int leftDif = Math.abs(left - current);
        int middleDif = Math.abs(middle - current);
        
        //fills chosen path pixel and decides new row
        if(leftDif > rightDif && middleDif > rightDif)
        {
            row++;
            g.fillRect(col, row, 1, 1);
            totalElevationChange += rightDif;
        }
        else if(rightDif == leftDif && middleDif > rightDif)
        {
            if(Math.random() > 0.5)
            {
                row++;
                g.fillRect(col, row, 1, 1);
                totalElevationChange += rightDif;
            }
            else
            {
               row--;
               g.fillRect(col, row, 1, 1);
               totalElevationChange += leftDif; 
            }
            
        }
        else if(rightDif > leftDif && middleDif > leftDif)
        {
            row--;
            g.fillRect(col, row, 1, 1);
            totalElevationChange += leftDif;
        }
        else
        {
            g.fillRect(col, row, 1, 1);
            totalElevationChange += middleDif;
        }
            
        col++;
    }
    
    return totalElevationChange;
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int min = 0;
      for(int i = 1; i < grid.length; i++)
      {
          if(drawLowestElevPath(g, min) > drawLowestElevPath(g, i))
            min = i;
      }
     
      return min;
  }
  
  
}