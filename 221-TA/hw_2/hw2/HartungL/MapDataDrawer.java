/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Lexus Hartung
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
      
      for(i = 0; i < grid.length; ++i){
         for(j = 0; j < grid[0].length; ++j){
            if(grid[i][j] < min){
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
      
      for(i = 0; i < grid.length; ++i){
         for(j = 0; j < grid[0].length; ++j){
            if(grid[i][j] > max){
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
      int less = grid[0][col];
      int i = 0;
      int rowLow = 0;
      
      for(i = 0; i < grid.length; ++i){
          if (grid[i][col] < less){
              less = grid[i][col];
              rowLow = i;
          }
      }
      return rowLow;  
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
    
    // Code to compute next step
    int total = 0;
    for (int x = 1; x < grid[0].length; ++x){
        int forward = grid[currY][x];
        int current = grid[currY][x -1];
        int straight = Math.abs(current - forward);
        if (currY == 0){
            int forUp = grid[currY + 1][x];
            int up = Math.abs(current - forUp);
            if(straight <= up){
                total += straight;
            }
            else if(up < straight){
                total += up;
                currY += 1;
            }
        }
        else if (currY == grid.length - 1){
            int forDown = grid[currY - 1][x];
            int down = Math.abs(current - forDown);
            if(straight <= down){
                total += straight;
            }    
            else if(down < straight){
                total += down;
                currY -= 1;
            }
        }
        else{ 
            int forUp = grid[currY + 1][x];
            int forDown = grid[currY - 1][x];
            int up = Math.abs(current - forUp);
            int down = Math.abs(current - forDown);
            if(straight <= up && straight <= down){ 
                total += straight;
            }
            else if(up < straight && up < down){
                total += up;
                currY += 1;
            }
            else if(down < straight && down < up){
                total += down;
                currY -= 1;
            }
            else if(up == down){
                double rand = new Random().nextDouble();
                if (rand > .5){
                    total += up;
                    currY += 1;
                }
                else{
                    total += down;
                    currY -= 1;
                }
            }
        }
        // draw next step where x is currently column and currY is row in grid
        g.fillRect(x,currY,1,1);
    }
    return total; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
      int lowest = drawLowestElevPath(g, 0);
      int rowLow = 0;
      int i = 0;
      for(i = 0; i < grid.length; ++i){
          int checker = drawLowestElevPath(g, i);
          if (checker < lowest){
              lowest = checker;
              rowLow = i;
          }
      }
    
      return rowLow; // row of path with lowest elevation
  }
}
