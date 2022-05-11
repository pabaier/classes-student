/**
 * CSCI 221, HW 2 (McCauley)
 * Base code provided by instructor and updated by:
 * 
 * Tyler Gray
 */
//package edu.cofc.tylergray;

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
  
	  int minVal = grid[0][0];
	  for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
             if(grid[row][col] < minVal) {
            	 minVal = grid[row][col];
             }
          }
       }
      return minVal;  
  }
  
  /**
   * @return the max value in the entire grid
   */
  public int findMax(){

	  int maxVal = grid[0][0];
	  for(int row=0; row < grid.length; row++){
          for(int col=0; col<grid[0].length; col++){
             if(grid[row][col] > maxVal) {
            	 maxVal = grid[row][col];
             }
          }
       }
      return maxVal;  
  }
  
  /**
   * @param col the column of the grid to check
   * @return the index of the row with the lowest value in the given col for the grid
   */
  public  int indexOfMinRow(int col){
      int result = 0; //Index Val
	  int check = grid[0][col]; //Get first val and assume min
      for(int row = 0; row < grid.length; row++) {
    	  
    	  if(grid[row][col] < check) {
    		  
    		  result = row;  //update index
    		  check = grid[row][col]; //update val to check against for min
    	  }
      }
	return result;
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
    int change = 0; //This contains the change in elevation val
    
    // Code to compute next step
    int currX = 0; //start at the west side
    ArrayList<Integer> options = new ArrayList<Integer>(); //allows easy use of min in collections to be used
    Random randomNum = new Random(); //generate random between up and down
    int rand = 0; //init the random number 
    while(currX < grid[0].length-1) { //continue as long as the path isnt at the end
    	options.clear(); //clear the elevation options
    	int op1 = findMax(); //elevations change should never be above the max elev
    	int op2 = findMax();
    	int op3 = findMax();
    	
    	//Cant check the array out of bounds. Yes, some of the code is over pointless but it was to check for other mistakes
    	if(currY<grid.length && currX<grid[0].length) {
    		op1 = Math.abs(grid[currY][currX] - grid[currY][currX+1]); //Striaght Forward
    	}
    	if(currY<grid.length) {	
    		op2 = Math.abs(grid[currY][currX] - grid[currY+1][currX+1]); //Up
    	}
    	if(currY>0) {
    		op3 = Math.abs(grid[currY][currX] - grid[currY-1][currX+1]); //DOwn
    	}
    	
        options.add(op1);
    	options.add(op2);
    	options.add(op3);
    	int minOp = Collections.min(options); //get min elev option
    	if(op1 == minOp) {
    		
    		change = change + op1;
    	}//Straigght
    	else if(op2 == minOp && op3 == minOp) { //randomly select between the two or go the other way if you cant go out of bounds
    		
    		rand = randomNum.nextInt(2);
    		if(rand == 0) {
    			if(currY < grid.length) {
        			currY++;
        			change = change + op2;
        		}
    			else {
    				currY--;
    				change = change + op3;
    			}
    		}
    		else {
    			if(currY > 0) {
        			currY--;
        			change = change + op3;
        		}
    			else {
    				currY++;
    				change = change + op2;
    			}
    			
    			
    		}
    	}
    	else if(op2 == minOp) {
    		
    		if(currY < grid.length) {
    			currY++;
    			change = change + op2;
    		}
    		
    	}
    	else {
    		
    		if(currY > 0) {
    			currY--;
    			change = change + op3;
    		}
    	}
        	
        	
        // columns, but for now, need something to put in "paint" statement
    	currX++;//step to the right
        g.fillRect(currX,currY,1,1);
        
    }
    
  
    
    return change; // computed change in elevation
  }
  
  /**
   * @return the index of the starting row for the lowest-elevation-change path in the entire grid.
   */
  public int indexOfLowestElevPath(Graphics g){
	  //Same as the draw, just cleaned up significantly
	  ArrayList<Integer> elevations = new ArrayList<Integer>();
	  for(int row = 0; row < grid.length; row++) {
		  int currX = 0;
		  int change = 0;
		  int currY = 0;
		    ArrayList<Integer> options = new ArrayList<Integer>();
		    Random randomNum = new Random();
		    while(currX < grid[0].length-1) {
		    	options.clear();
		    	int op1 = Math.abs(grid[currY][currX] - grid[currY][currX+1]); //Striaght Forward
		    	int op2 = Math.abs(grid[currY][currX] - grid[currY+1][currX+1]);
		    	int op3 = Math.abs(grid[currY][currX] - grid[Math.abs(currY-1)][currX+1]);
		    	options.add(op1);
		    	options.add(op2);
		    	options.add(op3);
		    	int minOp = Collections.min(options);
		  
		    	if(op1 == minOp) {
		    		currX++;
		    		change = change + op1;
		    	}
		    	else if(op2 == minOp && op3 == minOp) {
		    		currX++;
		    		int rand = randomNum.nextInt(2);
		    		//System.out.println(rand);
		    		if(rand == 0) {
		    			if(currY < grid.length) {
		        			currY++;
		        			change = change + op2;
		        		}
		    			else {
		    				currY--;
		    				change = change + op3;
		    			}
		    		}
		    		else {
		    			if(currY > 0) {
		        			currY--;
		        			change = change + op3;
		        		}
		    			else {
		    				currY++;
		    				change = change + op2;
		    			}
		    			
		    			
		    		}
		    	}
		    	else if(op2 == minOp) {
		    		currX++;
		    		if(currY < grid.length) {
		    			currY++;
		    			change = change + op2;
		    		}
		    		
		    	}
		    	else {
		    		currX++;
		    		if(currY > 0) {
		    			currY--;
		    			change = change + op3;
		    		}
		    	}
		        	
			    }
	
		    	
		    elevations.add(change);
		  
	  }
	  
	  
	  //return 100;
      return elevations.indexOf(Collections.min(elevations)); // row of path with lowest elevation
  
  }
  
  
}