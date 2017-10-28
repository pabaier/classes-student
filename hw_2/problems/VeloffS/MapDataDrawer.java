/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Stefan Veloff
 */
//This is a program that takes a list of various elevation levels and constructs a map showing the 
//path of least resistance.
//I got help from the computer lab and Paul B.
//import statments:
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
      
      //for loop: loops through rows:
       for(int row=0; row < grid.length; row++){
    	   	 //for loop: loops through columns:
          for(int col = 0; col < grid[0].length; col++){
             grid[row][col] = S.nextInt(); 
          }
       }
      
  }

  
  /**
   * @return the minimum value in the entire grid
   */
   //finds the minimum value:
   public int findMin(){
	   	 //declares minValue to grid at position[0][0]:
		  int minValue = grid[0][0];
		  //for loop: loops through rows:
		  for (int row = 0; row < grid.length; row++) {
			  //for loop: loops through columns:
			  for(int col = 0; col < grid[0].length; col++) {
				  //if statement:
				  if(grid[row][col] < minValue) {
					  //minValue is set to:
					  minValue = grid[row][col];
				  }
			  }
		  }
		  //return statement:
	      return minValue;  
	  
   }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){
	  //declaration:
	  int maxValue = grid[0][0]; 
	  //for loop: loops through rows:
	  for (int row = 0; row < grid.length; row++) {
		  //for loop: loops through columns:
		  for(int col = 0; col < grid[0].length; col++) {
			  //if statement:
			  if (grid[row][col] > maxValue) {
				  //maxValue is set: 
				  maxValue = grid[row][col];
		  }
	  }
  }	  //return Statement:	
      return maxValue; 
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
	  //declaration of min:
	  int minimum = grid[0][col];
	  //declaration of rowMinimum:
	  int rowMinimum = 0;
	  //for loop: loops through row:
	  for (int row = 0; row < grid.length; row++){
		  //if statement:
		  if(grid[row][col] < minimum) {
			  //minimum set:
			  minimum = grid[row][col];
			  //rowMinimum set to row:
			  rowMinimum = row;
		  }
	  }
	  //return statement:
	  return rowMinimum;
  }
  
  /**
   * DON'T CHANGE THIS CODE
   * Draws the grid using the given Graphics object. 
   * Colors should be gray scale values 0-255, scaled based on min/max values in grid
   * 
   * ALERT:Until your findMin and findMax methods work, your output will
   * be a completely black graph.
   */
  public void drawMap(Graphics g){
    //declaration:  
    int minVal = findMin();
    int maxVal = findMax();
    double range = maxVal - minVal;
    //for loop for rows:
    for(int row=0; row < grid.length; row++){
    	//for loop for col:
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
   * Choose a forward step out of 3 possible forward locations, using greedy method described in assignment.
   * @return the total change in elevation traveled from West-to-East
   */
  public int drawLowestElevPath(Graphics g, int row){
	  int max = findMax();
	  int totalChange = 0;
	  int least = 0;
	  
	  for (int x = 0; x < grid[0].length - 1; x++){
		  g.fillRect(x, row, 1, 1);
		  int forward = grid[row][x + 1];
		  int forwardUp = -1;
		  int forwardDown = -1;
		  //if statement: if row is not = 0:
		  if (row != 0){
			  forwardUp = grid[row - 1][x + 1];
			  }
		  //if statement: if row is not in grid length - 1:
		  if (row != grid.length - 1){
			  //incrementing row and column by 1 (this is forward down):
			  forwardDown = grid[row + 1][x + 1];
		  } 
		  //declaration:
		  int currForwardNew = Math.abs(grid[row][x] - forward);
		  //declaration:
		  int currForwardUpNew = max + 1;
		  //declaration:
		  int currForwardDownNew = max + 1;
		  
		  if (forwardUp > -1){
			  currForwardUpNew = Math.abs(grid[row][x] - forwardUp);
		  }
		  //if statement:
		  if (forwardDown > -1){
			  currForwardDownNew = Math.abs(grid[row][x] - forwardDown);
		  }
		  //least set to the new forward:
		   least = currForwardNew;
		  
		   //if statement:
		  if (currForwardNew > currForwardUpNew){
			  if (currForwardUpNew > currForwardDownNew){
				  least = currForwardDownNew;
				  row++;
			}
			  //else statement:
			  else{
				  least = currForwardUpNew;
				  row--;
				  }
		  }
		  //else statement:
		  else {
			  if (currForwardNew > currForwardDownNew){
				  least = currForwardDownNew;
				  row++;
				  }
			  else {
				  least = currForwardNew;
				  }
			  }
		  
		  totalChange += least;
		  }
	  //return statement:
	  return totalChange;
  }
	  
 
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
	     int least = drawLowestElevPath(g, 0);
	     int index = 0;	    		 
		 for (int col = 1; col < grid.length; col++){
			 if (grid[0][col] < least);{
	    		 least = grid[0][col];
	    		 //index set to col:
	    		 index = col;
			 }
		 }
		 //return statemnet:
		 return index;
	  
	  }
	  
	  
	}