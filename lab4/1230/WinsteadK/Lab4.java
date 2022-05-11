/*
 * This programs assignment is to take an array, use methods to find: average, maximum, minimum and varience and print out the 
 * results. 
 *
 * Name: Kyle Winstead
 * Date: October 2, 2017
 * Assignment: Lab 4
 * 
 * Pseudocode:
 * declare an array x
 * call method minimum(x)
 * call method maximum(x)
 * call method average (x)
 * call method variance(x, mean)
 * 
 * print out the values calculated in the methods below the main
 */

public class Lab4
{    
    public static void main(String [] args){
    	
    	
        double [] x = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
       
        double min = minimum(x);
		double max = maximum(x);
		double y = 0.0;
		double mean = average(x, y );
		double var = variance(x, mean, y);
        
        
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    /**
     * This method will calulate the minimum from all values in array. it will return the minimum. 
     * 
     * @param double [] x
     * @return minimum
     */
    public static double minimum (double [] x){
    	double minimum = 0.0;
          for(int i=1; i < x.length; i++) {
        	  if(x[i] < x[i-1]) {
        	  minimum = x[i];
          }
        
          }
		return minimum;
    }
    
    /**
     * This method will calculate the maximum value in array. It will return the maximum. 
     * 
     * @param double [] x
     * @return maximum
     */
    public static double maximum (double [] x) {
    	double maximum = 0.0;
        for(int i=1; i < x.length; i++) {
      	  if(x[i] > x[i-1]) {
      	  maximum = x[i];
        }
      
        }
		return maximum;
    	
    }
   /**
    * This method will average all values from the array. It will return the average.
    * 
    * @param double [] x
    * @return average
    * 
    */
    public static double average (double [] x, double y) {
    	double average = 0.0;
    	
        for(int i=1; i < x.length; i++) {
        	y = x[i];
      	  average = x.length /y;
        
      
        }
		return average;
    	
    }
    
    /**
     * This method will use a formula to find the varience of the array. 
     * @param x
     * @param avg
     * @return variance
     */
    public static double variance (double [] x, double avg, double y) {
    	
    	double variance=0.0 ;
    	for(int i = 0; i < x.length; i++ ) {
    		variance = 1.0/x.length * (x[i] - average(x,y));
    	}
    	
    	
    	return variance;
    	
    }
}
