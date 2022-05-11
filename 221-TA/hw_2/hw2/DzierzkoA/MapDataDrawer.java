/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * <p>
 * Adam Dzierzko
 */

import java.util.*;
import java.io.*;
import java.awt.*;

public class MapDataDrawer {
    // store map data in grid array
    private int[][] grid;

    // Read 2D array into grid. Data in file "filename", grid is rows x cols
    public MapDataDrawer(String filename, int rows, int cols) throws Exception {
        // initialize grid
        grid = new int[rows][cols];
        //read the data from the file into the grid
        Scanner S = new Scanner(new File(filename));

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = S.nextInt();
            }
        }

    }


    /**
     * @return the min value in the entire grid
     */
    public int findMin() {

        int min = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] < min)
                    min = grid[i][j];
            }
        }
        return min;
    }

    /**
     * @return the max value in the entire grid
     */
    public int findMax() {

        int max = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length - 1; j++) {
                if (grid[i][j] > max)
                    max = grid[i][j];
            }
        }
        return max;
    }

    /**
     * @param col the column of the grid to check
     * @return the index of the row with the lowest value in the given col for the grid
     */
    public int indexOfMinRow(int col) {
        int min = grid[0][col];
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] < min) {
                min = grid[i][col];
                index = i;
            }
        }
        return index;
    }


    /**
     * DON'T CHANGE THIS CODE
     * Draws the grid using the given Graphics object.
     * Colors should be grayscale values 0-255, scaled based on min/max values in grid
     *
     * ALERT:Until your findMin and findMax methods work, your output will
     * be a completely black graph.
     */
    public void drawMap(Graphics g) {

        int minVal = findMin();
        int maxVal = findMax();
        double range = maxVal - minVal;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int val = (int) (((grid[row][col] - minVal) / range) * 255);
                //g.setColor(new Color(val,255-val,255-val));
                g.setColor(new Color(val, val, val));
                g.fillRect(col, row, 1, 1);
            }
        }
    }


    /**
     * Find a path from West-to-East starting at given row.
     * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
     * @return the total change in elevation traveled from West-to-East
     */
    public int drawLowestElevPath(Graphics g, int row) {
        Random random = new Random();
        int elevationChange = 0;
        int currY = row; // row in grid of step one
        // draw initial step - column 0, current row (sent in as parameter)
        g.fillRect(0, row, 1, 1);


        for (int i = 1; i < grid[0].length - 4; i++) {                                             // for some reason grid[0].length = 844 so I had to subtract 1
           int previousY = currY;
            if(currY == 479){
               if (grid[currY][i] <= grid[currY -1 ][i]) {
                    // row stays the same
               } else
                   currY = currY -1;
           }
           else if (currY == 0) {
                if (grid[currY][i] <= grid[currY + 1][i]) {
                    continue; // row stays the same
                } else
                    currY = currY + 1;

            } else {
                if (grid[currY][i] <= grid[currY + 1][i] && grid[currY][i] <= grid[currY - 1][i]) {
                             // row stays the same
                } else if (grid[currY][i + 1] < grid[currY][i - 1])
                    currY = currY + 1;
                else if (grid[currY][i - 1] < grid[currY][i + 1])
                    currY = currY - 1;
                else
                    currY = (random.nextBoolean()) ? (currY + 1) : (currY - 1);
            }
            g.fillRect(i, currY, 1, 1);
            elevationChange += Math.abs(grid[currY][i] - grid[previousY][i - 1]);
        }

        // Code to compute next step


        return elevationChange; // computed change in elevation
    }

    /**
     * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
     */
    public int indexOfLowestElevPath(Graphics g) {

        int lowestElevChange = drawLowestElevPath(g, 0);
        int row = 0;

        for (int i = 1; i < grid.length -1; i++) {
            if (drawLowestElevPath(g, i) < lowestElevChange) {
                lowestElevChange = drawLowestElevPath(g, i);
                row = i;
            }
        }


        return row; // row of path with lowest elevation

    }


}