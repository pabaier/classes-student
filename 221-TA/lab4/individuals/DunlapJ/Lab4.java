
/**
 * Find the min, max, avg, and variance of an array of double numbers
 *
 * Thomas Dunlap

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
        
        double min = x[0];
        int i = 0;
        
        for (i = 0; i < x.length; i++)
        {
            if (x[i] < min)
            {
                min = x[i];
            }
        }
        
        return min;
        
    }
    
    public static double maximum (double [] x) {
        
        double max = x[0];
        int i = 0;
        
        for (i = 0; i < x.length; i++)
        {
            if (x[i] > max)
            {
                max = x[i];
            }
        }
        
        return max;
   
    }
    
    public static double average (double [] x) {
        
        double mean = 0.0;
        int i = 0;
        double addedData = 0.0;
        
        for (i = 0; i < x.length; i++)
        {
            addedData = addedData + x[i];
        }
        
        mean = (addedData / x.length);
        
        return mean;
    }
            
    public static double variance (double [] x, double avg) {
        double var = 0.0;
        int i = 0;
        
        for (i = 0; i < (x.length - 1); i++)
        {
            // var = var + ((1/i) * ((x[i] - avg) * (x[i] - avg)));
        }
        
        return var;
        
    }
    
}
