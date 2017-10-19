// This solution is for you alone.
// Do not post or distribute.

import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer
{
  // store map data in grid array
  private int[][] grid; 

  public MapDataDrawer(String filename, int rows, int cols) throws Exception{
      // initialize grid 
      //read the data from the file into the grid
      Scanner S = new Scanner(new File(filename));    
      grid = new int[rows][cols];

       for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
             grid[row][col] = S.nextInt(); 
          }
       }
      
  }
  
  /**
   * Returns the min value in the entire grid
   */
  public int findMin(){
    int min = grid[0][0];
    int minRow=0, minCol=0;
      
      for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
              if(grid[row][col]<min){ 
                  min = grid[row][col]; 
                  minRow=row; 
                  minCol=col;
              }
          }
      }
      //not required, but useful debugging statement for sanity check
      System.out.println("min loc: row="+minRow+", col="+minCol);
      return min;  
  }
  
  /**
   * Returns the max value in the entire grid
   */
  public int findMax(){
    int max = grid[0][0];
    int maxRow=0, maxCol=0;
      
      for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
              if(grid[row][col]>max){ 
                  max = grid[row][col]; 
                  maxRow=row; 
                  maxCol=col;
              }
          }
      }
      //not required, but useful debugging statement for sanity check
      System.out.println("max loc: row="+maxRow+", col="+maxCol);
      return max; 
  }
  
  /**
   * @param col the column of the grid to check
   * Returns the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
  
    int minRow=0;
      
      for(int row=0; row < grid.length; row++){
          if(grid[row][col]< grid[minRow][col]){ 
              minRow=row; 
          }
      }
      
      return minRow;  
  }
  
  
  /**
   * Draws the grid using the given Graphics object.
   * Colors should be grayscale values 0-255, scaled based on min/max values in grid
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
   * Return the total change in elevation traveled from West-to-East
   */
  public int drawLowestElevPath(Graphics g, int row){
    int currY=row;
    int totalChangeInElevation=0;
    g.fillRect(0,row,1,1);
    int previousElevation = grid[currY][0];
    for(int x=1; x < grid[0].length; x++){
        // System.out.println("Current " + previousElevation);
        int up,fwd,down;
        up = down = Integer.MAX_VALUE; //in case they don't have vals because out of bounds.
        
        // Find elevations for up,fwd,down
        // need to do bounds check
        if(currY-1 >= 0) 
            up = grid[currY-1][x];
        
        fwd = grid[currY][x]; //fwd will always exist
        
        if(currY+1 < grid.length) 
            down = grid[currY+1][x];
        
        // Compute elevation change in next step
        int difWithFwd = Math.abs(previousElevation - fwd);
        // System.out.println("  Fwd: " + fwd + ", Dif with fwd: " + difWithFwd);
        int difWithUp = Math.abs(previousElevation - up);
        // System.out.println("  Up: " + up + ", Dif with up: " + difWithUp);
        int difWithDown = Math.abs(previousElevation - down);
        // System.out.println("  Down: " + down + ", Dif with down: " + difWithDown);
        
        //figure whether should go up, down, fwd
        // by setting dir to -1, 0, 1...will add to currY
         
        //assume fwd is min val.  Change if nec.
        int dir = 0;
        int minDif = difWithFwd; // assume this is the minimum difference
        
        //if up is lower, then make it minDif and switch dir to up
        if( difWithUp < minDif){ 
            dir = -1; minDif = difWithUp; 
        }
        
        //if down is lower (than lowest of up or fwd), then make it minDif, 
        //  and switch dir
        if( difWithDown < minDif ){ 
            minDif = difWithDown; dir = 1; }
      
        // if down/up are the same and the minimum then flip a coin.
        if(difWithDown == minDif && up==down){
            if(Math.random()<0.5){
                dir = 2;
            }
            else{
                dir = -1;
            }
        }
        //dir is now -1,0, or 1, which should be added to currY - the next row
        currY += dir;
        totalChangeInElevation += minDif;
        // System.out.println("Total change so far is: " + totalChangeInElevation);
        previousElevation = grid[currY][x]; // reset with new position
        g.fillRect(x,currY,1,1);

    }
    
    return totalChangeInElevation;
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
     int bestPathTotal = Integer.MAX_VALUE;
     int bestPathStartingRow = -1;
     
     for(int row=0; row < grid.length; row++){
         int result = drawLowestElevPath(g,row);
         // System.out.println(result);
         if(result < bestPathTotal){          
             bestPathTotal = result;
             bestPathStartingRow = row;
         }
     }
     
     return bestPathStartingRow;
  
  }
  
  
}