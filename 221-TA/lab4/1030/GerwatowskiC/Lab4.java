
/**
 * This program calculates the min, max, mean, and variance of an array.
 *
 * Claire Gerwatowski

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data);
        double max = maximum(data);
        double mean = average(data);
        double var = variance(data, mean);
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        double smallest = x[0];
        for (int i = 1; i <= x.length-1; i++) {
            if (x[i] < smallest){
                smallest = x[i];
            }
        }
        return smallest;
        
    }
    
    public static double maximum (double [] x) {
        double largest = x[0];
        for (int i = 1; i <= x.length-1; i++) {
            if (x[i] > largest) {
                largest = x[i];
            }
        }
        return largest;
    }
   
    public static double average (double [] x) {
        double avg = 0.0;
        double total = 0.0;
        for (int i = 0; i <= x.length-1; i++) {
            total = total + x[i];
        }
        avg = total/(x.length);
        return avg;
    }
    
    public static double variance (double [] x, double avg) {
        double var = 0.0;
        double sum = 0.0;
        double sumMinusAvg = 0.0;
        for (int i = 0; i <= x.length-1; i++) {
            sumMinusAvg = Math.pow(x[i] - avg, 2);
            sum = sum + sumMinusAvg;
        }
        var = ((double)1/(x.length))*(sum);
        return var;
    }
}
