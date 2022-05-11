
/**
 * Takes an array and computes the minimum, maximum, mean, and variance.
 *
 * Ashley Woods

 */

import java.lang.Math;
public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean = average(data); // change this to a call to average method
        double var = variance(data); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        double minimum = x[0]; 
        for (int i = 1; i<x.length; i++) {
            if (x[i] < minimum) {
                minimum = x[i];
            }
        }
        return minimum;
        
    }
    
    public static double maximum (double [] x) {
        double maximum = x[0];
        for (int i = 1; i<x.length; i++) {
            if (x[i] > maximum) {
                maximum = x[i];
            }
        }
        return maximum;
    }
    // Add other methods here.
    
    public static double average (double [] x) {
        double average = 0;
        for (int i = 0; i<x.length; i++) {
            average = average + x[i];
        }
        average = average / x.length;
        return average;
    }
    
    public static double variance (double [] x) {
     double variance = 0;
     for (int i=0; i<x.length; i++) {
         variance = variance + (Math.pow((x[i]-average(x)),2));
     }
     variance = variance * (1.0/x.length);
     return variance;
    }
   
}
