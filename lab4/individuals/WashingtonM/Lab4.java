
/**
 * Find min, max, mean, and var of array
 *
 * Mary Washington

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
        double min = 0.0;
        double smallest = 0.0;
        for (int i = 0; i < x.length; i++){
            if(x[i] < smallest){
                smallest = x[i];
                min = smallest;

            }
        }

        return min;
    }
    // Add other methods here.
    public static double maximum(double[] x){
        double max = 0.0;
        double largest = 0.0;
        for(int i = 0; i < x.length; i++){
            if(x[i] > largest){
                largest = x[i];
                max = largest;
            }

        }
        return max;
    }

    public static double average(double[] x){
        double sum = 0.0;
        double mean = 0.0;

        for(int i = 0; i < x.length; i++){
            sum = sum + x[i]; 
        }

        mean = (sum / x.length - 1);
        return mean;
    }

    public static double variance (double[] x, double avg){
        double var = 0.0;
        double n = x.length - 1;
        double total = 0.0;
        for(int i = 0; i < x.length; i++){
            total = total + Math.pow(2.0, x[i]);
            avg = average(x);
            var = (1/n) * total - avg;
            

        }
        return var;
    }

}
