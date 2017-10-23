
/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Arthur Gabriel
 */

import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.Random;

public class MapDataDrawer {
	// store map data in grid array
	private int[][] grid;
	Random rnd = new Random();

	// Read 2D array into grid. Data in file "filename", grid is rows x cols
	public MapDataDrawer(String filename, int rows, int cols) throws Exception {
		// initialize grid
		grid = new int[rows][cols];
		// read the data from the file into the grid
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
			for (int j = 0; j < grid[0].length; j++) {
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
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] > max)
					max = grid[i][j];

			}

		}
		return max;
	}

	/**
	 * @param col
	 *            the column of the grid to check
	 * @return the index of the row with the lowest value in the given col for the
	 *         grid
	 */
	public int indexOfMinRow(int col) { // col is set to 0 here
		int min = grid[0][col];
		int minIndex = 0;
		for (int i = 0; i < grid.length; i++) {
			if (grid[i][col] < min) {
				min = grid[i][col];
				minIndex = i;
			}

		}
		return minIndex;
	}

	/**
	 * DON'T CHANGE THIS CODE Draws the grid using the given Graphics object. Colors
	 * should be grayscale values 0-255, scaled based on min/max values in grid
	 * 
	 * ALERT:Until your findMin and findMax methods work, your output will be a
	 * completely black graph.
	 */
	public void drawMap(Graphics g) {

		int minVal = findMin();
		int maxVal = findMax();
		double range = maxVal - minVal;

		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				int val = (int) (((grid[row][col] - minVal) / range) * 255);
				// g.setColor(new Color(val,255-val,255-val));
				g.setColor(new Color(val, val, val));
				g.fillRect(col, row, 1, 1);
			}
		}
	}

	/**
	 * Find a path from West-to-East starting at given row. Choose a foward step out
	 * of 3 possible forward locations, using greedy method described in assignment.
	 * 
	 * @return the total change in elevation traveled from West-to-East
	 */
	public int drawLowestElevPath(Graphics g, int row) {
		int currY = row; // row in grid of step one
		int ElevationChange = 0;

		// draw initial step - column 0, current row (sent in as parameter)
		g.fillRect(0, row, 1, 1);

		// Code to compute next step
		for (int i = 1; i < 844; i++) { // START at: Row with lowest val in col 0: Value = 1329

			// Extreme Cases: when row is getting close to the edges, Danger: out of bounds
			// So FIRST always check the extreme cases as follows
			// Extreme 1) row nearing upper bound: row index 0
			// in words: if middle is smaller than right, go forward
			if (row == 0
					&& (Math.abs(grid[row][i] - grid[row][i - 1]) < Math.abs(grid[row + 1][i] - grid[row][i - 1]))) {
				// row remains same
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row][i - 1]);
			}

			// Extreme 1
			// in words: if right < middle, go RIGHT
			else if (row == 0
					&& (Math.abs(grid[row + 1][i] - grid[row][i - 1]) < Math.abs(grid[row][i] - grid[row][i - 1]))) {
				row++;// row increases
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row - 1][i - 1]);
			}

			// Extreme 1
			// in words: if tie, go forward
			else if (row == 0
					&& (Math.abs(grid[row][i] - grid[row][i - 1]) == Math.abs(grid[row + 1][i] - grid[row][i - 1]))) {
				// row remains same
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row][i - 1]);
			}

			// NOW check Extreme case 2, when row borders lower bound (480-1=479)
			// Extreme 2
			// in words: if tie, go forward
			else if (row == 479
					&& (Math.abs(grid[row][i] - grid[row][i - 1]) == Math.abs(grid[row - 1][i] - grid[row][i - 1]))) {
				// row remains same
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row][i - 1]);
			}

			// Extreme 2
			// in words: if left < middle, go left
			else if (row == 479
					&& (Math.abs(grid[row - 1][i] - grid[row][i - 1]) < Math.abs(grid[row][i] - grid[row][i - 1]))) {
				row--;// row decreases
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row + 1][i - 1]);
			}

			// Extreme 2
			// in words: if middle < left, go forward
			else if (row == 479
					&& (Math.abs(grid[row][i] - grid[row][i - 1]) < Math.abs(grid[row - 1][i] - grid[row][i - 1]))) {
				// row remains same
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row][i - 1]);
			}

			// GO RIGHT FORWARD and FILL (Case one, in graphical examples, on page 2
			// in words: if right one is smaller than middle or left, then go right
			else if ((Math.abs(grid[row + 1][i] - grid[row][i - 1]) < Math.abs(grid[row][i] - grid[row][i - 1]))
					&& (Math.abs(grid[row + 1][i] - grid[row][i - 1]) < Math
							.abs(grid[row - 1][i] - grid[row][i - 1]))) {
				row++; // increase row, because you go to the right
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row - 1][i - 1]);
			}

			// GO FORWARD and FILL (Case one, in graphical examples, on page 2
			// in words: if middle is smaller than left and right, go forward
			else if ((Math.abs(grid[row][i] - grid[row][i - 1]) < Math.abs(grid[row + 1][i] - grid[row][i - 1]))
					&& (Math.abs(grid[row][i] - grid[row][i - 1]) < Math.abs(grid[row - 1][i] - grid[row][i - 1]))) {
				// row remains same size because you go forward
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row][i - 1]);
			}
			// GO LEFT and FILL (Case one, in graphical examples, on page 2
			// in words: if middle and right is smaller than left, then go LEFT
			else if ((Math.abs(grid[row - 1][i] - grid[row][i - 1]) < Math.abs(grid[row][i] - grid[row][i - 1]))
					&& (Math.abs(grid[row - 1][i] - grid[row][i - 1]) < Math
							.abs(grid[row + 1][i] - grid[row][i - 1]))) {
				row--;// row decreases because you go left
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row + 1][i - 1]);

			}
			// Case 3: smallest change is a tie (3), fwd is an option, so go fwd
			// in words: if change on left is same as change of middle OR change of right is
			// same as change of middle, then go FORWARD
			else if ((Math.abs(grid[row - 1][i] - grid[row][i - 1]) == Math.abs(grid[row][i] - grid[row][i - 1]))
					|| (Math.abs(grid[row + 1][i] - grid[row][i - 1]) == Math.abs(grid[row][i] - grid[row][i - 1]))) {
				// row size remains same, because you go forward
				g.fillRect(i, row, 1, 1);
				ElevationChange += Math.abs(grid[row][i] - grid[row][i - 1]);
			}

			// Case 4: smallest change is a tie (4), choose randomly between fwd-up or
			// fwd-down
			// in words: if (left < middle) AND (left == right), then choose randomly
			// between left or right
			else if ((Math.abs(grid[row - 1][i] - grid[row][i - 1]) < Math.abs(grid[row][i] - grid[row][i - 1]))
					&& (Math.abs(grid[row - 1][i] - grid[row][i - 1]) == Math
							.abs(grid[row + 1][i] - grid[row][i - 1]))) {

				// decide randomly left or right, possible values 1 or 0
				if (rnd.nextInt(2) > 0) {
					// LEFT
					g.fillRect(i, row, 1, 1);
					row--;
					ElevationChange += Math.abs(grid[row][i] - grid[row + 1][i - 1]);

					// ELSE GO RIGHT
				} else {
					g.fillRect(i, row, 1, 1);
					row++;
					ElevationChange += Math.abs(grid[row][i] - grid[row - 1][i - 1]);

				}

			}
		}

		return ElevationChange; // computed change in elevation
	}

	/**
	 * @return the index of the starting row for the lowest-elevation-change path in
	 *         the entire grid.
	 */
	public int indexOfLowestElevPath(Graphics g) {

		int BestROW = 0;
		int lowestElevation = drawLowestElevPath(g, 0);
		// j = rows
		for (int j = 0; j < 480; j++) {
			if (drawLowestElevPath(g, j) < lowestElevation) {
				lowestElevation = drawLowestElevPath(g, j);
				BestROW = j;
			}

		}
		return BestROW; // row of path with lowest elevation

	}

}