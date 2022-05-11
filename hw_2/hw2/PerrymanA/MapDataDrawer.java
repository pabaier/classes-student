/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Asa Perryman
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
        int minimumValue = grid[0][0];

        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){
                if(minimumValue > grid[i][j]){
                    minimumValue = grid[i][j];
                }
            }

        }
        return minimumValue;  
    }

    /**
     * @return the max value in the entire grid
     */
    public int findMax(){
        int maximumValue = grid[0][0];

        for(int i = 0; i < grid.length;i++){

            for(int j = 0; j < grid[0].length; j++){
                if(maximumValue < grid[i][j]){
                    maximumValue = grid[i][j];
                }
            }

        }

        return maximumValue; 
    }

    /**
     * @param col the column of the grid to check
     * @return the index of the row with the lowest value in the given col for the grid
     */
    public  int indexOfMinRow(int col){
        int minimumValue = grid[0][col];
        //int minimumValueInRow = 0;
        int rowNum = 0;

        for(int i = 0; i < grid.length; i++){
            if( minimumValue > grid[i][col]){
                minimumValue = grid[i][col];
                rowNum = i;

            }
        }
        return rowNum;  
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
        //This method seems to be almost correct. The issue is that elevationChange is not
        //storing once either forwardDifference, upDifference, or downDifference is added 
        //to it. I figured this out by printing my variables but was confused as to why 
        //elevation change seemed to be overwriting each iteration through the loop eventhough
        //it is declared outside of the loop. This caused the paths to be straight lines.
        
        //int currY = row; // row in grid of step one
        int x = 0;
        int elevationChange = 0;
        // draw initial step - column 0, current row (sent in as parameter)

        //g.fillRect(0,row,1,1);

        for( x = 0; x < grid[0].length -1 ; x++){
            
            //g.fillRect(x, row, 1, 1);
            int current = grid[row][x];
            int moveForward = grid[row][x+1];
            //int moveUp = grid[row-1][x+1];
            //int moveDown = grid[row+1][x+1];

            int forwardDifference = Math.abs(current - moveForward);
            //int upDifference = Math.abs(current - grid[row-1][x+1]);
            int upDifference = 0;
            //int downDifference = Math.abs(current - grid[row+1][x+1]);
            int downDifference =0;
            // Code to compute next step

            //if you are at the top row
            if(row == 0){
                if(downDifference > forwardDifference){
                    elevationChange += forwardDifference;
                }
                if(downDifference < forwardDifference){
                    
                    downDifference = Math.abs(current - grid[row+1][x+1]);
                    row ++ ;
                    elevationChange += downDifference;
                    
                }
            }
            //if you are at the bottom row
            if(row == grid.length - 1){
                if(upDifference > forwardDifference){
                    elevationChange += forwardDifference;
                }
                if(upDifference < forwardDifference){
                    
                    upDifference = Math.abs(current - grid[row-1][x+1]);
                    row --;
                    elevationChange += upDifference;
                    
                }
            }

            //if you are not at the bottom or top row
            if(row != 0 && row != grid.length-1){
                if(forwardDifference <= upDifference && 
                forwardDifference <= downDifference  ){
                    elevationChange += forwardDifference;
                    
                }
                if(upDifference < forwardDifference && 
                upDifference < downDifference){
                    
                    upDifference = Math.abs(current - grid[row-1][x+1]);
                    row --;
                    elevationChange += upDifference;
                    
                }
                if(downDifference < forwardDifference && 
                downDifference < upDifference){
                    
                    downDifference = Math.abs(current - grid[row+1][x+1]);
                    row += row;
                    elevationChange += downDifference; 
                    
                }
                //if(downDifference == upDifference){
                    
                //}
            }
               //g.fillRect(x, row, 1, 1);
            // draw next step where x is currently column and currY is row in grid
            //int x = 0; // the value of x will be generated by a loop that goes through the
            // columns, but for now, need something to put in "paint" statement
            //g.fillRect(x,currY,1,1);
            g.fillRect(x, row, 1, 1);
        }
        return elevationChange; // computed change in elevation
    }

    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        int lowest = drawLowestElevPath(g, 0);
        int index = 0;
        for(int i = 1; i < grid.length; i++){
            if(grid[0][i] < lowest){
                lowest = grid[0][i];
                index = i;
            }
        }
        return index; // row of path with lowest elevation

    }

}