
/**
 * Author: Andrea Lingenfelter
 * Purpose: Calculate the minimum, maximum, average, and variance of an array of numbers

 */
package Lab4;

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = 0.0; // change this to a call to minimum method
        double max = 0.0; // change this to a call to maximum method
        double mean = 0.0; // change this to a call to average method
        double var = 0.0; // change this to a call to variance method
        
        
        min = minimum(data);
        max = maximum(data);
        mean = average(data);
        var = variance(data, mean);

        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
                min, max, mean, var);
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
    		double smallest = x[0];
          for (int i = 0; i < x.length; i++) {
        	  if (x[i] < smallest) {
        		  smallest = x[i];
        	  }
          }
        return smallest;
        
    }
    public static double maximum (double [] x){
		double biggest = x[0];
      for (int i = 0; i < x.length; i++) {
    	  if (x[i] > biggest) {
    		  biggest = x[i];
    	  }
      }
    return biggest;
    
    }
    
    public static double average (double [] x) {
    	double sum = 0;
    	double average = 0;
    	for (int i = 0; i < x.length; i++) {
    		sum = sum + x[i];
    	}
    	average = sum / x.length;
    	return average;
    }
    
    public static double variance (double [] x, double avg) {
    	double variance = 0;
    	double temp = 0;
    	
    	for (int i = 0; i < x.length; i++) {
    		temp = temp + ((x[i] - avg) * (x[i] - avg));	
    	}
    	variance = ((1.0/x.length) * temp);
    	System.out.println("Length: " + x.length + " temp: " +temp + " var: " +variance);
    	return variance;
    }
   
}
