/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Connor Matthews
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
      int i = 0;
      int j = 0;
      for(i = 0; i<grid.length; i++){
          for(j = 0; j<grid[0].length; j++){
              if(grid[i][j]<min){
                  min = grid[i][j];
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
      int i = 0;
      int j = 0;
      for(i = 0; i<grid.length; i++){
          for(j = 0; j<grid[0].length; j++){
              if(grid[i][j]>max){
                  max = grid[i][j];
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
      int rowIndex = 0;
      for(int i = 0; i<grid.length; i++){
           if(grid[i][col]<min){
                  min = grid[i][col];
                  rowIndex = i;
                }
            }
      return rowIndex;       
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
   
    g.fillRect(0,row,1,1);
    int currentVal ;
    int above ;
    int front ;
    int below ;
    int diffAbove;  
    int diffFront;  
    int diffBelow; 
    int sum = 0;
    double random;
    
    for(int i = 0; i <= 840; i++){
        currentVal= grid[currY][i];
        above = grid[currY-1][i+1];
        front = grid[currY][i+1];
        below = grid[currY+1][i+1];
        diffAbove = Math.abs(currentVal-above);
        diffFront = Math.abs(currentVal-front);
        diffBelow = Math.abs(currentVal -below);
        
        if(diffAbove<diffFront && diffAbove<diffBelow){
            g.fillRect(i+1,currY-1,1, 1);
            sum+=diffAbove;
        }        
        else if(diffFront<diffAbove && diffFront<diffBelow){
            g.fillRect(i+1,currY,1, 1);
            sum+=diffFront;
        }        
        else if(diffBelow<diffAbove && diffBelow<diffFront){
            g.fillRect(i+1,currY+1,1, 1);
            sum+=diffBelow;
        }
        else if(diffBelow == diffFront && diffFront<diffAbove){
            g.fillRect(i+1,currY,1, 1);
            sum+=diffFront;
        }
        else if(diffAbove == diffFront && diffFront<diffBelow){
            g.fillRect(i+1,currY,1, 1);
            sum+=diffFront;
        }
        else if(diffAbove == diffBelow && diffAbove< diffFront){
          //g.fillRect(i+1,currY-1,1, 1);
           random = Math.random();
            if(random > .5){
            g.fillRect(i+1,currY-1,1, 1);
          }
            else {
            g.fillRect(i+1,currY+1,1, 1);
          }
            sum+=diffAbove;
            
        }

    }
    return sum; // computed change in elevation
  
  }
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int index = 0;
      int lowest = drawLowestElevPath(g, 0);
      int next;
      for(int i = 1; i<=480; i++){
         next = drawLowestElevPath(g, i);
          if(next < lowest){
              lowest = next;
              index = i;
        }
      
          
          
          
      
  }
  return index;
  
  }
}