/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Ariel Robinson
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
        //finds the min
        int min=grid[0][0];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]<min){
                    min=grid[i][j];
                }

            }

        }
        return min;
        //return 0;  
    }

    /**
     * @return the max value in the entire grid
     */
    public int findMax(){
        //finds the max
        int max=grid[0][0];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]>max){
                    max=grid[i][j];
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
        // 

        int rowIndex=0;
        int min=grid[0][col];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[col].length; j++){
                if(grid[i][col]<min){
                    rowIndex=i;

                }

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
        int currY = row; // row in grid of step one
        // draw initial step - column 0, current row (sent in as parameter)
        g.fillRect(0,row,1,1);
        int col=0;
        int rowTracker=0;
        Random rand=new Random();
        int coinFlip;

        int currentElev=grid[currY][col];
        int topElev=grid[currY][col];
        int midElev=grid[currY][col];

        int botElev=grid[currY][col];

        for(col=1; col<grid[0].length; col++){

            if(col<grid[0].length-1){
                if(currY==0){
                    midElev=grid[currY][col+1];
                    botElev=grid[currY+1][col+1];
                    topElev=90000000;

                }
                else if(currY==grid.length-1){
                    topElev=grid[currY-1][col+1];
                    midElev=grid[currY][col+1];
                    botElev=90000000;

                }
                else{
                    topElev=grid[currY-1][col+1];
                    midElev=grid[currY][col+1];
                    botElev=grid[currY+1][col+1];

                }
            }

            //gets the difference in elevations
            int topDiff=Math.abs(currentElev-topElev);
            int midDiff=Math.abs(currentElev-midElev);
            int botDiff=Math.abs(currentElev-botElev);

            //compares the elevation 

            if(topDiff<midDiff && topDiff<botDiff){
                currentElev=topElev;
                currY=currY-1;
                g.fillRect(col,currY,1,1);
                rowTracker+=topDiff;

            }
            else if(midDiff<=topDiff && midDiff<=botDiff){
                currentElev=midElev;
                currY=currY;
                g.fillRect(col,currY,1,1);
                rowTracker+=midDiff;

            }
            else if(botDiff<midDiff && botDiff<topDiff){
                currentElev=botElev;
                currY=currY+1;
                g.fillRect(col,currY,1,1);
                rowTracker+=botDiff;
            }

            //if the two elevations are equal one of the values will be randomly chosen
            else if(topDiff==botDiff){
                coinFlip=rand.nextInt(2);
                switch(coinFlip){
                    case 0:
                    currentElev=topDiff;
                    currY=currY-1;
                    g.fillRect(col,currY,1,1);
                    rowTracker+=topDiff;
                    break;

                    case 1: 
                    currentElev=botDiff;
                    currY=currY+1;
                    g.fillRect(col,currY,1,1);
                    rowTracker+=botDiff;
                    break;

                }
            }

        } 

        // draw next step where x is currently column and currY is row in grid
        int x = 0; // the value of x will be generated by a loop that goes through the
        // columns, but for now, need something to put in "paint" statement
        g.fillRect(x,currY,1,1);

        return rowTracker; // computed change in elevation

    }

    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        int row=0;
        int min=drawLowestElevPath(g, row);
        int minIndex=0;

        for(row=0; row<480; row++){
            int totalChange=drawLowestElevPath(g, row);
            if(totalChange<min){
                min=totalChange;
                minIndex=row;

            }

        }
        return minIndex; // row of path with lowest elevation

    }

}