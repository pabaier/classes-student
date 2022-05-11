
/**
 * Calulates the MIN, MAX, MEAN, and Variance of a set of data.
 *
 * Steven Higgins

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
        var = variance(data, mean);
        
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        int i = 0;
        int j = 0;
        double smallest = 0.0;
        smallest = x[0];
        for(i = 0; i < x.length; i++) {
            for(j = 1; j < x.length; j++) {      
                if(smallest < x[j]){
                    smallest = smallest;             
                }
                else{
                    smallest = x[j];
        
                } 
            }      
        }
        return smallest;
    }
    public static double maximum(double [] x){
        int i = 0;
        int j = 0;
        double largest = 0.0;
        largest = x[i];
        for(i = 0; i < x.length; i++) {
            for(j = 1; j < x.length; j++) {                
                if(largest > x[j]){
                    largest = largest;             
                }
                else{
                    largest = x[j];
        
                } 
            }      
        }
        return largest;
    }
    public static double average(double [] x){
        int i = 0;
        double sum = 0.0;
        double mean = 0;
        for(i = 0; i < x.length; i++){
            sum = sum + x[i];
        }
        mean = sum / x.length;
        return mean;
    }
    public static double variance(double [] x, double avg) {
        int i = 0;
        double variance = 0.0;
        double sum = 0.0;
        
        for(i = 0; i < x.length; i++){
            sum = sum + ((x[i] - avg) * (x[i] - avg));
        }
        variance = (1/x.length) * sum;
        return variance;
    }
}