
/**
 * Lab4's purpose is to calculate the minimum, maximum, average, and variance 
 * of a given data set using methods.
 *
 * Corey Taylor

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
          
          double minimumVal = x[0];
          for(int i = 1; i < x.length; i++){
            if (x[i] < minimumVal){
                minimumVal = x[i];
            }
            }          
        return minimumVal;
    }
    public static double maximum (double [] x){
        double maximumVal = x[0];
        for (int i = 1; i < x.length; i++){
            if (x[i] > maximumVal){
                maximumVal = x[i];
            }
        }
        return maximumVal;
    }
    public static double average(double [] x){
        double averageVal = 0.0;
        for(int i = 0; i < x.length; i++){
            averageVal = averageVal + x[i];
        }
        averageVal = averageVal / x.length;
        return averageVal;
    }
    public static double variance(double [] x){
        double varianceVal = 0.0;
        
        for(int i = 0; i < x.length; i++){
            varianceVal = varianceVal + Math.pow((x[i] - average(x)), 2);
        }
        varianceVal = varianceVal * (1.0/x.length);
        return varianceVal;
    }
   
}
