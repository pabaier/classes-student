
/**
 * This program finds minimum, maximum, average, and variance of a set of data
 *
 * Lexus Hartung

 */

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
        var = variance(data,mean);
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        double smallest = x[0];
        int i = 0;
        
        for(i = 0; i < x.length; ++i){
            if (x[i] < smallest){
                smallest = x[i];
            }
        }
        
        return smallest;
    }
    public static double maximum (double [] x){
        double largest = x[0];
        int i = 0;
        
        for(i = 0; i < x.length; ++i){
            if (x[i] > largest){
                largest = x[i];
            }
        }
        
        return largest;
    }
    public static double average (double [] x){
        int i = 0;
        double total = 0.0;
        
        for(i = 0; i < x.length; ++i){
            total = x[i] + total;
        }
        total = total / x.length;
        return total;
    }
    public static double variance (double [] x, double avg){
        int i = 0;
        double var = 0.0;
        double base = 0.0;
        for (i = 0; i < x.length; ++i){
            base = Math.pow(x[i] - avg,2);
            var = var + base;
        }
        var = var * (1.0/ x.length);
        return var;
    }
}
