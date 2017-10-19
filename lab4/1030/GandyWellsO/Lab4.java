
/**
 * Finding different values.
 *
 * Orianna Gandy-Wells

 */

public class Lab4
{    
    public static void main(String [] args){
        double [] data = {3.2, 4.5, 10.4, -1.2, -2.3, 0.1, 6.7, 0.2, 12.2, -3.3};
        double min = minimum(data); 
        double max = maximum(data); 
        double mean = average(data); 
        double var = variance(data, average(data));
        System.out.printf("Min = %.3f, Max = %.3f, Mean = %.3f, Variance = %.3f",
              min, max, mean, var); 
    }
    
    // Finds and returns the minimum value in
    // an array of doubles
    public static double minimum (double [] x){
        int arrayLength = x.length;  
        double minimum = x[0];
        for(int i = 0; i < arrayLength; i++){
            if( minimum > x[i]){
                minimum = x[i];
            }
        }
        return minimum;
        
    }
    
    public static double maximum (double [] x){
        int arrayLength = x.length;  
        double maximum = x[0];
        for(int i = 0; i < arrayLength; i++){
            if( maximum < x[i]){
                maximum = x[i];
            }
        }
        return maximum;
        
    }
    
    public static double average (double [] x){
        double total = 0.0;
        double average = 0.0;
        int arrayLength = x.length;
        for(int i = 0; i  < arrayLength; i++){
           total = total + x[i];
        }
        average = total / arrayLength;
        return average;
    }
    
    public static double variance (double [] x, double avg){
    double variance = 0.0;
    double total = 0.0;
    int arrayLength = x.length;
    for(int i = 0; i < arrayLength; i++){
        total = Math.pow((x[i] - avg), 2) + total;
       }
       variance = (1.0/arrayLength * (total));
    return variance;
    }
}
