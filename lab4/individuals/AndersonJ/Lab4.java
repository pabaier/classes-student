
/**
 * Program to calculate minimum, maximum, mean and variance of a data set.
 *
 * Jonathan E. Anderson

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean = mean(data); // change this to a call to average method
        double var = variance(data, mean); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
    	//   double x[] = x;
          int i = 0; // loop variable
          double minVal = x[0]; // initial minium value
          
          for(i = 0; i<x.length; i++) {
        	  if(x[i] < minVal) {
        		  minVal = x[i];
        	  }
          }
        return minVal;
        
    }
    
    
    public static double maximum (double[] x) {
    	int i = 0; //loop variable
    	double maxVal = 0; // intital maximum value
    	// double x[] = x; 
    	
    	for(i = 0; i < x.length; i++) {
    		if(x[i] > maxVal) {
    			maxVal = x[i];
    		}
    	}
    	return maxVal;
    }
    
    public static double mean(double[] x) {
    	// double x[] = x;
    	int i = 0; //loop variable
    	double sigma = 0; // variable to caluclate the sumation of all terms
    	double n = x.length; //variable to calculate the length, or n, value of array x
    	double mean; // variable to store the mean/average.
    	
    	for(i=0; i<n; i++) {
    		sigma = sigma + x[i];
    	}
    	mean = sigma / n;
    	return mean;
    }
   
    public static double variance(double[] x, double avg) {
    	// double x[] = x;
    	// double avg = avg;
    	int i = 0; //loop variable
    	double sigma = 0; // variable to calculate the sum of terms
    	double n = x.length; //variable to calculate the length, or n value, of array x
    	double vari;
    	
    	for(i=0; i<=n; i++) {
    		sigma = sigma + Math.pow((x[i] - avg), 2.0);
    	}
    	vari = (1/n) * sigma;
    	return vari;
    }
}
