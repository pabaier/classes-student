
/**
 * This program computes the min, max, mean, and variance for an array of numbers.
 * Each operation is defined within its own method below.
 *
 *John Carter Haley
 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean =average(data); // change this to a call to average method
        double var = variance(data, mean); // change this to a call to variance method
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var);
        
        
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        double min = 0.0;

        min = x[0];
            for (int i=0; i<x.length; i++){
                if (x[i] < min) {
                    min = x[i];
                }
            }
        
        return min;
    
    }
    public static double maximum (double [] x){
        double max = 0.0;

        max = x[0];
            for (int i=0; i<x.length; i++){
                if (x[i] > max) {
                    max = x[i];
                }
            }
        return max;
        }
    public static double average (double [] x){
        double avg = 0.0;


            for (int i=0; i<x.length; i++){
                avg += x[i];
          
            }
            avg = (avg / x.length);
        return avg;
        }
    public static double variance (double [] x, double avg){   
        double sum = 0.0;
        double var = 0.0;
        for (int i=0; i<x.length; i++){
                sum += ((x[i]-avg)*(x[i]-avg));
            }
            var = (sum) * (1.0/x.length);
        return var;
        }   
}
    //public static double 
    
    // Add other methods here.
   //return minimum;


