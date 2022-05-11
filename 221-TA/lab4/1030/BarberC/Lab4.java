
/**
 * Various methods which return minimum, maximum, average, and variance of an array of doubles
 *
 * Carson Barber

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
        for(int i = 0; i<x.length;i++){
            if(x[i]< smallest)smallest = x[i];
        }
        return smallest;
        
    }
    
    public static double maximum(double[] x){
        double largest = x[0];
        for(int i = 0; i<x.length;i++){
            if(x[i]> largest)largest = x[i];
        }
        return largest;
    }
    
    public static double average(double[] x){
        double sum = 0.0;
        for(int i = 0; i<x.length;i++){
            sum+=x[i];
        }
        sum /= x.length;
        return sum;
    }
    
    public static double variance(double[] x, double avg){
        double var = 0.0;
        for(int i = 0; i<x.length;i++){
            var+=Math.pow(x[i]-avg, 2);
        }
        var/=x.length;
        return var;
    }
}
