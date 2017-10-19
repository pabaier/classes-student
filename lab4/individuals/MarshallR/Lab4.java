
/**
 * A program to find the min, max, average, and varience of a set of data using methods.
 *
 * Ricahrd Marshall

 */

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
        double min = x[0];
        for (double item : x) {
            
            if (item < min) {
                min = item;
            }
        }
        
        return min;
        
    }
    
    public static double maximum (double [] x){
        double max = x[0];
        for (double item : x) {
            
            if (item > max) {
                max = item;
            }
        }
        
        return max;
        
    }
    
    public static double average (double [] x) {
        double avg = 0.0;
        double sum = 0.0;
        
        for (double item : x) {
            sum += item;
        }
        
        avg = sum / ((double) x.length);
     
        return avg;
    }
    
    public static double variance (double [] x) {
        double vari = 0.0;
        
        for (double item : x) {
            vari += (item - average(x)) * (item - average(x));
        }
        
        vari = vari * (1.0 / ((double) x.length));
        
        return vari;
    }
   
}
