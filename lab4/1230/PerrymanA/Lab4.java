/**
 * Given an array of values, this program will find the minimum and maximum
 * values and compute the average and variance. 
 * Asa Perryman
 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); // change this to a call to minimum method
        double max = maximum(data); // change this to a call to maximum method
        double mean = average(data); // change this to a call to average method
        double var = variance(data, mean); // change this to a call to variance method

        
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }

    // Finds and returns the minimum value in
    // an array of doubles

    public static double minimum (double [] x){
        double smallest = x[0];
        for(int i = 0; i < x.length; i++){
            if( smallest > x[i]){
            smallest = x[i];
            }
        }
        return smallest;

    }

    // Add other methods here.
    public static double maximum (double [] x){
        double largest = x[0];
        for(int i = 0; i < x.length; i++){
            if(largest <  x[i]){
            largest = x[i];
            }
        }
        return largest;
    }
    
    public static double average (double [] x){
        int i = 0;
        double sum = 0.0;
        for( i = 0; i < x.length; i++){
            sum = sum + x[i];
        }
        double avg = sum / (x.length);
        return avg;
    }
    
    public static double variance (double [] x, double mean){
        double varianceVal = 0.0;
        int i = 0;
        for( i = 0; i < x.length; i++){
            varianceVal = varianceVal + Math.pow((x[i] - mean),2);
        }
        varianceVal = (1.0/(x.length))*(varianceVal);
        return varianceVal;
    }
}
