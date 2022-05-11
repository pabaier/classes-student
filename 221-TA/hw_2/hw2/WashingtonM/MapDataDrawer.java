/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Mary Washington
 * bluej version 2
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
        //initializing min to value at row 0 and col 0
        int min = grid[0][0];
        //using for loop to walk through the array and check values at that index
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
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
        int max = 0;
        //using for loop to walk through the array and check values at that index
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
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
        int min = grid[0][col];
        int minRow = 0;
        for(int i = 0; i < grid.length; i++){
            if(grid[i][col] < min){
                min = grid[i][col];
                minRow = i;
            }
        }

        return minRow;  
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
        int col = 0;

        int totalElevChange = 0;
        int  currentElev= grid[currY][col];//current elevation at position on grid
        
        Random rand = new Random();//initalizing new random variable

        for(col = 1; col < grid[0].length; col++){
            int elevChange = Integer.MAX_VALUE;//setting elevation change to maximum integer value allowed
            int elevRowChange = -1;
            int startRow = currY;

            if (startRow > 0){
                startRow--;//ensuring you don't get array index out of bounds for going past end of array
            }
            int endRow = currY;
            if (endRow < (grid.length-1)){
                endRow++;//ensuring you don't get array index out of bounds for going past beginning of array
            }
            //checking to values in the row
            for(int r = startRow; r <= endRow; r++){
                //
                if (Math.abs(currentElev - grid[r][col]) < elevChange){
                    //need to make sure it's not a negative value
                    elevChange = Math.abs(currentElev - grid[r][col]);//setting the elevation change
                    elevRowChange = r;
                }
                else if (Math.abs(currentElev - grid[r][col]) == elevChange){
                    //basically flipping a coin to choose between two rows of the same elevation difference
                    if(r == currY || (rand.nextInt(2) == 1 && elevRowChange != currY) ){
                        elevChange = Math.abs(currentElev - grid[r][col]);
                        elevRowChange = r;
                    }

                }
            }

            currY = elevRowChange;
            //the current elevation is where I am on the grid (mountain)
            currentElev = grid[currY][col];
            totalElevChange = totalElevChange + elevChange;
            // draw next step where x is currently column and currY is row in grid
            int x = col; // the value of x will be generated by a loop that goes through the
            // columns, but for now, need something to put in "paint" statement
            g.fillRect(col,currY,1,1);

        }
        return totalElevChange;
    }


    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g){
        int minChange = Integer.MAX_VALUE;//guaranteeing that I can find a lower elevation change
        int minIndex = 0;//making the default minimum index to be the value at the 0 index

        //walking through the rows
        for (int currRow = 0; currRow < grid.length; currRow++){
            int currentChange = drawLowestElevPath(g, currRow);//calling the drawLowestElevPath method
            //finding the minimum index for the lowest elevation change
            if(currentChange < minChange){
                minIndex = currRow;
                minChange = currentChange;
            }
        }

        return minIndex; // row of path with lowest elevation

    }


}
